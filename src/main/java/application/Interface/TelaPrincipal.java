package application.Interface;

import javax.swing.*;

import application.Leitura;

import java.awt.*;
import java.awt.event.*;

public class TelaPrincipal extends JFrame {
    private JButton botaoCadastrarPorto;
    private JButton botaoCadastrarNavio;
    private JButton botaoCadastrarCliente;
    private JButton botaoCadastrarTipoDeCarga;
    private JButton botaoCadastrarCarga;
    private JButton botaoTrajeto;

    private JButton alterarStatusCarga;

    private JTextField textPath;
    private JButton carregarPath;


    public TelaPrincipal() {
        super("Menu Principal");
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
        setBotaoTrajeto();
        setBotaoAlterarStatus();


        setCarregarArquivo();

        
        this.add(botaoCadastrarPorto);
        this.add(botaoCadastrarNavio);
        this.add(botaoCadastrarCliente);
        this.add(botaoCadastrarTipoDeCarga);
        this.add(botaoCadastrarCarga);
        this.add(botaoTrajeto);


    }

    private void setBotaoAlterarStatus(){
        this.alterarStatusCarga = new JButton("Altera status carga");
        this.alterarStatusCarga.setBounds(10, 130, 230, 30);
        this.add(this.alterarStatusCarga);
        this.alterarStatusCarga.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                TelaAlteraSituacao altera = new TelaAlteraSituacao();
                altera.setVisible(true);
           }
        });

    }

    private void setBotaoCadastrarPorto() {
        this.botaoCadastrarPorto = new JButton("Cadastrar porto");
        this.botaoCadastrarPorto.setBounds(10, 10, 230, 30);
        this.botaoCadastrarPorto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastraPorto telaCadastrarPorto = new TelaCadastraPorto();
                telaCadastrarPorto.setVisible(true);
            }
        });
    }

    private void setBotaoCadastrarNavio() {
        this.botaoCadastrarNavio = new JButton("Cadastrar navio");
        this.botaoCadastrarNavio.setBounds(260, 10, 230, 30);
        this.botaoCadastrarNavio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastrarNavio a = new TelaCadastrarNavio();
                a.setVisible(true);
            }
        });
    }

    private void setBotaoCadastrarCliente() {
        this.botaoCadastrarCliente = new JButton("Cadastrar cliente");
        this.botaoCadastrarCliente.setBounds(10, 50, 230, 30);
        this.botaoCadastrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastrarCliente a = new TelaCadastrarCliente();
                a.setVisible(true);
            }
        });
    }

    private void setBotaoCadastrarTipoDeCarga() {
        this.botaoCadastrarTipoDeCarga = new JButton("Cadastrar Tipo de Carga");
        this.botaoCadastrarTipoDeCarga.setBounds(260, 50, 230, 30);
        this.botaoCadastrarTipoDeCarga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastraTipoCarga a = new TelaCadastraTipoCarga();
                a.setVisible(true);
            }
        });
    }

    private void setBotaoCadastrarCarga() {
        this.botaoCadastrarCarga = new JButton("Cadastrar Carga");
        this.botaoCadastrarCarga.setBounds(10, 90, 230, 30);
        this.botaoCadastrarCarga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastraCarga telaCadastraCarga = new TelaCadastraCarga();
                telaCadastraCarga.setVisible(true);
            }
        });
    }

    private void setBotaoTrajeto() {
        this.botaoTrajeto = new JButton("Fazer frete");
        this.botaoTrajeto.setBounds(260, 90, 230, 30);
        this.botaoTrajeto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaTrajeto a = new TelaTrajeto();
                a.setVisible(true);
            }
        });
    }

    private void setCarregarArquivo(){
        this.textPath = new JTextField();
        this.textPath.setBounds(10, 225, 230, 30);
        this.carregarPath = new JButton("Carregar");
        this.carregarPath.setBounds(260, 225, 230, 30);

        this.carregarPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = textPath.getText();
                if(path.equals("")){
                    JOptionPane.showMessageDialog(null, "Digite o nome do arquivo");
                }else{
                    Leitura l = Leitura.getLeitura(path);
                    try {
                        l.carregarTudo();
                        
                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(null, e2.getMessage());
                        
                    }
                }
            }
        });
        this.add(textPath);
        this.add(carregarPath);


                // // setCarregarArquivo();
        // // this.nomeDoArquivo = new JTextField();
        // // this.nomeDoArquivo.setBounds(10, 150, 230, 30);
        // this.carregarNovoArquvio = new JButton("Carregar");
        // this.carregarNovoArquvio.setBounds(240, 150, carregarNovoArquvio.getPreferredSize().width, 30);
        // // this.carregarNovoArquvio.addActionListener(new ActionListener() {
        // //     @Override
        // //     public void actionPerformed(ActionEvent e) {
        // //         String path = nomeDoArquivo.getText();
        // //         if(path.equals("")){
        // //             JOptionPane.showMessageDialog(null, "Digite o nome do arquivo");
        // //         }else{
        // //             Leitura l = Leitura.getLeitura(path);
                    
        // //         }
        // //     }
        // // });
        // // this.add(nomeDoArquivo);
        // this.add(carregarNovoArquvio);

        // this.nomeDoArquivo.setBackground(Color.WHITE);
        // this.nomeDoArquivo.setForeground(Color.BLACK);
        // this.nomeDoArquivo.setFont(new Font("Arial", Font.BOLD, 15));
        // this.nomeDoArquivo.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }
    
    

    
}
