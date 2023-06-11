package application.Interface;

import java.awt.event.ActionListener;

import javax.swing.*;

import model.ListaClientes;

public class TelaCadastrarCliente extends JFrame {

    private JTextField cod;
    private JTextField nome;
    private JTextField email;
    private JButton cadastrar;
    private JButton limpar;
    private JLabel statusCod = new JLabel();
    private JLabel statusNome = new JLabel();
    private JLabel statusEmail = new JLabel();

    public TelaCadastrarCliente() {
        super("Cadastrar cliente");
        setSize(345, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        setNome();
        setCod();
        setEmail();

        setBotaoCadastrar();
        setLimpar();

        this.add(statusCod);
        this.add(statusNome);
        this.add(statusEmail);

        setVisible(true);
    }

    /**
     * 
     * Define o textfield cod e o texto
     */
    private void setCod() {
        JLabel codLabel = new JLabel("Cod:");
        codLabel.setBounds(10, 10, 50, 20);
        this.add(codLabel);

        cod = new JTextField();
        cod.setBounds(135, 10, 200, 20);
        this.add(cod);
    }

    /**
     * 
     * Define o textfield nome e o texto
     */
    private void setNome() {
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 40, 50, 20);
        this.add(nomeLabel);

        nome = new JTextField();
        nome.setBounds(135, 40, 200, 20);
        this.add(nome);
    }

    /**
     * 
     * Define o textfield email e o texto
     */
    private void setEmail() {
        JLabel emaiLabel = new JLabel("Email:");
        emaiLabel.setBounds(10, 70, 50, 20);
        this.add(emaiLabel);

        email = new JTextField();
        email.setBounds(135, 70, 200, 20);
        this.add(email);
    }

    private void setBotaoCadastrar() {
        cadastrar = new JButton("Cadastrar");
        cadastrar.setBounds(10, 120, 125, 20);
        this.add(cadastrar);


        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (cod.getText().isEmpty() || nome.getText().isEmpty() || email.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                } else {
                    String nomeC = nome.getText();
                    String emailC = email.getText();
                    int codC = Integer.parseInt(cod.getText());
                    ListaClientes lista = ListaClientes.listaClientes();
                    lista.cadastrarCliente(codC, nomeC, emailC);
                    setUltimoCadastro(codC, nomeC, emailC);

                }
            }
        });

    }

    private void setUltimoCadastro(int codC, String nomeC, String emailCont) {
        statusCod.setText("Cod: " + codC);
        statusCod.setBounds(10, 160, 335, 20);

        statusNome.setText("Nome: " + nomeC);
        statusNome.setBounds(10, 180, 335, 20);

        statusEmail.setText("Email: " + emailCont);
        statusEmail.setBounds(10, 200, 335, 20);
    }

    private void setLimpar() {
        limpar = new JButton("Limpar");
        limpar.setBounds(210, 120, 125, 20);
        this.add(limpar);

        limpar.addActionListener(e -> {
            cod.setText("");
            nome.setText("");
            email.setText("");
            statusCod.setText("");
            statusNome.setText("");
            statusEmail.setText("");
        });
    }
}
