package application.Interface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;

import model.ListaNavios;

import java.awt.*;
import java.awt.event.*;

public class TelaCadastrarNavio extends JFrame {
    private JTextField nome;
    private JTextField velocidade;
    private JTextField autonomia;
    private JTextField custoPorMilha;
    private JButton cadastrar;
    private JButton limpa;
    private JLabel nomeStatus = new JLabel(); // Precisa ser instanciando antes se não pode dar uma execao
    private JLabel velocidadeStatus = new JLabel(); // na hora de apertar o botao limpar
    private JLabel autonomiaStatus = new JLabel();
    private JLabel custoPorMilhaStatus = new JLabel();

    public TelaCadastrarNavio() {
        super("Cadastrar Navio");
        this.setSize(345, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        setNome();

        setVelocidade();

        setAutonomia();

        setCustoPorMilha();

        setBotaoCadastrar();

        setBotaoLimpa();

        this.add(nomeStatus);

        this.add(velocidadeStatus);

        this.add(autonomiaStatus);

        this.add(custoPorMilhaStatus);
        setVisible(true);

    }

    /**
     * 
     * Define o textfield nome e o texto
     */
    private void setNome() {
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 10, 50, 20);
        this.add(nomeLabel);

        nome = new JTextField();
        nome.setBounds(135, 10, 200, 20);
        this.add(nome);
    }

    /**
     * Define o textfield velocidade e o texto
     */
    private void setVelocidade() {
        JLabel velocidadeLabel = new JLabel("Velocidade:");
        velocidadeLabel.setBounds(10, 40, 100, 20);
        this.add(velocidadeLabel);

        velocidade = new JTextField();
        velocidade.setBounds(135, 40, 200, 20);
        this.add(velocidade);
    }

    /**
     * Define o textfield autonomia e o texto
     */
    private void setAutonomia() {
        JLabel autonomiaLabel = new JLabel("Autonomia:");
        autonomiaLabel.setBounds(10, 70, 100, 20);
        this.add(autonomiaLabel);

        autonomia = new JTextField();
        autonomia.setBounds(135, 70, 200, 20);
        this.add(autonomia);
    }

    /**
     * Define o textfield custoPorMilha e o texto
     */
    private void setCustoPorMilha() {
        JLabel custoPorMilhaLabel = new JLabel("Custo por Milha:");
        custoPorMilhaLabel.setBounds(10, 100, 125, 20);
        this.add(custoPorMilhaLabel);

        custoPorMilha = new JTextField();
        custoPorMilha.setBounds(135, 100, 200, 20);
        this.add(custoPorMilha);
    }

    /**
     * Define o botao cadastrar e alem de dar uma funcao para ele
     */
    private void setBotaoCadastrar() {
        cadastrar = new JButton("Cadastrar");
        cadastrar.setBounds(10, 130, 125, 20);
        this.add(cadastrar);
        cadastrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String estouro = "Velocidade";

                try {
                    String nomeN = nome.getText();
                    double velocidadeN = Double.parseDouble(velocidade.getText());
                    estouro = "Autonomia";
                    double autonomiaN = Double.parseDouble(autonomia.getText());
                    estouro = "Custo por milha";

                    double custoPorMilhaN = Double.parseDouble(custoPorMilha.getText());
                    ListaNavios lista = ListaNavios.listaNavios();
                    lista.cadastrarNavio(nomeN, velocidadeN, autonomiaN, custoPorMilhaN);
                    setUltimoCadastro(nomeN, velocidadeN, autonomiaN, custoPorMilhaN);
                } catch (NumberFormatException f) {
                    JOptionPane.showMessageDialog(null, "Entrada invalida na parte de " + estouro + ", " + estouro
                            + " só aceita numeros positivos");
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }

            }
        });
    }

    /**
     * Define o borao limpar que limpa todas as areas digitaveis
     * e o texto do ultimo navio cadastrado
     */
    private void setBotaoLimpa() {
        limpa = new JButton("Limpar");
        limpa.setBounds(210, 130, 125, 20);
        this.add(limpa);
        limpa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                nome.setText("");
                velocidade.setText("");
                autonomia.setText("");
                custoPorMilha.setText("");
                nomeStatus.setText("");
                velocidadeStatus.setText("");
                autonomiaStatus.setText("");
                custoPorMilhaStatus.setText("");
            }
        });
    }

    /**
     * Escreve o ultimo navio que foi cadastrado
     */
    private void setUltimoCadastro(String nomeN, double velocidadeN, double autonomiaN, double custoPorMilhaN) {
        nomeStatus.setText("Nome do Navio: " + nomeN);
        nomeStatus.setBounds(10, 160, 335, 20);

        velocidadeStatus.setText("Velocidade: " + velocidadeN);
        velocidadeStatus.setBounds(10, 180, 335, 20);

        autonomiaStatus.setText("Autonomia:" + autonomiaN);
        autonomiaStatus.setBounds(10, 200, 335, 20);

        custoPorMilhaStatus.setText("Custo por milha basico:" + custoPorMilhaN);
        custoPorMilhaStatus.setBounds(10, 220, 335, 20);

    }

}
