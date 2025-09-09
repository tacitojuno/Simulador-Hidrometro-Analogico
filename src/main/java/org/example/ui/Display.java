package org.example.ui;

import java.text.DecimalFormat;

public class Display {
    private DecimalFormat formatadorPressao = new DecimalFormat("#0.00");

    public void atualizarDisplay(double contadorAgua, double vazao, double pressao, double estimativaAr) {
        System.out.println("===============================");
        System.out.println("       SIMULADOR HIDROMETRO     ");
        System.out.println("===============================");

        // Formato tradicional: m³|centenas L|dezenas L|décimos L|litros
        String contadorFormatado = formatarContador(contadorAgua);
        System.out.println("Contador: " + contadorFormatado);

        System.out.println("Pressão: " + formatadorPressao.format(pressao) + " bar");
        System.out.println("Ar estimado: " + formatadorPressao.format(estimativaAr) + "%");

        String status = determinarStatus(vazao, pressao, estimativaAr);
        System.out.println("Status: " + status);

        System.out.println("===============================");
        System.out.println();
    }

    private String formatarContador(double volumeM3) {
        // Converter m³ para litros
        double volumeLitros = volumeM3 * 1000;

        // Separar as casas
        int m3 = (int) volumeM3; // Parte inteira dos m³
        double resto = volumeLitros - (m3 * 1000);

        int centenas = (int) (resto / 100);
        resto = resto - (centenas * 100);

        int dezenas = (int) (resto / 10);
        resto = resto - (dezenas * 10);

        int unidades = (int) resto;
        int decimos = (int) ((resto - unidades) * 10);

        return String.format("%04d|%01d|%01d|%01d|%01d", m3, centenas, dezenas, unidades, decimos);
    }

    private String determinarStatus(double vazao, double pressao, double estimativaAr) {
        if (vazao == 0 && pressao < 1.0) return "FALTA DE ÁGUA";
        if (estimativaAr > 10.0) return "ALERTA - AR NA TUBULAÇÃO";
        if (vazao > 0.00167) return "ALERTA - VAZAMENTO";
        if (pressao < 1.0) return "PRESSÃO BAIXA";
        if (vazao > 0) return "FUNCIONAMENTO NORMAL";
        return "SEM FLUXO";
    } //OBS: Status simplificado para console


}