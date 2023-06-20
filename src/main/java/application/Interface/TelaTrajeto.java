package application.Interface;

import java.util.ArrayList;

import javax.swing.*;
import java.awt.event.*;


import entity.*;
import model.ListaCargas;
import model.ListaFretes;
import model.ListaNavios;

public class TelaTrajeto extends JFrame{
    // private JComboBox navios;
    private JComboBox<Integer> cargas;
    // private JLabel statusNavios;
    private JLabel statusCargas;
    private JButton cadastrar;


    public TelaTrajeto() {
        super("Enviar Cargas");
        this.setSize(120, 100);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        // setBoxNavio();
        setBoxCarga();
        setBotaoCadastrar();
    }

    // private void setBoxNavio(){
    //     ListaNavios a = ListaNavios.listaNavios();
    //     ArrayList<String> nomeNavios = new ArrayList<>();
    //     for (Navio n : a.getNavios()) {
    //         nomeNavios.add(n.getNome());
    //     }

    //     statusNavios = new JLabel();
    //     statusNavios.setBounds(10, 30, 200, 80);
    //     this.add(statusNavios);

    //     JComboBox<String> navios = new JComboBox<>((String[]) nomeNavios.toArray(new String[0]));
    //     navios.setBounds(10,10,100,20);
    //     this.add(navios);
    //     navios.addActionListener(new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             String opcao = (String) navios.getSelectedItem();
    //             Navio n = a.searchNavio(opcao);
    //             statusNavios.setText(n.toString());
    //         }
    //     });

        
    // }

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
                setTamanho(statusCargas.getWidth()+20);
            }
        });
    }
    private void setTamanho(int largura){
        this.setSize(largura, 400);
        
    }

        /**
     * Define o botao cadastrar e alem de dar uma funcao para ele
     */
    private void setBotaoCadastrar() {
        cadastrar = new JButton("Enviar");
        cadastrar.setBounds(10, 280, 125, 20);
        this.add(cadastrar);
        cadastrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    ListaFretes a = ListaFretes.listaFretes();
                    Integer selectedId = (Integer) cargas.getSelectedItem();
                    a.insereFrete(selectedId);

                } catch (Exception f) {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }

            }
        });
    }
    




}
