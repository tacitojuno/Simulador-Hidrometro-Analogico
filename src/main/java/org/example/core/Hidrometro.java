package org.example.core;

import org.example.config.Configuracao;
import org.example.ui.Display;

import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Hidrometro {
    private ContadorAgua contadorAgua;
    private Display display;
    private Entrada entrada;
    private Configuracao configuracao;

    private double vazaoAtual = 0.0;
    private double pressaoAtual = 0.0;
    private double estimativaAr = 0.0;
    private boolean faltandoAgua = false;

    private long inicioFaltaAgua = 0;
    private long duracaoFaltaAgua = 0;

    private boolean modoManualVazao = false;
    private double vazaoManual = 0.0;

    private Random random = new Random();
    private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public Hidrometro() {
        this.contadorAgua = new ContadorAgua();
        this.display = new Display();
        this.configuracao = new Configuracao();
        this.entrada = new Entrada(configuracao);
        inicializarParametros();
        iniciarSimulacao();
    }

    private void inicializarParametros() {
        vazaoAtual = configuracao.getVazaoAgua();
        pressaoAtual = configuracao.getPressao();
        entrada.setVazao(vazaoAtual);
        entrada.setPressao(pressaoAtual);
    }

    private void iniciarSimulacao() {
        int intervaloAtualizacao = configuracao.getIntervaloAtualizacao();
        scheduler.scheduleAtFixedRate(this::atualizarContador, 0, intervaloAtualizacao, TimeUnit.MILLISECONDS);
        scheduler.scheduleAtFixedRate(this::simularCondicoes, 0, intervaloAtualizacao, TimeUnit.MILLISECONDS);
    }

    private double aplicarCorrecaoAr(double vazao) {
        return vazao * 0.95; //Reduz 5% devido ao ar (Valor abitrário)
    }

    private void atualizarContador() {
        vazaoAtual = entrada.getVazao();
        pressaoAtual = entrada.getPressao();

        if (verificarPassagemAr()) {
            vazaoAtual = aplicarCorrecaoAr(vazaoAtual);
        }

        contadorAgua.adicionaVolume(vazaoAtual, estimativaAr);

        atualizarEstimativaAr();
        display.atualizarDisplay(contadorAgua.getVolumeTotal(), vazaoAtual, pressaoAtual, estimativaAr);
    }

    private void atualizarEstimativaAr() {
        if (faltandoAgua) {
            estimativaAr = Math.min(configuracao.getEstimativaArMaxima(),
                    estimativaAr + random.nextDouble() * 2.0);
        } else {
            estimativaAr = Math.max(0, estimativaAr - random.nextDouble() * 0.5);
        }
    }

    private boolean verificarPassagemAr() {
        return vazaoAtual > configuracao.getLimiteDeteccaoAr() || estimativaAr > 5.0;
    }

    public void setVazaoManual(double vazao) {
        this.vazaoManual = Math.max(0, Math.min(vazao, configuracao.getVazaoMaxima()));
        this.modoManualVazao = true;
        entrada.setVazao(vazaoManual);

        System.out.println("Vazão alterada manualmente para: " + vazaoManual + " m³/s");
    }

    public void desativarModoManual() {
        modoManualVazao = false;
        System.out.println("Modo manual desativado. Retornando ao modo automático.");
    }

    private void simularCondicoes() {
        long tempoAtual = System.currentTimeMillis();

        //Verificar se falta de água deve continuar
        if (faltandoAgua) {
            long tempoDecorrido = tempoAtual - inicioFaltaAgua;
            if (tempoDecorrido >= duracaoFaltaAgua) {
                faltandoAgua = false;
                System.out.println("FALTA DE ÁGUA RESOLVIDA após " + (tempoDecorrido/1000) + " segundos");
            }
        } else {
            //Verificar se deve iniciar nova falta de água
            if (random.nextDouble() < configuracao.getProbabilidadeFaltaAgua()) {
                faltandoAgua = true;
                inicioFaltaAgua = tempoAtual;

                //Duração aleatória entre min e max configurados
                long duracaoMin = configuracao.getDuracaoMinimaFaltaAgua();
                long duracaoMax = configuracao.getDuracaoMaximaFaltaAgua();
                duracaoFaltaAgua = duracaoMin + (long)(random.nextDouble() * (duracaoMax - duracaoMin));

                System.out.println("INICIADA FALTA DE ÁGUA - Duração prevista: " + (duracaoFaltaAgua/1000) + " segundos");
            }
        }

        //Aplicar efeitos baseadas no estado (falta ou não de água)
        if (faltandoAgua) {
            vazaoAtual = 0;
            pressaoAtual = Math.max(0, configuracao.getPressao() * 0.2); //Reduz pressão em 80%
            entrada.setVazao(vazaoAtual);
        } else {
            if (!modoManualVazao) {
                double variacao = (random.nextDouble() - 0.5) * 0.0006;
                vazaoAtual = Math.max(0, configuracao.getVazaoAgua() + variacao);
                entrada.setVazao(vazaoAtual);
            }

            double variacaoPressao = (random.nextDouble() - 0.5);
            pressaoAtual = Math.max(0, configuracao.getPressao() + variacaoPressao);
        }

        entrada.setPressao(pressaoAtual);
    }

    public void parar() {
        scheduler.shutdown();
    }

    public double getVolumeTotal() { return contadorAgua.getVolumeTotal(); }
    public double getVazaoAtual() { return vazaoAtual; }
    public double getPressaoAtual() { return pressaoAtual; }
    public double getEstimativaAr() { return estimativaAr; }
    public boolean isModoManualVazao() { return modoManualVazao; }
}