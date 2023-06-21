package application.Interface;

import java.util.ArrayList;

import javax.swing.*;

import application.enums.SituacaoCarga;
import application.enums.SituacaoNavio;
import entity.Frete;
import model.*;

import java.awt.event.*;

public class TelaAlteraSituacao extends JFrame {
    private JLabel statusFretes;
    private JComboBox fretes;
    private JButton alterar;
    private JToggleButton cancelar;
    private JToggleButton pendente;
    private JToggleButton finalizar;

    public TelaAlteraSituacao() {
        super("AlteraStatus");
        this.setSize(520, 320);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        setBoxCarga();
        setSituacao();
        setAlterar();
    }

    private void setBoxCarga() {
        ListaFretes a = ListaFretes.listaFretes();
        ArrayList<Integer> idFretes = new ArrayList<>();
        for (Frete f : a.getFretesList()) {
            if (f.getCarga().getSituacao().equals(SituacaoCarga.LOCADO)) {
                idFretes.add(f.getId());
            }
        }

        statusFretes = new JLabel();
        statusFretes.setBounds(10, 20, 200, 250);
        this.add(statusFretes);

        fretes = new JComboBox<>(idFretes.toArray(new Integer[0]));
        fretes.setBounds(10, 10, 100, 20);
        this.add(fretes);

        fretes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer selectedId = (Integer) fretes.getSelectedItem();
                Frete frete = a.searchFrete(selectedId);
                String cargaData = frete.toString();
                statusFretes.setText(cargaData);
                cancelar.setSelected(false);
                pendente.setSelected(false);
                finalizar.setSelected(false);
                alterar.setEnabled(false);
                SituacaoCarga situacao = frete.getCarga().getSituacao();
                if (situacao == SituacaoCarga.PENDENTE) {
                    pendente.setEnabled(false);
                    finalizar.setEnabled(false);
                    cancelar.setEnabled(true);
                    alterar.setEnabled(false);

                } else if (situacao == SituacaoCarga.FINALIZADO) {
                    cancelar.setEnabled(false);
                    pendente.setEnabled(false);
                    finalizar.setEnabled(false);
                    alterar.setEnabled(false);

                } else if (situacao == SituacaoCarga.CANCELADO) {
                    cancelar.setEnabled(false);
                    finalizar.setEnabled(false);
                    pendente.setEnabled(true);
                    alterar.setEnabled(false);

                } else {
                    finalizar.setEnabled(true);
                    alterar.setEnabled(false);
                    cancelar.setEnabled(true);

                }
            }
        });
    }

    private void setSituacao() {
        cancelar = new JToggleButton("Cancelado");
        pendente = new JToggleButton("Pendente");
        finalizar = new JToggleButton("Finalizado");

        cancelar.setBounds(120, 10, 125, 30);
        pendente.setBounds(cancelar.getX() + 135, 10, 125, 30);

        finalizar.setBounds(pendente.getX() + 135, 50, 125, 30);

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // cancelar.setSelected(false);
                pendente.setSelected(false);
                finalizar.setSelected(false);
                alterar.setEnabled(true);

            }
        });

        pendente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                cancelar.setSelected(false);
                // pendente.setSelected(false);
                finalizar.setSelected(false);
                alterar.setEnabled(true);

            }
        });

        finalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                cancelar.setSelected(false);
                pendente.setSelected(false);
                // finalizar.setSelected(false);
                alterar.setEnabled(true);

            }
        });

        this.add(cancelar);
        this.add(pendente);
        this.add(finalizar);
    }

    private void setAlterar() {
        ListaFretes a = ListaFretes.listaFretes();
        alterar = new JButton("Alterar");
        alterar.setBounds(pendente.getX() + 135, 110, 125, 30);
        this.add(alterar);

        alterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer selectedId = (Integer) fretes.getSelectedItem();
                Frete frete = a.searchFrete(selectedId);
                if (cancelar.isSelected()) {
                    frete.getCarga().setSituacao(SituacaoCarga.CANCELADO);
                } else if (pendente.isSelected()) {
                    frete.getCarga().setSituacao(SituacaoCarga.PENDENTE);

                } else if (finalizar.isSelected()) {
                    frete.getCarga().setSituacao(SituacaoCarga.FINALIZADO);
                }
                frete.getNavio().setSituacao(SituacaoNavio.LIVRE);
                cancelar.setEnabled(false);
                pendente.setEnabled(false);
                finalizar.setEnabled(false);
                String cargaData = frete.toString();
                statusFretes.setText(cargaData);
            }
        });

    }

}
