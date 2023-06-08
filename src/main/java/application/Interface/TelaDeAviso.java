package application.Interface;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class TelaDeAviso extends JFrame{
    private JButton ok;
    public TelaDeAviso(String aviso) {
        setTitle("Aviso");
        setSize(300, 100);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(2, 1));

        JLabel problema = new JLabel(aviso);
        ok = new JButton("OK");
        ok.addActionListener(e -> dispose());

        grid.add(problema);
        grid.add(ok);

        setContentPane(grid);
        setVisible(true);
    }
}
