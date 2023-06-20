package application;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.*;

/**
 * Classe de Leitura. Código trazido da aula, com um pequeno ajuste onde
 * inclui-se um
 * parâmetro para informar se o csv lido tem, ou não, cabeçalho.
 */

public class Leitura {
    private String nomeArquivo;
    private static Leitura leitura;

    private Path cargas;
    private Path clientes;
    private Path distancia;
    private Path navios;
    private Path portos;
    private Path tiposCargas;

    private Leitura() {
    }

    public static Leitura getLeitura(String path) {
        if (leitura == null) {
            leitura = new Leitura();
        }
        leitura.attPath(path);

        return leitura;
    }

    private void attPath(String path) {
        this.nomeArquivo = path;
        String cargasS = nomeArquivo + "-CARGAS.CSV";
        String clientesS = nomeArquivo + "-CLIENTES.CSV";
        String distanciaS = nomeArquivo + "-DISTANCIAS.CSV";
        String naviosS = nomeArquivo + "-NAVIOS.CSV";
        String portosS = nomeArquivo + "-PORTOS.CSV";
        String tiposCargasS = nomeArquivo + "-TIPOSCARGAS.CSV";

        this.cargas = Paths.get("../programacao-orientada-objetos-trab-final", "src", "Arquivos", cargasS);
        this.clientes = Paths.get("../programacao-orientada-objetos-trab-final", "src", "Arquivos", clientesS);
        this.distancia = Paths.get("../programacao-orientada-objetos-trab-final", "src", "Arquivos", distanciaS);
        this.navios = Paths.get("../programacao-orientada-objetos-trab-final", "src", "Arquivos", naviosS);
        this.portos = Paths.get("../programacao-orientada-objetos-trab-final", "src", "Arquivos", portosS);
        this.tiposCargas = Paths.get("../programacao-orientada-objetos-trab-final", "src", "Arquivos", tiposCargasS);

    }

    public void carregarTudo() throws Exception {
        carregarPortos();
        carregarNavios();
        carregarClientes();
        carregarDistancia();
        carregarTiposCargas();
        carregarCargas();
    }

    private void carregarClientes() throws Exception {
        ListaClientes a = ListaClientes.listaClientes();
        try (Scanner sc = new Scanner(Files.newBufferedReader(clientes, Charset.defaultCharset()))) {
            sc.useDelimiter(";"); // separadores: ; e nova linha
            sc.nextLine();
            while (sc.hasNextLine()) {
                // cod;nome;email
                int cod = Integer.parseInt(sc.next());
                String nome = sc.next();
                String email = sc.nextLine().substring(1);
                a.cadastrarCliente(cod, nome, email);

            }
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(null, "Arquvio de clientes não foi achado!");

        }
        // catch (Exception e2) {
        // System.out.println("Erro: " + e2);
        // System.out.print("Erro - trace da falha: ");
        // e2.printStackTrace();
        // }
    }

    private void carregarDistancia() throws Exception {
        ListaTrajetos a = ListaTrajetos.getInstance();
        try (Scanner sc = new Scanner(Files.newBufferedReader(distancia, Charset.defaultCharset()))) {
            sc.useDelimiter(";"); // separadores: ; e nova linha
            sc.nextLine();
            while (sc.hasNextLine()) {
                int origem = Integer.parseInt(sc.next());
                int destino = Integer.parseInt(sc.next());
                String distanciaS = sc.nextLine().substring(1).replace(",", ".");
                double distancia = Double.parseDouble(distanciaS);
                a.cadastrarTrajeto(origem, destino, distancia);

            }
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(null, "Arquvio de distancias não foi achado!");

        }
        // catch (Exception e2) {
        // System.out.println("Erro: " + e2);
        // System.out.print("Erro - trace da falha: ");
        // e2.printStackTrace();
        // }
    }

