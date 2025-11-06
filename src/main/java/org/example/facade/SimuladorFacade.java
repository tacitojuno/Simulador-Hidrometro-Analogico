package org.example.facade;

import org.example.config.Configuracao;
import org.example.core.Hidrometro;
import org.example.ui.JanelaHidrometro;
import org.example.SimuladorRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Classe auxiliar interna para armazenar as referências de uma instância de simulação.
 */
class InstanciaSHA {
    Thread thread;
    SimuladorRunnable runnable;

    InstanciaSHA(Thread thread, SimuladorRunnable runnable) {
        this.thread = thread;
        this.runnable = runnable;
    }

    /**
     * Rotina para parar todos os componentes da simulação de forma controlada.
     */
    public void parar() {
        // 1. Para o scheduler interno (atualizações) do hidrômetro
        if (runnable.getHidrometro() != null) {
            runnable.getHidrometro().parar();
        }
        // 2. Para o timer da janela (renderização) e fecha a janela
        if (runnable.getJanela() != null) {
            runnable.getJanela().pararAtualizacao();
            runnable.getJanela().dispose(); // Fecha a janela (definida como DISPOSE_ON_CLOSE)
        }
        // 3. Interrompe a thread principal da simulação
        if (thread != null && thread.isAlive()) {
            thread.interrupt();
        }
    }
}


/**
 * Fachada Singleton para gerenciar o ciclo de vida de múltiplos
 * Simuladores de Hidrômetro Analógico (SHA).
 */
public class SimuladorFacade {

    private static SimuladorFacade instancia;

    /**
     * Ponto de acesso global para a instância Singleton.
     */
    public static synchronized SimuladorFacade getInstance() {
        if (instancia == null) {
            instancia = new SimuladorFacade();
        }
        return instancia;
    }

    private final Map<String, InstanciaSHA> simuladoresAtivos;
    private final AtomicInteger contadorIds;
    private Configuracao configPadraoGlobal;

    /**
     * Construtor privado (Singleton).
     */
    private SimuladorFacade() {
        this.simuladoresAtivos = new HashMap<>();
        this.contadorIds = new AtomicInteger(0);
        // Carrega a configuração padrão do arquivo data/parametros.txt
        this.configPadraoGlobal = new Configuracao();
    }


    /**
     * Define a configuração *padrão* que será usada para *futuras*
     * instâncias criadas com criaSHA().
     *
     * @param intervaloAtualizacao Intervalo (ms) do passo de simulação.
     * @param probFaltaAgua Probabilidade (0.0 a 1.0) de falta de água.
     */
    public void configSimuladorSHA(int intervaloAtualizacao, double probFaltaAgua) {
        // Cria uma nova configuração baseada nos padrões de arquivo
        Configuracao novaConfig = new Configuracao();

        // Sobrescreve os parâmetros informados
        novaConfig.setIntervaloAtualizacao(intervaloAtualizacao);
        novaConfig.setProbabilidadeFaltaAgua(probFaltaAgua);

        this.configPadraoGlobal = novaConfig;
        System.out.println("[Fachada] Configuração padrão global atualizada.");
    }

    /**
     * Coloca para executar uma única instância do SHA com a configuração padrão global.
     * Retorna o ID da instância criada.
     */
    public String criaSHA() {
        // Delega para o método de criação usando a configuração padrão atual
        return criaSHA(this.configPadraoGlobal);
    }

    /**
     * Sobrecarga de criaSHA para aceitar uma configuração específica para esta instância.
     * Retorna o ID da instância criada.
     */
    public String criaSHA(Configuracao config) {
        // Copia a configuração para garantir que esta instância tenha a sua própria
        Configuracao configInstancia = new Configuracao();
        configInstancia.setIntervaloAtualizacao(config.getIntervaloAtualizacao());
        configInstancia.setProbabilidadeFaltaAgua(config.getProbabilidadeFaltaAgua());
        configInstancia.setVazaoAgua(config.getVazaoAgua());
        configInstancia.setGerarCapturas(config.isGerarCapturas());


        String id = "Simulador-" + contadorIds.incrementAndGet();
        System.out.println("[Fachada] Criando " + id + "...");

        // 1. Cria o Runnable com a configuração e ID
        SimuladorRunnable runnable = new SimuladorRunnable(id, configInstancia);

        // 2. Cria a Thread
        Thread thread = new Thread(runnable);
        thread.setName(id);

        // 3. Armazena as referências para controle futuro
        simuladoresAtivos.put(id, new InstanciaSHA(thread, runnable));

        // 4. Inicia a simulação
        thread.start();

        System.out.println("[Fachada] " + id + " iniciado.");
        return id;
    }

