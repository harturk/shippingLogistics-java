package application.Interface;

import java.awt.*;
import java.awt.event.*;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.*;

public class TelaMostraLista extends JFrame {

    private JLabel texto;
    private ArrayList<String> lista;
    private JButton proximo;
    private JButton anterior;
    private int pagina = 0;

    public TelaMostraLista(ArrayList<String> lista) {
        super("Lista");
        setLocationRelativeTo(null);
        this.setResizable(false);
        this.lista = lista;

        this.setLayout(null);

        texto = new JLabel(lista.get(pagina));
        setTexto();

        this.add(texto);
        this.setSize(texto.getPreferredSize().width + 20, texto.getHeight()+80);


        setAnterior();
        setProximo();

        setVisible(true);

    }

    private void setTexto() {

        texto.setText(lista.get(pagina));
        texto.setBounds(10, 40, texto.getPreferredSize().width, texto.getPreferredSize().height);

        this.setSize(texto.getPreferredSize().width + 20, texto.getHeight()+80);
    }

    private void setProximo() {
        proximo = new JButton(">");
        if (pagina >= lista.size()-1) {
            proximo.setEnabled(false);
        }
        proximo.setBounds(60, 10, 50, proximo.getPreferredSize().height);
        this.add(proximo);

        proximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagina++;
                if (pagina >= lista.size()-1) {
                    proximo.setEnabled(false);
                }
                setTexto();
                anterior.setEnabled(true);

            }
        });
    }

    private void setAnterior() {
        anterior = new JButton("<");
        if (pagina <= 0) {
            anterior.setEnabled(false);
        }
        anterior.setBounds(10, 10, 50, anterior.getPreferredSize().height);

        this.add(anterior);

        anterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagina--;
                if (pagina <= 0) {
                    anterior.setEnabled(false);
                }
                setTexto();
                proximo.setEnabled(true);
            }
        });
    }

}
