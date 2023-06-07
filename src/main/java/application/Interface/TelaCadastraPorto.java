package application.Interface;

import javax.swing.*;

import entity.Porto;

import java.awt.*;
import java.awt.event.*;

public class TelaCadastraPorto extends JFrame{
    private JTextField nome;
    private JTextField pais;
    private JTextField id;
    private JButton cadastrar;


    public TelaCadastraPorto(){
        super("Cadastrar Porto");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 10, 100, 20);
        this.add(nomeLabel);

        this.nome = new JTextField();
        nome.setBounds(135, 10, 200, 20);
        this.add(this.nome);

        JLabel paisLabel = new JLabel("País:");
        paisLabel.setBounds(10, 40, 100, 20);
        this.add(paisLabel);

        this.pais = new JTextField();
        this.pais.setBounds(135, 40, 200, 20);
        this.add(this.pais);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(10, 70, 50, 20);
        this.add(idLabel);

        this.id = new JTextField();
        this.id.setBounds(135, 70, 200, 20);
        this.add(this.id);

        cadastrar = new JButton("Cadastrar");
        cadastrar.setBounds(10, 130, 125, 20);
        this.add(cadastrar);
        cadastrar.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeP = nome.getText();
                String paisP = pais.getText();
                int idP = Integer.parseInt(id.getText());

                Porto porto = new Porto(idP, nomeP, paisP);
                
            }
        });

        this.add(this.nome);
        this.add(this.pais);
        this.add(this.id);
        
    }

    
    
}
