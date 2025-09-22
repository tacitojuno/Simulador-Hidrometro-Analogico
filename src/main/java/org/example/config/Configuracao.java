package org.example.config;

import java.io.*;
import java.util.Properties;

public class Configuracao {
    private static final String ARQUIVO_CONFIG = "data/parametros.txt";

    //Valores de Referência
    private double vazaoMaxima = 0.00167;      //100 L/min = 0.00167 m³/s
    private double vazaoMinima = 0.0;
    private double limiteAr = 10.0;
    private double estimativaArMaxima = 20.0;
    private double vazaoAgua = 0.000833;       //50 L/min = 0.000833 m³/s
    private double pressao = 2.5;
    private double limiteDeteccaoAr = 0.00133; //80 L/min = 0.00133 m³/s
    private double probabilidadeFaltaAgua = 0.1; //10%
    private long duracaoMinimaFaltaAgua = 5000;   //5 segundos
    private long duracaoMaximaFaltaAgua = 10000;   //10 segundos
    private int intervaloAtualizacao = 1000;
    private boolean gerarCapturas = true;
    private double intervaloCaptuas = 1.0;

    public Configuracao() {
        carregarParametros();
    }

    private void carregarParametros() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(ARQUIVO_CONFIG)) {
            props.load(fis);

            //Carrega Parâmetros
            vazaoMaxima = Double.parseDouble(props.getProperty("vazao.maxima", "0.00167"));
            vazaoMinima = Double.parseDouble(props.getProperty("vazao.minima", "0.0"));
            limiteAr = Double.parseDouble(props.getProperty("limite.ar", "10.0"));
            estimativaArMaxima = Double.parseDouble(props.getProperty("estimativa.ar.maxima", "20.0"));
            vazaoAgua = Double.parseDouble(props.getProperty("vazao.agua", "0.000833"));
            pressao = Double.parseDouble(props.getProperty("pressao", "2.5"));
            limiteDeteccaoAr = Double.parseDouble(props.getProperty("limite.deteccao.ar", "0.00133"));
            probabilidadeFaltaAgua = Double.parseDouble(props.getProperty("probabilidade.falta.agua", "0.01"));
            duracaoMinimaFaltaAgua = Long.parseLong(props.getProperty("duracao.minima.falta.agua", "5000"));
            duracaoMaximaFaltaAgua = Long.parseLong(props.getProperty("duracao.maxima.falta.agua", "7000"));
            intervaloAtualizacao = Integer.parseInt(props.getProperty("intervalo.atualizacao", "1000"));
            gerarCapturas = Boolean.parseBoolean(props.getProperty("gerar.capturas", "true"));
            intervaloCaptuas = Double.parseDouble(props.getProperty("intervalo.capturas", "1.0"));

            System.out.println("Parâmetros carregados do arquivo: " + ARQUIVO_CONFIG);

        } catch (IOException e) {
            System.out.println("Usando valores de referência. Arquivo não encontrado: " + ARQUIVO_CONFIG);
            criarArquivoExemplo();
        }
    }

    //Somente cria um arquivo de exemplo se o arquivo de configuração não existir
    private void criarArquivoExemplo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO_CONFIG))) {
            writer.println("# Configurações do Hidrômetro (valores em m³/s)");
            writer.println("");
            writer.println("#Config Pressão");
            writer.println("pressao=2.5");
            writer.println("");
            writer.println("#Config Vazão (m³/s)");
            writer.println("vazao.agua=0.000833");
            writer.println("vazao.maxima=0.00167");
            writer.println("vazao.minima=0.0");
            writer.println("");
            writer.println("#Config Ar (%)");
            writer.println("limite.ar=10.0");
            writer.println("estimativa.ar.maxima=20.0");
            writer.println("limite.deteccao.ar=0.00133");
            writer.println("");
            writer.println("#Config Falta de Água");
            writer.println("probabilidade.falta.agua=0.01");
            writer.println("duracao.minima.falta.agua=5000");
            writer.println("duracao.maxima.falta.agua=7000");
            writer.println("");
            writer.println("#Janela do Hidrômetro (Atualização de Imagem)");
            writer.println("intervalo.atualizacao=1000");
            writer.println("");
            writer.println("#Configuração de Capturas de Imagens JPEG");
            writer.println("gerar.capturas=true");
            writer.println("intervalo.capturas=1.0");
            System.out.println("Arquivo de exemplo criado: " + ARQUIVO_CONFIG);
        } catch (IOException e) {
            System.err.println("Erro ao criar arquivo de configuração: " + e.getMessage());
        }
    }

    public double getVazaoMaxima() { return vazaoMaxima; }
    public double getVazaoMinima() { return vazaoMinima; }
    public double getLimiteAr() { return limiteAr; } //Implementação a se pensar... Provavelmente não utilizado
    public double getEstimativaArMaxima() { return estimativaArMaxima; }
    public double getVazaoAgua() { return vazaoAgua; }
    public double getPressao() { return pressao; }
    public double getLimiteDeteccaoAr() { return limiteDeteccaoAr; }
    public double getProbabilidadeFaltaAgua() { return probabilidadeFaltaAgua; }
    public long getDuracaoMinimaFaltaAgua() { return duracaoMinimaFaltaAgua; }
    public long getDuracaoMaximaFaltaAgua() { return duracaoMaximaFaltaAgua; }
    public int getIntervaloAtualizacao() { return intervaloAtualizacao; }
    public boolean isGerarCapturas() { return gerarCapturas; }
    public double getIntervaloCapturas() { return intervaloCaptuas; }
}