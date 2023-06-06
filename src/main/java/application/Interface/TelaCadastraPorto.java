package application.Interface;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;

public class TelaCadastraPorto extends JFrame{
    private JTextField nome;
    private JTextField pais;
    private JTextField id;

    public TelaCadastraPorto(){
        super("Cadastrar Porto");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        this.nome = new JTextField();
        this.nome.setPreferredSize(new Dimension(100, 20));
        this.nome.setEditable(true);

        this.pais = new JTextField();
        this.pais.setPreferredSize(new Dimension(100, 20));
        this.pais.setEditable(true);

        this.id = new JTextField();
        this.id.setPreferredSize(new Dimension(100, 20));
        this.id.setEditable(true);

        this.add(this.nome);
        this.add(this.pais);
        this.add(this.id);

        this.setVisible(true);
    }
    
}
