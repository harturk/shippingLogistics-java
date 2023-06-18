package application.Interface;

import java.awt.event.*;

import javax.swing.*;

import entity.TipoCarga;
import model.ListaCargas;
import model.ListaTipoCargas;

public class TelaCadastraCarga extends JFrame {
    private JTextField id;
    private JTextField peso;
    private JTextField valorDeclarado;
    private JTextField tempoMaximo;
    private JTextField tipoCarga;
    private JButton cadastrar;
    private JButton limpar;
    private JButton listar;
    private JLabel statusId = new JLabel();
    private JLabel statusPeso = new JLabel();
    private JLabel statusValorDeclarado = new JLabel();
    private JLabel statusTempoMaximo = new JLabel();
    private JLabel statusTipoCarga = new JLabel();

    public TelaCadastraCarga() {
        super("Cadastrar carga");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        setId();
        setPeso();
        setValorDeclarado();
        setTempoMaximo();
        setTipoCarga();


        setBotaoCadastrar();
        setLimpar();
        setListar();
        this.add(statusId);
        this.add(statusPeso);
        this.add(statusValorDeclarado);
        this.add(statusTempoMaximo);
        this.add(statusTipoCarga);

        setVisible(true);
    }

    /**
     * Define o textfield id e o texto
     */
    private void setId() {
        JLabel idLabel = new JLabel("Id:");
        idLabel.setBounds(10, 10, 80, 20);
        this.add(idLabel);

        id = new JTextField();
        id.setBounds(135, 10, 230, 20);
        this.add(id);
    }

    /**
     * Define o textfield peso e o texto
     */
    private void setPeso() {
        JLabel pesoLabel = new JLabel("Peso:");
        pesoLabel.setBounds(10, 40, 80, 20);
        this.add(pesoLabel);

        peso = new JTextField();
        peso.setBounds(135, 40, 230, 20);
        this.add(peso);
    }

    /**
     * Define o textfield valor declarado e o texto
     */
    private void setValorDeclarado() {
        JLabel valorDeclaradoLabel = new JLabel("Valor Declarado:");
        valorDeclaradoLabel.setBounds(10, 70, 160, 20);
        this.add(valorDeclaradoLabel);

        valorDeclarado = new JTextField();
        valorDeclarado.setBounds(135, 70, 230, 20);
        this.add(valorDeclarado);
    }

    /**
     * Define o textfield tempo maximo e o texto
     */
    private void setTempoMaximo() {
        JLabel materialLabel = new JLabel("Tempo Maximo:");
        materialLabel.setBounds(10, 100, 160, 20);
        this.add(materialLabel);

        tempoMaximo = new JTextField();
        tempoMaximo.setBounds(135, 100, 230, 20);
        this.add(tempoMaximo);
    }

    /**
     * Define o textfield tipo de carga e o texto
     */
    private void setTipoCarga() {
        JLabel ipiLabel = new JLabel("Numero tipo de carga:");
        ipiLabel.setBounds(10, 130, 160, 20);
        this.add(ipiLabel);

        tipoCarga = new JTextField();
        tipoCarga.setBounds(135, 130, 230, 20);
        this.add(tipoCarga);
    }

    private void setBotaoCadastrar() {
        cadastrar = new JButton("Cadastrar");
        cadastrar.setBounds(10, 160, 125, 20);
        this.add(cadastrar);

        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (id.getText().isEmpty() || peso.getText().isEmpty() || valorDeclarado.getText().isEmpty()
                        || tempoMaximo.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                } else {
                    String invalidParameter = "";
                    try {
                        invalidParameter = "Id";
                        int idC = Integer.parseInt(id.getText());
                        invalidParameter = "peso";
                        int pesoC = Integer.parseInt(peso.getText());
                        invalidParameter = "valor declarado";
                        double valorDeclaradoC = Double.parseDouble(valorDeclarado.getText());
                        invalidParameter = "tempo máximo";
                        int tempoMaximoC = Integer.parseInt(tempoMaximo.getText());
                        invalidParameter = "tipo de carga";
                        int tipoCargaC = Integer.parseInt(tipoCarga.getText());
                        ListaTipoCargas listaTipoCargas = ListaTipoCargas.ListaTipoCargas();
                        TipoCarga tipoCargaFinal = listaTipoCargas.searchTipoCargas(tipoCargaC);
                        ListaCargas lista = ListaCargas.listaCargas();
                        lista.cadastrarCarga(idC, pesoC, null, null, null, valorDeclaradoC, tempoMaximoC, tipoCargaFinal);
                        setUltimoCadastro(idC, pesoC, valorDeclaradoC, tempoMaximoC, tipoCargaFinal);
                        listar.setEnabled(true);
                    } catch (NumberFormatException f) {
                        JOptionPane.showMessageDialog(null,
                                "Entrada invalida na entrada de " + invalidParameter + ", só é permitido numeros postivos");
                    } catch (Exception f) {
                        JOptionPane.showMessageDialog(null, f.getMessage());
                    }

                }
            }
        });
    }

    private void setUltimoCadastro(int idC, int pesoC, double valorDeclaradoC, int tempoMaximoC, TipoCarga tipoCargaC) {
        statusId.setText("ID: " + idC);
        statusId.setBounds(10, 190, 335, 20);

        statusPeso.setText("Peso: " + pesoC);
        statusPeso.setBounds(10, 210, 335, 20);

        statusValorDeclarado.setText("Valor Declarado: " + valorDeclaradoC);
        statusValorDeclarado.setBounds(10, 230, 335, 20);

        statusTempoMaximo.setText("Tempo Maximo: " + tempoMaximoC);
        statusTempoMaximo.setBounds(10, 250, 335, 20);

        statusTipoCarga.setText("Tipo Carga: " + tipoCargaC.toString());
        statusTipoCarga.setBounds(10, 270, 335, 20);
    }

    private void setLimpar() {
        limpar = new JButton("Limpar");
        limpar.setBounds(210, 160, 125, 20);
        this.add(limpar);

        limpar.addActionListener(e -> {
            id.setText("");
            peso.setText("");
            valorDeclarado.setText("");
            tempoMaximo.setText("");
            tipoCarga.setText("");
        });
    }

    private void setListar(){
        listar = new JButton("Lista");
        ListaCargas a = ListaCargas.listaCargas();
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
