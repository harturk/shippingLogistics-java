package application.Interface;

import javax.swing.*;
import java.awt.event.*;

public class TelaCadastraTipoCarga extends JFrame {
    private JButton botaoCadastrarTipoDeCargaPerecivel;
    private JButton botaoCadastrarTipoDeCargaDuravel;

    public TelaCadastraTipoCarga() {
        super("Escolher tipo de carga");
        this.setBounds(100, 100, 500, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);

        setBotaoCadastrarTipoDeCargaPerecivel();
        setBotaoCadastrarTipoDeCargaDuravel();
        
        this.add(botaoCadastrarTipoDeCargaPerecivel);
        this.add(botaoCadastrarTipoDeCargaDuravel);


    }

    private void setBotaoCadastrarTipoDeCargaPerecivel() {
        this.botaoCadastrarTipoDeCargaPerecivel = new JButton("Cadastrar Perecivel");
        this.botaoCadastrarTipoDeCargaPerecivel.setBounds(10, 10, 230, 30);
        this.botaoCadastrarTipoDeCargaPerecivel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastraTipoCargaPerecivel telaCadastrarPerecivel = new TelaCadastraTipoCargaPerecivel();
                telaCadastrarPerecivel.setVisible(true);
            }
        });
    }

    private void setBotaoCadastrarTipoDeCargaDuravel() {
        this.botaoCadastrarTipoDeCargaDuravel = new JButton("Cadastrar Duravel");
        this.botaoCadastrarTipoDeCargaDuravel.setBounds(260, 10, 230, 30);
        this.botaoCadastrarTipoDeCargaDuravel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastraTipoCargaDuravel telaCadastrarDuravel = new TelaCadastraTipoCargaDuravel();
                telaCadastrarDuravel.setVisible(true);
            }
        });
    }
}
