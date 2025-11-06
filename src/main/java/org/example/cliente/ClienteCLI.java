package org.example.cliente;

import org.example.facade.SimuladorFacade;
import java.util.Scanner;

/**
 * Cliente (CLI - Command Line Interface) para operar o SimuladorFacade.
 * Esta classe agora contém o método main() e substitui o antigo Main.java.
 */
public class ClienteCLI {

    public static void main(String[] args) {

        // Obtém a instância da fachada
        SimuladorFacade facade = SimuladorFacade.getInstance();

        // Prepara o leitor de comandos
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Cliente CLI do Simulador de Hidrômetro ---");
        System.out.println("--- Digite 'criar 5' para iniciar 5 instâncias ---");
        exibirAjuda();

        boolean executando = true;

        while (executando) {
            System.out.print("\nComando> ");
            String linha = scanner.nextLine();
            String[] partes = linha.split(" ");
            String comando = partes.length > 0 ? partes[0].toLowerCase() : "";

            try {
                switch (comando) {
                    case "criar":
                        // Cria N instâncias
                        int num = 1;
                        if (partes.length > 1) {
                            num = Integer.parseInt(partes[1]);
                        }
                        System.out.println("Criando " + num + " simulador(es) com config padrão...");
                        for(int i = 0; i < num; i++) {
                            facade.criaSHA();
                        }
                        break;

                    case "parar":
                        if (partes.length < 2) {
                            System.out.println("Erro: parar <id_simulador>");
                            break;
                        }
                        // ex: parar Simulador-1
                        facade.finalizaSHA(partes[1]);
                        break;

                    case "vazao":
                        if (partes.length < 3) {
                            System.out.println("Erro: vazao <id_simulador> <vazao_m3s>");
                            break;
                        }
                        // ex: vazao Simulador-1 0.0015
                        facade.modificaVazaoSHA(partes[1], Double.parseDouble(partes[2]));
                        break;

                    case "imagem":
                        if (partes.length < 3) {
                            System.out.println("Erro: imagem <id_simulador> <true|false>");
                            break;
                        }
                        // ex: imagem Simulador-1 false
                        facade.habilitaGeraçaoImagemSHA(partes[1], Boolean.parseBoolean(partes[2]));
                        break;

                    case "config":
                        if (partes.length < 3) {
                            System.out.println("Erro: config <intervalo_ms> <prob_falta_agua>");
                            break;
                        }
                        // ex: config 500 0.5 (Muda config padrão para futuras instâncias)
                        facade.configSimuladorSHA(Integer.parseInt(partes[1]), Double.parseDouble(partes[2]));
                        break;

                    case "listar":
                        facade.listarSimuladores();
                        break;

                    case "ajuda":
                        exibirAjuda();
                        break;

                    case "sair":
                        facade.finalizaTodos();
                        System.out.println("Saindo.");
                        executando = false;
                        break;

                    default:
                        if (!comando.isEmpty()) {
                            System.out.println("Comando desconhecido: '" + comando + "'. Digite 'ajuda'.");
                        }
                }
            } catch (Exception e) {
                System.out.println("Erro ao processar comando: " + e.getMessage());
                e.printStackTrace();
            }
        }

        scanner.close();
        // Garante que o programa feche, já que as janelas Swing podem segurar a JVM
        System.exit(0);
    }

    private static void exibirAjuda() {
        System.out.println("Comandos disponíveis:");
        System.out.println("  criar [N]                - Cria [N] simuladores (padrao 1).");
        System.out.println("  parar <id_simulador>     - Finaliza o simulador com o ID (ex: Simulador-1).");
        System.out.println("  vazao <id> <vazao>       - Modifica a vazao manual (em m³/s) do simulador.");
        System.out.println("  imagem <id> <true|false> - Habilita/desabilita a geração de imagens.");
        System.out.println("  config <int> <prob>      - Altera a config padrao p/ *futuros* simuladores.");
        System.out.println("  listar                   - Lista todos os simuladores ativos.");
        System.out.println("  ajuda                    - Exibe esta mensagem.");
        System.out.println("  sair                     - Finaliza todos os simuladores e sai.");
    }
}