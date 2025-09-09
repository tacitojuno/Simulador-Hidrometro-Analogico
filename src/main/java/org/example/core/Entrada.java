package org.example.core;

import org.example.config.Configuracao;

public class Entrada {
    private double vazao = 0.0;
    private double pressao = 0.0;
    private Configuracao configuracao;

    public Entrada(Configuracao configuracao) {
        this.configuracao = configuracao;
    }

    public void setVazao(double vazao) {
        if (vazao >= configuracao.getVazaoMinima() && vazao <= configuracao.getVazaoMaxima()) { // Limite ajustado para m³/s
            this.vazao = vazao;
        }
    }

    public void setPressao(double pressao) {
        this.pressao = Math.max(0, pressao);
    }

    public double getVazao() {
        return vazao;
    }
    public double getPressao() { return pressao; }
}