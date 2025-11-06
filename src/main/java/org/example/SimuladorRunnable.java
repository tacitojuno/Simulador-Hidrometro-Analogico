package org.example;

import org.example.config.Configuracao;
import org.example.core.Hidrometro;
import org.example.ui.JanelaHidrometro;

public class SimuladorRunnable implements Runnable {

    // Referências necessárias para a Fachada
    private final String id;
    private final Configuracao configuracao;
    private Hidrometro hidrometro;
    private JanelaHidrometro janela;


    /**
     * Construtor que recebe a configuração e um ID (vindo da Façade).
     */
    public SimuladorRunnable(String id, Configuracao configuracao) {
        this.id = id;
        this.configuracao = configuracao;
    }

    @Override
    public void run() {
        System.out.println("[" + id + "] Iniciando instância do simulador na thread: " + Thread.currentThread().getName());

        try {
            // 1. Cria o núcleo (passando a configuração)
            this.hidrometro = new Hidrometro(this.configuracao);

            // 2. Cria a interface gráfica
            this.janela = new JanelaHidrometro(this.hidrometro, this.configuracao);

            // Altera o título da janela para incluir o ID
            this.janela.setTitle(this.janela.getTitle() + " - " + id);

            // 3. Exibe a janela
            this.janela.exibir();

            System.out.println("[" + id + "] Interface gráfica iniciada.");

        } catch (Exception e) {
            System.err.println("[" + id + "] Erro ao inicializar o simulador: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // --- GETTERS (Novos - Corrigem o erro da sua imagem) ---

    public Hidrometro getHidrometro() {
        return hidrometro;
    }

    public JanelaHidrometro getJanela() {
        return janela;
    }

    public Configuracao getConfiguracao() {
        return configuracao;
    }

    public String getId() {
        return id;
    }
}