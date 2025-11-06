package org.example;

import org.example.cliente.ClienteCLI;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando ClienteCLI...");
        System.out.println("-------------------------------------------------");

        // Chama o main verdadeiro, que agora está no ClienteCLI
        ClienteCLI.main(args);
    }
}