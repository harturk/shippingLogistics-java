package application.Interface;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaDeAviso extends JFrame{
    public TelaDeAviso(String aviso){
        setTitle("Aviso");
        setSize(300, 200);
        setLocationRelativeTo(null);
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.CENTER);

        setLayout(flowLayout);
        setResizable(false);
        JLabel problema = new JLabel(aviso);
        problema.setBounds(10, 100, 125, 20);

        add(problema);
        setVisible(true);
    }
}
