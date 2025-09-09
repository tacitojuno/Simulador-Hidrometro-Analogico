package org.example.ui;

import org.example.config.Configuracao;
import org.example.core.Hidrometro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JanelaHidrometro extends JFrame {
    private Hidrometro hidrometro;
    private Configuracao configuracao;
    private Timer timer;
    private BufferedImage imagemHidrometro;
    private JLabel labelImagem;
    private DecimalFormat formatador = new DecimalFormat("00000000");
    private DecimalFormat formatadorPressao = new DecimalFormat("#0.00");

    public JanelaHidrometro(Hidrometro hidrometro, Configuracao configuracao) {
        this.hidrometro = hidrometro;
        this.configuracao = configuracao;
        carregarImagemBase();
        inicializarInterface();
        iniciarAtualizacao();
    }

    private void carregarImagemBase() {
        try {
            // Carregar sua imagem base do hidrômetro
            BufferedImage imagemOriginal = ImageIO.read(new File("src/main/resources/BaseHidrometro/imagem_fundo.png"));

            int maxLargura = 645;
            int maxAltura = 545;

            double proporcaoOriginal = (double) imagemOriginal.getWidth() / imagemOriginal.getHeight();

            int novaLargura, novaAltura;
            if (imagemOriginal.getWidth() > imagemOriginal.getHeight()) {
                novaLargura = maxLargura;
                novaAltura = (int) (maxLargura / proporcaoOriginal);
            } else {
                novaAltura = maxAltura;
                novaLargura = (int) (maxAltura / proporcaoOriginal);
            }

            //Mantém proporção apoós redimencionar
            this.imagemHidrometro = new BufferedImage(novaLargura, novaAltura, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = imagemHidrometro.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.drawImage(imagemOriginal, 0, 0, novaLargura, novaAltura, null);
            g2d.dispose();

            setSize(novaLargura + 50, novaAltura + 100);

        } catch (Exception e) {
            System.err.println("Erro ao carregar imagem: " + e.getMessage());
            // Criar imagem padrão se não encontrar
            imagemHidrometro = new BufferedImage(500, 400, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = imagemHidrometro.createGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 500, 400);
            g.setColor(Color.BLACK);
            g.drawString("Imagem não encontrada", 200, 200);
            g.dispose();
        }
    }

    private void inicializarInterface() {
        setTitle("Hidrômetro Digital - Visualização com Imagem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new BorderLayout());

        // Painel da imagem
        labelImagem = new JLabel();
        labelImagem.setHorizontalAlignment(SwingConstants.CENTER);
        add(labelImagem, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                pararAtualizacao();
                hidrometro.parar();
                System.exit(0);
            }
        });
    }

    private void iniciarAtualizacao() {
        timer = new Timer(configuracao.getIntervaloAtualizacao(), e -> atualizarInterface());
        timer.start();
    }

    private void atualizarInterface() {
        // Criar cópia da imagem base
        BufferedImage imagemAtualizada = new BufferedImage(
                imagemHidrometro.getWidth(),
                imagemHidrometro.getHeight(),
                BufferedImage.TYPE_INT_RGB
        );

        Graphics2D g2d = imagemAtualizada.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Desenhar imagem base
        g2d.drawImage(imagemHidrometro, 0, 0, null);

        // Sobrepor dados atuais
        desenharDadosAtuais(g2d);

        g2d.dispose();

        // Atualizar label
        labelImagem.setIcon(new ImageIcon(imagemAtualizada));
    }

    private void desenharDadosAtuais(Graphics2D g2d) {
        double volume = hidrometro.getVolumeTotal();
        double vazao = hidrometro.getVazaoAtual();
        double pressao = hidrometro.getPressaoAtual();
        double estimativaAr = hidrometro.getEstimativaAr();

        // Coordenadas onde desenhar os dados (ajuste conforme sua imagem)

        // Contador principal (6 dígitos)
        String volumeFormatado = formatador.format((long)(volume * 1000000));
        String digitosPrincipais = volumeFormatado.length() >= 6 ?
                volumeFormatado.substring(0, 6) : String.format("%06d", 0);

        g2d.setColor(new Color(255, 0, 0));
        g2d.setFont(new Font("Arial", Font.BOLD, 33));

        int xInicial = 259; // Ajuste conforme necessário
        int espacamento = 23; // Espaçamento entre dígitos
        for (int i = 0; i < digitosPrincipais.length(); i++) {
            char digito = digitosPrincipais.charAt(i);
            g2d.drawString(String.valueOf(digito), xInicial + (i*espacamento), 213);
        }

        // Pressão
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 12));
        g2d.drawString("Pressão: " + formatadorPressao.format(pressao) + " bar", 200, 272);

        // Estimativa de ar
        g2d.drawString("Ar: " + formatadorPressao.format(estimativaAr) + "%", 220, 298);

        // Status
        String status = determinarStatus(vazao, pressao, estimativaAr);
        Color corStatus = determinarCorStatus(vazao, pressao, estimativaAr);

        g2d.setColor(corStatus);
        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        g2d.drawString("Status: " + status, 210, 470);

        // Horário
        g2d.setColor(Color.BLUE);
        g2d.setFont(new Font("Arial", Font.PLAIN, 10));
        String horario = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        g2d.drawString(horario, 400, 20);

        // Ponteiros (se sua imagem tiver relógios)
        desenharPonteiros(g2d, volume);
    }

    private void desenharPonteiros(Graphics2D g2d, double volume) {
        // Exemplo para ponteiros circulares
        String volumeStr = formatador.format((long)(volume * 1000000));

        if (volumeStr.length() > 5) {
            int digitoDecimo = Character.getNumericValue(volumeStr.charAt(6));
            posicaoPonteiros(g2d, 407, 297, digitoDecimo, 21); // Coordenadas do 1º relógio
        }

        if (volumeStr.length() > 6) {
            int digitoCentesimo = Character.getNumericValue(volumeStr.charAt(7));
            posicaoPonteiros(g2d, 325, 339, digitoCentesimo, 21); // Coordenadas do 2º relógio
        }
    }

    private void posicaoPonteiros(Graphics2D g2d, int eixoX, int eixoY, int digito, int comprimento) {
        double angle = Math.toRadians(digito * 36 - 90);
        int pontX = eixoX + (int)(comprimento * Math.cos(angle));
        int pontY = eixoY + (int)(comprimento * Math.sin(angle));

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(eixoX, eixoY, pontX, pontY);
    }

    private String determinarStatus(double vazao, double pressao, double estimativaAr) {
        if (vazao == 0 && pressao < 1.0) return "FALTA DE ÁGUA";
        if (estimativaAr > 10.0) return "ALERTA - AR NA TUBULAÇÃO";
        if (vazao > 0.00167) return "ALERTA - VAZAMENTO";
        if (pressao < 1.0) return "PRESSÃO BAIXA";
        if (vazao > 0) return "FUNCIONAMENTO NORMAL";
        return "SEM FLUXO";
    }

    private Color determinarCorStatus(double vazao, double pressao, double estimativaAr) {
        if (vazao == 0 && pressao < 1.0) return Color.RED;
        if (estimativaAr > 10.0) return Color.RED;
        if (vazao > 0.00133) return Color.RED;
        if (pressao < 1.0) return Color.ORANGE;
        if (vazao > 0) return Color.GREEN;
        return Color.GRAY;
    }

    public void pararAtualizacao() {
        if (timer != null) timer.stop();
    }

    public void exibir() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }
}