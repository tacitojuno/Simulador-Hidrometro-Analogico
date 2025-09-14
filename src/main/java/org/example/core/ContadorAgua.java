package org.example.core;

public class ContadorAgua {
    private double volumeTotal = 0.0;
    private long tempoInicio;
    private long ultimaAtualizacao;

    public ContadorAgua() {
        this.tempoInicio = System.currentTimeMillis();
        this.ultimaAtualizacao = tempoInicio;
    }

    public void adicionaVolume(double vazao, double estimativaAr) {
        long tempoAtual = System.currentTimeMillis();
        long deltaTempoMs = tempoAtual - ultimaAtualizacao;
        double deltaTempoSegundos = deltaTempoMs / 1000.0;

        if(deltaTempoSegundos > 0) {
            if (vazao > 0) {
                //Há água fluindo, sem ar
                double volumeAdicionado = vazao * deltaTempoSegundos;
                volumeTotal += volumeAdicionado;
            } else {
                //Sem água, mas o ar continua aumentando o contador
                double percentualArAtivo = Math.max(estimativaAr, 20.0); //Garantir um mínimo de 15% de ar quando não há água
                double volumeArSomente = (percentualArAtivo / 100.0) * 0.000167 * deltaTempoSegundos;
                volumeTotal += volumeArSomente;
            }

            if (volumeTotal > 0.999999) {
                System.out.println("O CONTADOR ATINGIU O LIMITE MÁXIMO");
                resetar();
            }
        }

        ultimaAtualizacao = tempoAtual;
    }

    public double getVolumeTotal() { return volumeTotal; }

    public void resetar() {
        volumeTotal = 0.0;
        tempoInicio = System.currentTimeMillis();
        ultimaAtualizacao = tempoInicio;
    }
}
