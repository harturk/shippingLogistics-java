package application.Interface;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class TelaDeAviso extends JFrame {
    private JButton ok;
    private JLabel problema;

    public TelaDeAviso(String aviso) {
        setTitle("Aviso");
        setResizable(false);

        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(2, 1));

        setProblema(aviso);

        setOkButton();

        setSize(problema.getPreferredSize().width + 20, 100); // Define o tamanho da janela com base JLabel

        adds(grid, problema); // adiciona coisa na tela

        setContentPane(grid); // Define o formato da tela

        // precisa sempre deixar setLocation depois do setSize senao vai centralizar
        // com o canto superior direito
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Define oque o ok button faz
     */
    private void setOkButton() {
        ok = new JButton("OK");
        ok.addActionListener(e -> dispose());
    }

    /**
     * 
     * @param grid     é o formato da tela
     * @param problema é o texto escrito o problema
     *                 o metodo adiciona as coisas na tela
     */
    private void adds(JPanel grid, JLabel problema) {
        grid.add(problema);
        grid.add(ok);
    }

    /**
     * 
     * @param aviso é o texto que vai mostrar no JLabel
     */
    private void setProblema(String aviso) {
        problema = new JLabel(aviso);
        problema.setHorizontalAlignment(SwingConstants.CENTER);

    }
}
