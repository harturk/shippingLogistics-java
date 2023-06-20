package application.Interface;

import javax.swing.*;

import application.Leitura;

import java.awt.event.*;

import model.*;



public class TelaCarregamentoInicial extends JFrame{

    private JTextField textPath;
    private JButton carregarPath;

    public TelaCarregamentoInicial() {
        super("Carregar dados inicias");
        this.setSize(480 , 100);
        setResizable(true);
        setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

        setCarregarArquivo();

    }

    private void setCarregarArquivo(){
        this.textPath = new JTextField();
        this.textPath.setBounds(10, 10, 230, 30);
        this.carregarPath = new JButton("Carregar");
        this.carregarPath.setBounds(240, 10, 230, 30);

        this.carregarPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = textPath.getText();
                if(path.equals("")){
                    JOptionPane.showMessageDialog(null, "Digite o nome do arquivo");
                }else{
                    Leitura l = Leitura.getLeitura(path);
                    try {
                        l.carregarTudo();
                        fecha();
                        
                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(null, e2.getMessage());
                        
                    }
                }
            }
        });
        this.add(textPath);
        this.add(carregarPath);


    }

    private void fecha(){
        ListaCargas cargas = ListaCargas.listaCargas();
        ListaClientes clientes = ListaClientes.listaClientes();
        ListaNavios navios = ListaNavios.listaNavios();
        ListaPortos portos = ListaPortos.listaPortos();
        ListaTipoCargas tipos = ListaTipoCargas.listaTipoCargas();

        new TelaMostraLista(cargas.getLista());
        new TelaMostraLista(clientes.getLista());
        new TelaMostraLista(navios.getLista());
        new TelaMostraLista(portos.getLista());
        new TelaMostraLista(tipos.getLista());
    
        new TelaPrincipal();

        this.dispose();
    }
    
}
