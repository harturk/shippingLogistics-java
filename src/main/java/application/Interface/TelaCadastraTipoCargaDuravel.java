package application.Interface;

import java.awt.event.ActionListener;

import javax.swing.*;

import model.ListaTipoCargas;

public class TelaCadastraTipoCargaDuravel extends JFrame{
    private JTextField num;
    private JTextField descricao;
    private JTextField setor;
    private JTextField material;
    private JTextField ipi;
    private JButton cadastrar;
    private JButton limpar;
    private JLabel statusNum = new JLabel();
    private JLabel statusDescricao = new JLabel();
    private JLabel statusSetor = new JLabel();
    private JLabel statusMaterial = new JLabel();
    private JLabel statusIpi = new JLabel();

    public TelaCadastraTipoCargaDuravel() {
        super("Cadastrar tipo de carga duravel");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        setNum();
        setDescricao();
        setSetor();
        setMaterial();
        setIpi();

        setBotaoCadastrar();
        setLimpar();

        this.add(statusNum);
        this.add(statusDescricao);
        this.add(statusSetor);
        this.add(statusMaterial);
        this.add(statusIpi);

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
     * Define o textfield setor e o texto
     */
    private void setSetor() {
        JLabel setorLabel = new JLabel("Setor:");
        setorLabel.setBounds(10, 70, 80, 20);
        this.add(setorLabel);

        setor = new JTextField();
        setor.setBounds(135, 70, 230, 20);
        this.add(setor);
    }

    /**
     * Define o textfield material e o texto
     */
    private void setMaterial() {
        JLabel materialLabel = new JLabel("Material:");
        materialLabel.setBounds(10, 100, 80, 20);
        this.add(materialLabel);

        material = new JTextField();
        material.setBounds(135, 100, 230, 20);
        this.add(material);
    }

    /**
     * Define o textfield ipi e o texto
     */
    private void setIpi() {
        JLabel ipiLabel = new JLabel("IPI:");
        ipiLabel.setBounds(10, 130, 80, 20);
        this.add(ipiLabel);

        ipi = new JTextField();
        ipi.setBounds(135, 130, 230, 20);
        this.add(ipi);
    }

    private void setBotaoCadastrar() {
        cadastrar = new JButton("Cadastrar");
        cadastrar.setBounds(10, 160, 125, 20);
        this.add(cadastrar);

        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (num.getText().isEmpty() || descricao.getText().isEmpty() || setor.getText().isEmpty() || material.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                } else {
                    String descricaoC = descricao.getText();
                    String setorC = setor.getText();
                    try {
                        String numC = num.getText();
                        String materialC = material.getText();
                        String ipiC = ipi.getText();
                        ListaTipoCargas lista = ListaTipoCargas.ListaTipoCargas();
                        lista.cadastrarTipoCargaDuravel(Integer.parseInt(numC), descricaoC, setorC, materialC, Double.parseDouble(ipiC));
                        setUltimoCadastro(Integer.parseInt(numC), descricaoC, setorC, materialC, Double.parseDouble(ipiC));
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

    private void setUltimoCadastro(int numC, String descricaoC, String setorC, String materialC, double ipiC) {
        statusNum.setText("Numero: " + numC);
        statusNum.setBounds(10, 190, 335, 20);

        statusDescricao.setText("Descricao: " + descricaoC);
        statusDescricao.setBounds(10, 210, 335, 20);

        statusSetor.setText("Setor: " + setorC);
        statusSetor.setBounds(10, 230, 335, 20);

        statusMaterial.setText("Material: " + materialC);
        statusMaterial.setBounds(10, 250, 335, 20);

        statusMaterial.setText("IPI: " + ipiC);
        statusMaterial.setBounds(10, 270, 335, 20);
    }

    private void setLimpar() {
        limpar = new JButton("Limpar");
        limpar.setBounds(210, 160, 125, 20);
        this.add(limpar);

        limpar.addActionListener(e -> {
            num.setText("");
            descricao.setText("");
            setor.setText("");
            material.setText("");
            ipi.setText("");
        });
    }
}
