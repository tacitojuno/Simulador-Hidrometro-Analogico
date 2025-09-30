package org.example;

public class Main {
    public static void main(String[] args) {
        // Define a quantidade de instâncias
        final int NUMERO_DE_SIMULADORES = 5;

        System.out.println("Iniciando " + NUMERO_DE_SIMULADORES + " simuladores em threads separadas");

        for (int i = 0; i < NUMERO_DE_SIMULADORES; i++) {

            // Cria uma nova tarefa do simulador
            SimuladorRunnable simuladorTask = new SimuladorRunnable();

            // Cria uma nova thread para executar essa tarefa
            Thread threadDoSimulador = new Thread(simuladorTask);

            threadDoSimulador.setName("Simulador-" + (i + 1));

            // Inicia a thread.
            threadDoSimulador.start();
        }
    }
}