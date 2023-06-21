package application.Interface;

import javax.swing.*;

import application.Escrita;
import application.Leitura;
import model.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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

    private JTextField salvarText;
    private JButton salvarButton;

    private JButton finalizar;

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
        setFinalizar();

        setCarregarArquivo();
        setSalvarArquivo();

        this.add(botaoCadastrarPorto);
        this.add(botaoCadastrarNavio);
        this.add(botaoCadastrarCliente);
        this.add(botaoCadastrarTipoDeCarga);
        this.add(botaoCadastrarCarga);
        this.add(botaoTrajeto);

    }

    private void setFinalizar(){
        finalizar = new JButton("Finalizar");
        finalizar.setBounds(260,130 , 230,30);
        this.add(finalizar);
        finalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Encerra a aplicação
                System.exit(0);
            }
        });
    }

    private void setBotaoAlterarStatus() {
        this.alterarStatusCarga = new JButton("Gerencia Frete");
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
        this.botaoTrajeto = new JButton("Cadastrar frete");
        this.botaoTrajeto.setBounds(260, 90, 230, 30);
        this.botaoTrajeto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaTrajeto a = new TelaTrajeto();
                a.setVisible(true);
            }
        });
    }

    private void setCarregarArquivo() {
        this.textPath = new JTextField();
        this.textPath.setBounds(10, 225, 230, 30);
        this.carregarPath = new JButton("Carregar");
        this.carregarPath.setBounds(260, 225, 230, 30);

        this.carregarPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = textPath.getText();
                if (path.equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite o nome do arquivo");
                } else {
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

    }

    private void setSalvarArquivo() {
        this.salvarText = new JTextField();
        this.salvarText.setBounds(10, 190, 230, 30);
        this.salvarButton = new JButton("Salvar");
        this.salvarButton.setBounds(260, 190, 230, 30);

        this.salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = salvarText.getText();
                if (path.equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite o nome do arquivo");
                } else {

                    try {

                        inicializaEscrita(path);

                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(null, e2.getMessage());

                    }
                }
            }
        });
        this.add(salvarText);
        this.add(salvarButton);

    }

    private void inicializaEscrita(String path) throws Exception {
        String cargasS = path + "-CARGAS.CSV";
        String clientesS = path + "-CLIENTES.CSV";
        String naviosS = path + "-NAVIOS.CSV";
        String portosS = path + "-PORTOS.CSV";
        String tiposCargasS = path + "-TIPOSCARGAS.CSV";
        String trajetoS = path + "-DISTANCIAS.CSV";

        ListaCargas c = ListaCargas.listaCargas();
        ListaClientes cli = ListaClientes.listaClientes();
        ListaNavios n = ListaNavios.listaNavios();
        ListaPortos p = ListaPortos.listaPortos();
        ListaTipoCargas tc = ListaTipoCargas.listaTipoCargas();
        ListaTrajetos tr = ListaTrajetos.getInstance();

        ArrayList<String> cargaCSV = new ArrayList<String>();
        ArrayList<String> clienteCSV = new ArrayList<String>();
        ArrayList<String> navioCSV = new ArrayList<>();
        ArrayList<String> portoCSV = new ArrayList<>();
        ArrayList<String> tiposCargaCSV = new ArrayList<>();
        ArrayList<String> trajetoCSV = new ArrayList<>();

        cargaCSV.add("codigo;cliente;origem;destino;peso;valordeclarado;tempomaximo;tipocarga;prioridade;situacao");
        cargaCSV.addAll(c.getListCSV());
        clienteCSV.add("cod;nome;email");
        clienteCSV.addAll(cli.getListCSV());
        navioCSV.add("nome;velocidade;autonomia;customilhabasico");
        navioCSV.addAll(n.getListCSV());
        portoCSV.add("id;nome;pais");
        portoCSV.addAll(p.getListCSV());
        tiposCargaCSV.add("Numero;descricao;categoria;origem_setor;tempomaximo_material");
        tiposCargaCSV.addAll(tc.getListCSV());
        trajetoCSV.add("origem;destino;distancia");
        trajetoCSV.addAll(tr.getListCSV());

        Escrita cargaE = new Escrita(cargasS);
        Escrita clienteE = new Escrita(clientesS);
        Escrita naviosE = new Escrita(naviosS);
        Escrita portoE = new Escrita(portosS);
        Escrita tiposCargaE = new Escrita(tiposCargasS);
        Escrita trajetoE = new Escrita(trajetoS);

        cargaE.printOutput(cargaCSV);
        clienteE.printOutput(clienteCSV);
        naviosE.printOutput(navioCSV);
        portoE.printOutput(portoCSV);
        tiposCargaE.printOutput(tiposCargaCSV);
        trajetoE.printOutput(trajetoCSV);

        cargaE.closeOutput();
        clienteE.closeOutput();
        naviosE.closeOutput();
        portoE.closeOutput();
        tiposCargaE.closeOutput();
        trajetoE.closeOutput();


    }

}
