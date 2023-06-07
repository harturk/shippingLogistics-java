package application.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaPrincipal extends JFrame {
    private JButton botaoCadastrarPorto;
    private JButton botaoCadastrarNavio;
    private JButton botaoCadastrarCliente;
    private JButton botaoCadastrarTipoDeCarga;
    private JButton botaoCadastrarCarga;
    private JButton botaoConsultarTodasAsCargas;
    private JTextField nomeDoArquivo;
    private JButton carregarNovoArquvio;

    public TelaPrincipal() {
        this.setTitle("Menu Principal");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 500, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);

        setBotaoCadastrarPorto();
        setBotaoCadastrarNavio();
        setBotaoCadastrarCliente();
        setBotaoCadastrarTipoDeCarga();
        setBotaoCadastrarCarga();
        setBotaoConsultarTodasAsCargas();
        
        this.add(botaoCadastrarPorto);
        this.add(botaoCadastrarNavio);
        this.add(botaoCadastrarCliente);
        this.add(botaoCadastrarTipoDeCarga);
        this.add(botaoCadastrarCarga);
        this.add(botaoConsultarTodasAsCargas);


    }

    private void setBotaoCadastrarPorto() {
        this.botaoCadastrarPorto = new JButton("Cadastrar Porto");
        this.botaoCadastrarPorto.setBounds(10, 10, 230, 30);
        this.botaoCadastrarPorto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastraPorto telaCadastrarPorto = new TelaCadastraPorto();
                telaCadastrarPorto.setVisible(true);
                dispose();
            }
        });
    }

    private void setBotaoCadastrarNavio() {
        this.botaoCadastrarNavio = new JButton("Cadastrar Navio");
        this.botaoCadastrarNavio.setBounds(260, 10, 230, 30);
        this.botaoCadastrarNavio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastrarNavio a = new TelaCadastrarNavio();
                a.setVisible(true);
                dispose();
            }
        });
    }

    private void setBotaoCadastrarCliente() {
        this.botaoCadastrarCliente = new JButton("Cadastrar Navio");
        this.botaoCadastrarCliente.setBounds(10, 50, 230, 30);
        this.botaoCadastrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastraPorto telaCadastrarPorto = new TelaCadastraPorto();
                telaCadastrarPorto.setVisible(true);
                dispose();
            }
        });
    }

    private void setBotaoCadastrarTipoDeCarga() {
        this.botaoCadastrarTipoDeCarga = new JButton("Cadastrar Tipo de Carga");
        this.botaoCadastrarTipoDeCarga.setBounds(260, 50, 230, 30);
        this.botaoCadastrarTipoDeCarga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastraPorto telaCadastrarPorto = new TelaCadastraPorto();
                telaCadastrarPorto.setVisible(true);
                dispose();
            }
        });
    }

    private void setBotaoCadastrarCarga() {
        this.botaoCadastrarCarga = new JButton("Cadastrar Carga");
        this.botaoCadastrarCarga.setBounds(10, 90, 230, 30);
        this.botaoCadastrarCarga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastraPorto telaCadastrarPorto = new TelaCadastraPorto();
                telaCadastrarPorto.setVisible(true);
                dispose();
            }
        });
    }

    private void setBotaoConsultarTodasAsCargas() {
        this.botaoConsultarTodasAsCargas = new JButton("Consultar Todas as Cargas");
        this.botaoConsultarTodasAsCargas.setBounds(260, 90, 230, 30);
        this.botaoConsultarTodasAsCargas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastraPorto telaCadastrarPorto = new TelaCadastraPorto();
                telaCadastrarPorto.setVisible(true);
                dispose();
            }
        });
    }
    
}
