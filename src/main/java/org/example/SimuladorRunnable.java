package org.example;

import org.example.config.Configuracao;
import org.example.core.Hidrometro;
import org.example.ui.JanelaHidrometro;

public class SimuladorRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Iniciando uma nova instância do simulador na thread: " + Thread.currentThread().getName());

        Hidrometro hidrometro = new Hidrometro();
        Configuracao configuracao = new Configuracao();
        JanelaHidrometro janela = new JanelaHidrometro(hidrometro, configuracao);

        janela.exibir();
        System.out.println("Interface gráfica iniciada para a thread: " + Thread.currentThread().getName());
    }
}
