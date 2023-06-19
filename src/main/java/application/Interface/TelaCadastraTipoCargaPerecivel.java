package application.Interface;

import java.awt.event.ActionListener;

import javax.swing.*;

import model.ListaTipoCargas;

public class TelaCadastraTipoCargaPerecivel extends JFrame{
    private JTextField num;
    private JTextField descricao;
    private JTextField origem;
    private JTextField validade;
    private JButton cadastrar;
    private JButton limpar;
    private JLabel statusNum = new JLabel();
    private JLabel statusDescricao = new JLabel();
    private JLabel statusOrigem = new JLabel();
    private JLabel statusValidade = new JLabel();

    public TelaCadastraTipoCargaPerecivel() {
        super("Cadastrar tipo de carga perecível");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        setNum();
        setDescricao();
        setOrigem();
        setValidade();

        setBotaoCadastrar();
        setLimpar();

        this.add(statusNum);
        this.add(statusDescricao);
        this.add(statusOrigem);
        this.add(statusValidade);

        setVisible(true);
    }

    /**
     * Define o textfield numero e o texto
     */
    private void setNum() {
        JLabel numLabel = new JLabel("Numero:");
        numLabel.setBounds(10, 10, 80, 20);
        this.add(numLabel);

        num = new JTextField();
        num.setBounds(135, 10, 230, 20);
        this.add(num);
    }

    /**
     * Define o textfield descricao e o texto
     */
    private void setDescricao() {
        JLabel descricaoLabel = new JLabel("Descricao:");
        descricaoLabel.setBounds(10, 40, 80, 20);
        this.add(descricaoLabel);

        descricao = new JTextField();
        descricao.setBounds(135, 40, 230, 20);
        this.add(descricao);
    }

    /**
     * Define o textfield origem e o texto
     */
    private void setOrigem() {
        JLabel origemLabel = new JLabel("Origem:");
        origemLabel.setBounds(10, 70, 80, 20);
        this.add(origemLabel);

        origem = new JTextField();
        origem.setBounds(135, 70, 230, 20);
        this.add(origem);
    }

    /**
     * Define o textfield validade e o texto
     */
    private void setValidade() {
        JLabel validadeLabel = new JLabel("Validade:");
        validadeLabel.setBounds(10, 100, 80, 20);
        this.add(validadeLabel);

        validade = new JTextField();
        validade.setBounds(135, 100, 230, 20);
        this.add(validade);
    }

    private void setBotaoCadastrar() {
        cadastrar = new JButton("Cadastrar");
        cadastrar.setBounds(10, 130, 125, 20);
        this.add(cadastrar);

        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (num.getText().isEmpty() || descricao.getText().isEmpty() || origem.getText().isEmpty() || validade.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                } else {
                    String descricaoC = descricao.getText();
                    String origemC = origem.getText();
                    try {
                        String numC = num.getText();
                        String validadeC = validade.getText();
                        ListaTipoCargas lista = ListaTipoCargas.listaTipoCargas();
                        lista.cadastrarTipoCargaPerecivel(Integer.parseInt(numC), descricaoC, origemC, Integer.parseInt(validadeC));
                        setUltimoCadastro(Integer.parseInt(numC), descricaoC, origemC, Integer.parseInt(validadeC));
                    } catch (NumberFormatException f) {
                        JOptionPane.showMessageDialog(null,
                                "Entrada invalida na entrada de COD, só é permetido numeros postivos");
                    } catch (Exception f) {
                        JOptionPane.showMessageDialog(null, f.getMessage());
                    }

                }
            }
        });
    }

    private void setUltimoCadastro(int numC, String descricaoC, String origemC, int validadeC) {
        statusNum.setText("Numero: " + numC);
        statusNum.setBounds(10, 160, 335, 20);

        statusDescricao.setText("Descricao: " + descricaoC);
        statusDescricao.setBounds(10, 180, 335, 20);

        statusOrigem.setText("Origem: " + origemC);
        statusOrigem.setBounds(10, 200, 335, 20);

        statusValidade.setText("Validade: " + validadeC);
        statusValidade.setBounds(10, 220, 335, 20);
    }

    private void setLimpar() {
        limpar = new JButton("Limpar");
        limpar.setBounds(210, 130, 125, 20);
        this.add(limpar);

        limpar.addActionListener(e -> {
            num.setText("");
            descricao.setText("");
            origem.setText("");
            validade.setText("");
        });
    }
}
