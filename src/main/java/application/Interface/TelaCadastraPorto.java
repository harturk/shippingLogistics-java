package application.Interface;

import javax.swing.*;

import entity.Porto;
import model.ListaPortos;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

public class TelaCadastraPorto extends JFrame {
    private JTextField nome;
    private JTextField pais;
    private JTextField id;
    private JButton cadastrar;
    private JButton limpar;
    private JButton listar;
    private JLabel statusNome = new JLabel();
    private JLabel statusPais = new JLabel();
    private JLabel statusId = new JLabel();

    public TelaCadastraPorto() {
        super("Cadastrar Porto");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        setNome();

        setPais();

        setId();

        setCadastrar();

        setListar();

        setLimpar();

        this.add(statusNome);
        this.add(statusPais);
        this.add(statusId);
        setVisible(true);

    }

    private void setNome() {
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 10, 100, 20);
        this.add(nomeLabel);

        this.nome = new JTextField();
        nome.setBounds(135, 10, 200, 20);
        this.add(this.nome);
    }

    private void setPais() {
        JLabel paisLabel = new JLabel("País:");
        paisLabel.setBounds(10, 40, 100, 20);
        this.add(paisLabel);

        this.pais = new JTextField();
        this.pais.setBounds(135, 40, 200, 20);
        this.add(this.pais);
    }

    private void setId() {
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(10, 70, 50, 20);
        this.add(idLabel);

        this.id = new JTextField();
        this.id.setBounds(135, 70, 200, 20);
        this.add(this.id);
    }

    private void setCadastrar() {
        cadastrar = new JButton("Cadastrar");
        cadastrar.setBounds(10, 130, 125, 20);
        this.add(cadastrar);
        cadastrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeP = nome.getText();
                String paisP = pais.getText();
                try {
                    int idP = Integer.parseInt(id.getText());
                    ListaPortos lista = ListaPortos.listaPortos();
                    lista.cadastrarPorto(idP, nomeP, paisP);
                    setStatusNome(nomeP);
                    setStatusPais(paisP);
                    setStatusId(idP);
                    listar.setEnabled(true);

                } catch (NumberFormatException f) {
                    JOptionPane.showMessageDialog(null, "Entrada invalida na parte de ID");

                } catch (Exception f) {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }

            }
        });
    }

    private void setLimpar() {
        limpar = new JButton("Limpar");
        limpar.setBounds(265, 130, 125, 20);
        this.add(limpar);
        limpar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                nome.setText("");
                pais.setText("");
                id.setText("");
                statusNome.setText("");
                statusPais.setText("");
                statusId.setText("");
            }
        });
    }

    private void setStatusNome(String nome) {
        statusNome.setText("Nome: " + nome);
        statusNome.setBounds(10, 150, this.getWidth(), 20);
    }

    private void setStatusPais(String pais) {
        statusPais.setText("País: " + pais);
        statusPais.setBounds(10, 180, this.getWidth(), 20);
    }

    private void setStatusId(int id) {
        statusId.setText("ID: " + id);
        statusId.setBounds(10, 210, this.getWidth(), 20);
    }

    private void setListar(){
        listar = new JButton("Lista");
        ListaPortos a = ListaPortos.listaPortos();
        if(a.getLista().size() == 0){
            listar.setEnabled(false);
        }
        listar.setBounds(cadastrar.getSize().width+15, cadastrar.getY(), listar.getPreferredSize().width, 20);
        this.add(listar);
        listar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TelaMostraLista tela = new TelaMostraLista(a.getLista());
            }
        });
    }

}