    private void carregarNavios() throws Exception {
        ListaNavios a = ListaNavios.listaNavios();
        try (Scanner sc = new Scanner(Files.newBufferedReader(navios, Charset.defaultCharset()))) {
            sc.useDelimiter(";"); // separadores: ; e nova linha
            sc.nextLine();
            while (sc.hasNextLine()) {
                String nome = sc.next();
                String velocidadeString = sc.next().replace(",", ".");
                String autonomiaString = sc.next().replace(",", ".");
                String custoMilhaString = sc.nextLine().substring(1).replace(",", ".");
                double velocidade = Double.parseDouble(velocidadeString);
                double autonomia = Double.parseDouble(autonomiaString);
                double custoMilha = Double.parseDouble(custoMilhaString);

                a.cadastrarNavio(nome, velocidade, autonomia, custoMilha);

            }
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(null, "Arquvio de navios não foi achado!");

        }
        // catch (Exception e2) {
        // System.out.println("Erro: " + e2);
        // System.out.print("Erro - trace da falha: ");
        // e2.printStackTrace();
        // }
    }

    private void carregarPortos() throws Exception {
        ListaPortos a = ListaPortos.listaPortos();
        try (Scanner sc = new Scanner(Files.newBufferedReader(portos, Charset.defaultCharset()))) {
            sc.useDelimiter(";"); // separadores: ; e nova linha
            sc.nextLine();
            while (sc.hasNextLine()) {
                // id;nome;pais
                int id = Integer.parseInt(sc.next());
                String nome = sc.next();
                String pais = sc.nextLine().substring(1);
                a.cadastrarPorto(id, nome, pais);
            }
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(null, "Arquvio de portos não foi achado!");

        }
        // catch (Exception e2) {
        // System.out.println("Erro: " + e2);
        // System.out.print("Erro - trace da falha: ");
        // e2.printStackTrace();
        // }
    }

    public void carregarCargas() throws Exception {
        ListaCargas a = ListaCargas.listaCargas();
        try (Scanner sc = new Scanner(Files.newBufferedReader(cargas, Charset.defaultCharset()))) {
            sc.useDelimiter(";"); // separadores: ; e nova linha
            sc.nextLine();
            while (sc.hasNextLine()) {
                int codigo = Integer.parseInt(sc.next());
                int cliente = Integer.parseInt(sc.next());
                int origem = Integer.parseInt(sc.next());
                int destino = Integer.parseInt(sc.next());
                int peso = Integer.parseInt(sc.next());
                String valorS = sc.next().replace(",", ".");
                double valor = Double.parseDouble(valorS);
                int tempoMaximo = Integer.parseInt(sc.next());
                int tipocarga = Integer.parseInt(sc.next());
                String prioridade = sc.next();
                String situacao = sc.nextLine().substring(1);

                a.cadastrarCarga(codigo, peso, origem, destino, cliente, valor, tempoMaximo, tipocarga, prioridade, situacao);



            }
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(null, "Arquvio de cargas não foi achado!");

        }
        // catch (Exception e2) {
        // System.out.println("Erro: " + e2);
        // System.out.print("Erro - trace da falha: ");
        // e2.printStackTrace();
        // }
    }

    public void carregarTiposCargas() throws Exception {
        try (Scanner sc = new Scanner(Files.newBufferedReader(tiposCargas, Charset.defaultCharset()))) {
            ListaTipoCargas tipoCargas = ListaTipoCargas.listaTipoCargas();
            sc.useDelimiter(";"); // separadores: ; e nova linha
            sc.nextLine();
            while (sc.hasNextLine()) {
                // Numero;descricao;categoria;origem_setor;tempomaximo_material
                int numero = Integer.parseInt(sc.next());
                String descricao = sc.next();
                String categoria = sc.next();
                if (categoria.equals("PERECIVEL")) {
                    String origem = sc.next();
                    String tempomaximoString = sc.nextLine().substring(1).replace(",", ".");
                    int tempomaximo = Integer.parseInt(tempomaximoString);
                    tipoCargas.cadastrarTipoCargaPerecivel(numero, descricao, origem, tempomaximo);
                } else {
                    String setor = sc.next();
                    String material = sc.next();
                    String ipiString = sc.nextLine().substring(1).replace(",", ".");
                    double ipi = Double.parseDouble(ipiString);
                    tipoCargas.cadastrarTipoCargaDuravel(numero, descricao, setor, material, ipi);
                }

            }
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(null, "Arquvio de tipos cargas não foi achado!");

        }
        // catch (Exception e2) {
        // System.out.println("Erro: " + e2);
        // System.out.print("Erro - trace da falha: ");
        // e2.printStackTrace();
        // }
    }
}
