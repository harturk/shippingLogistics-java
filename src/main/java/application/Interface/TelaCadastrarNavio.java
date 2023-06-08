package application.Interface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.ListaNavios;

import java.awt.*;
import java.awt.event.*;


public class TelaCadastrarNavio extends JFrame{
    private JTextField nome;
    private JTextField velocidade;
    private JTextField autonomia;
    private JTextField custoPorMilha;
    private JButton cadastrar;
    

    public TelaCadastrarNavio() {
        JFrame frame = new JFrame("Cadastrar Navio");
        this.setTitle("Cadastrar Navio");
        this.setSize(400, 300);
        
        this.setBounds(100, 100, 500, 300);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 10, 50, 20);
        this.add(nomeLabel);

        nome = new JTextField();
        nome.setBounds(135, 10, 200, 20);
        this.add(nome);

        JLabel velocidadeLabel = new JLabel("Velocidade:");
        velocidadeLabel.setBounds(10, 40, 100, 20);
        this.add(velocidadeLabel);

        velocidade = new JTextField();
        velocidade.setBounds(135, 40, 200, 20);
        this.add(velocidade);

        JLabel autonomiaLabel = new JLabel("Autonomia:");
        autonomiaLabel.setBounds(10, 70, 100, 20);
        this.add(autonomiaLabel);

        autonomia = new JTextField();
        autonomia.setBounds(135, 70, 200, 20);
        this.add(autonomia);

        JLabel custoPorMilhaLabel = new JLabel("Custo por Milha:");
        custoPorMilhaLabel.setBounds(10, 100, 125, 20);
        this.add(custoPorMilhaLabel);

        custoPorMilha = new JTextField();
        custoPorMilha.setBounds(135, 100, 200, 20);
        this.add(custoPorMilha);

        cadastrar = new JButton("Cadastrar");
        cadastrar.setBounds(10, 130, 125, 20);
        this.add(cadastrar);
        cadastrar.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeN = nome.getText();
                try {
                double velocidadeN = Double.parseDouble(velocidade.getText());
                double autonomiaN = Double.parseDouble(autonomia.getText());
                double custoPorMilhaN = Double.parseDouble(custoPorMilha.getText());    
                ListaNavios lista = ListaNavios.listaNavios();
                lista.cadastrarNavio(nomeN, velocidadeN, autonomiaN, custoPorMilhaN);                
                } catch (NumberFormatException f) {
                    // TODO: handle exception
                    TelaDeAviso aviso = new TelaDeAviso("TU È BURRo");
                }

                

            }
        });



        
    }

    
}
