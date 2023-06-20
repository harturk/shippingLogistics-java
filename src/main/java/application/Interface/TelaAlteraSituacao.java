package application.Interface;

import java.util.ArrayList;

import javax.swing.*;

import application.enums.SituacaoCarga;
import entity.Carga;
import entity.Frete;
import model.*;

import java.awt.event.*;

public class TelaAlteraSituacao extends JFrame {
    private JLabel statusCargas;
    private JComboBox cargas;
    private JButton alterar;
    private JToggleButton cancelar;
    private JToggleButton pendente;
    private JToggleButton finalizar;

    public TelaAlteraSituacao() {
        super("AlteraStatus");
        this.setSize(520, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        setBoxCarga();
        setSituacao();
        setAlterar();
    }

    private void setBoxCarga() {
        ListaCargas a = ListaCargas.listaCargas();
        ArrayList<Integer> idCargas = new ArrayList<>();
        for (Carga n : a.getCargaLista()) {
            idCargas.add(n.getId());
        }

        statusCargas = new JLabel();
        statusCargas.setBounds(10, 20, 200, 250);
        this.add(statusCargas);

        cargas = new JComboBox<>(idCargas.toArray(new Integer[0]));
        cargas.setBounds(10, 10, 100, 20);
        this.add(cargas);

        cargas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer selectedId = (Integer) cargas.getSelectedItem();
                Carga carga = a.searchCarga(selectedId);
                statusCargas.setText(carga.toString());
                cancelar.setSelected(false);
                pendente.setSelected(false);
                finalizar.setSelected(false);
                alterar.setEnabled(false);
                SituacaoCarga situacao = carga.getSituacao();
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
        alterar = new JButton("Alterar");
        alterar.setBounds(pendente.getX() + 135, 110, 125, 30);
        this.add(alterar);

        alterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaCargas a = ListaCargas.listaCargas();
                Integer selectedId = (Integer) cargas.getSelectedItem();
                Carga carga = a.searchCarga(selectedId);
                if (cancelar.isSelected()) {
                    carga.setSituacao(SituacaoCarga.CANCELADO);
                    ListaFretes fretes = ListaFretes.listaFretes();
                    ArrayList<Frete> freteArray = fretes.getFretesList();
                } else if (pendente.isSelected()) {
                    carga.setSituacao(SituacaoCarga.PENDENTE);

                } else if (finalizar.isSelected()) {
                    carga.setSituacao(SituacaoCarga.FINALIZADO);
                }

                cancelar.setEnabled(false);
                pendente.setEnabled(false);
                finalizar.setEnabled(false);
                statusCargas.setText(carga.toString());

            }
        });

    }

}