    /**
     * Finaliza a execução de uma dada instância do SHA.
     * @param id O ID do simulador (ex: "Simulador-1").
     */
    public void finalizaSHA(String id) {
        InstanciaSHA instancia = simuladoresAtivos.get(id);
        if (instancia != null) {
            System.out.println("[Fachada] Finalizando " + id + "...");
            instancia.parar();
            simuladoresAtivos.remove(id);
            System.out.println("[Fachada] " + id + " finalizado.");
        } else {
            System.out.println("[Fachada] Erro: Simulador " + id + " não encontrado.");
        }
    }

    /**
     * Altera o valor da vazão (manual) de uma instância SHA.
     * @param id O ID do simulador (ex: "Simulador-1").
     * @param novaVazaoM3s A nova vazão em m³/s.
     */
    public void modificaVazaoSHA(String id, double novaVazaoM3s) {
        InstanciaSHA instancia = simuladoresAtivos.get(id);

        if (instancia == null) {
            System.out.println("[Fachada] Erro: " + id + " nao encontrado.");
            return;
        }

        // Espera rápida caso a thread ainda não tenha inicializado o hidrômetro
        if (instancia.runnable.getHidrometro() == null) {
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }

        // Verifica se a instância existe e se o hidrômetro já foi inicializado
        if (instancia.runnable.getHidrometro() != null) {
            instancia.runnable.getHidrometro().setVazaoManual(novaVazaoM3s);
            System.out.println("[Fachada] Vazão de " + id + " alterada para " + novaVazaoM3s + " m³/s.");
        } else {
            System.out.println("[Fachada] Erro: " + id + " não pôde ser controlado (ainda não inicializado).");
        }
    }

    /**
     * Habilita ou desabilita a geração das imagens de uma dada instância.
     * @param id O ID do simulador (ex: "Simulador-1").
     * @param habilitar true para habilitar, false para desabilitar.
     */
    public void habilitaGeraçaoImagemSHA(String id, boolean habilitar) {
        InstanciaSHA instancia = simuladoresAtivos.get(id);

        if (instancia == null) {
            System.out.println("[Fachada] Erro: " + id + " não encontrado.");
            return;
        }

        if (instancia.runnable.getConfiguracao() != null) {
            instancia.runnable.getConfiguracao().setGerarCapturas(habilitar);
            System.out.println("[Fachada] Geração de imagens " + (habilitar ? "HABILITADA" : "DESABILITADA") + " para " + id + ".");
        } else {
            System.out.println("[Fachada] Erro: " + id + " não possui configuracao acessível.");
        }
    }

    // --- Métodos Auxiliares para o CLI ---

    /**
     * Finaliza todas as instâncias ativas.
     */
    public void finalizaTodos() {
        System.out.println("[Fachada] Finalizando todos os simuladores...");
        // Itera sobre uma cópia das chaves para evitar ConcurrentModificationException
        for (String id : new java.util.HashSet<>(simuladoresAtivos.keySet())) {
            finalizaSHA(id);
        }
        System.out.println("[Fachada] Todos os simuladores finalizados.");
    }

    /**
     * Lista os IDs de todos os simuladores ativos.
     */
    public void listarSimuladores() {
        if (simuladoresAtivos.isEmpty()) {
            System.out.println("[Fachada] Nenhum simulador ativo.");
            return;
        }
        System.out.println("[Fachada] Simuladores ativos:");
        for (String id : simuladoresAtivos.keySet()) {
            System.out.println("  - " + id);
        }
    }
}