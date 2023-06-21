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
                        JOptionPane.showMessageDialog(null,e2.getMessage());
                        
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

        String tela = "cargas";

        try {
            new TelaMostraLista(cargas.getLista());
            tela = "clientes";
            new TelaMostraLista(clientes.getLista());
            tela ="navios";
            new TelaMostraLista(navios.getLista());
            tela = "portos";
            new TelaMostraLista(portos.getLista());
            tela = "tipo de cargas";
            new TelaMostraLista(tipos.getLista());
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null,"Não cadastrado nenhum "+ tela+" não possivel carregar uma lista vazia");
            
        } finally{
            new TelaPrincipal();

            this.dispose();
        }

    

    }
    
}
