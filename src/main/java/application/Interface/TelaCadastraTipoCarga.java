package application.Interface;

import javax.swing.*;

public class TelaCadastraTipoCarga extends JFrame{
    public TelaCadastraTipoCarga(){
        super("Cadastro de Tipo de Carga");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setLayout(null);
        JLabel label = new JLabel("Cadastro de Tipo de Carga");
        label.setBounds(10, 10, 400, 20);
        add(label);
    }
}
