package org.example;

import org.example.config.Configuracao;
import org.example.core.Hidrometro;
import org.example.ui.JanelaHidrometro;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando simulação do hidrômetro...");

        Hidrometro hidrometro = new Hidrometro();
        Configuracao configuracao = new Configuracao();
        JanelaHidrometro janela = new JanelaHidrometro(hidrometro, configuracao);

        janela.exibir();
        System.out.println("Interface gráfica iniciada.");

        try{
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        hidrometro.parar();
        System.out.println("Simulação encerrada.");
    }
}