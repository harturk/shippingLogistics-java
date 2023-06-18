package application;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

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
        if(leitura == null) {
            leitura = new Leitura();
        }
        leitura.attPath(path);
        
        return leitura;
    }

    private void attPath(String path){
        this.nomeArquivo = path;
        String cargasS = nomeArquivo+"-CARGAS.CSV";
        String clientesS = nomeArquivo+"-CLIENTES.CSV";
        String distanciaS = nomeArquivo+"-DISTANCIAS.CSV";
        String naviosS = nomeArquivo+"-NAVIOS.CSV";
        String portosS = nomeArquivo+"-PORTOS.CSV";
        String tiposCargasS = nomeArquivo+"-TIPOSCARGAS.CSV";

        this.cargas = Paths.get("../programacao-orientada-objetos-trab-final", "src", "Arquivos", cargasS);
        this.clientes = Paths.get("../programacao-orientada-objetos-trab-final", "src", "Arquivos", clientesS);
        this.distancia = Paths.get("../programacao-orientada-objetos-trab-final", "src", "Arquivos", distanciaS);
        this.navios = Paths.get("../programacao-orientada-objetos-trab-final", "src", "Arquivos", naviosS);
        this.portos = Paths.get("../programacao-orientada-objetos-trab-final", "src", "Arquivos", portosS);
        this.tiposCargas = Paths.get("../programacao-orientada-objetos-trab-final", "src", "Arquivos", tiposCargasS);


    }

    public void carregarTudo(){
        carregarClientes();
        carregarDistancia();
        carregarNavios();
        carregarPortos();
    }




    private void carregarClientes(){
        ListaClientes a = ListaClientes.listaClientes();
        try (Scanner sc = new Scanner(Files.newBufferedReader(clientes, Charset.defaultCharset()))) {
            sc.useDelimiter(";"); // separadores: ; e nova linha
            sc.nextLine();
            while(sc.hasNextLine()){
                // cod;nome;email
                int cod = Integer.parseInt(sc.next());
                String nome = sc.next();
                String email = sc.nextLine().substring(1);
                a.cadastrarCliente(cod, nome, email);
                
            }
        } catch (IOException e1) {
            System.err.format("Erro de E/S: %s%n", e1);
        } catch (Exception e2) {
            System.out.println("Erro: " + e2);
            System.out.print("Erro - trace da falha: ");
            e2.printStackTrace();
        }
    }

    private void carregarDistancia(){
        ListaDistancia a = ListaDistancia.getInstance();
        try (Scanner sc = new Scanner(Files.newBufferedReader(distancia, Charset.defaultCharset()))) {
            sc.useDelimiter(";"); // separadores: ; e nova linha
            sc.nextLine();
            while(sc.hasNextLine()){
                int origem = Integer.parseInt(sc.next());
                int destino = Integer.parseInt(sc.next());
                String distanciaS = sc.nextLine().substring(1).replace(",", ".");
                double distancia = Double.parseDouble(distanciaS);
                a.cadastrarDistancia(origem, destino, distancia);
                
            }
        } catch (IOException e1) {
            System.err.format("Erro de E/S: %s%n", e1);
        } catch (Exception e2) {
            System.out.println("Erro: " + e2);
            System.out.print("Erro - trace da falha: ");
            e2.printStackTrace();
        }
    }

    private void carregarNavios(){
        ListaNavios a = ListaNavios.listaNavios();
        try (Scanner sc = new Scanner(Files.newBufferedReader(navios, Charset.defaultCharset()))) {
            sc.useDelimiter(";"); // separadores: ; e nova linha
            sc.nextLine();
            while(sc.hasNextLine()){
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
            System.err.format("Erro de E/S: %s%n", e1);
        } catch (Exception e2) {
            System.out.println("Erro: " + e2);
            System.out.print("Erro - trace da falha: ");
            e2.printStackTrace();
        }
    }

    private void carregarPortos(){
        ListaPortos a = ListaPortos.listaPortos();
        try (Scanner sc = new Scanner(Files.newBufferedReader(portos, Charset.defaultCharset()))) {
            sc.useDelimiter(";"); // separadores: ; e nova linha
            sc.nextLine();
            while(sc.hasNextLine()){
                //id;nome;pais
                int id = Integer.parseInt(sc.next());
                String nome = sc.next();
                String pais = sc.nextLine().substring(1);
                a.cadastrarPorto(id, nome, pais);                
            }
        } catch (IOException e1) {
            System.err.format("Erro de E/S: %s%n", e1);
        } catch (Exception e2) {
            System.out.println("Erro: " + e2);
            System.out.print("Erro - trace da falha: ");
            e2.printStackTrace();
        }
    }

        // public void carregarCargas(){
    //     try (Scanner sc = new Scanner(Files.newBufferedReader(cargas, Charset.defaultCharset()))) {
    //         sc.useDelimiter(";"); // separadores: ; e nova linha
    //         sc.nextLine();
    //         while(sc.hasNextLine()){
    //             // codigo;cliente;origem;destino;peso;valordeclarado;tempomaximo;tipocarga;prioridade;situacao

    //             int codigo = Integer.parseInt(sc.next());
    //             String cliente = sc.next();
    //             String origem = sc.next();
    //             String destino = sc.next();
    //             int peso = Integer.parseInt(sc.next());
    //             String valorS = sc.next().replace(",", ".");
    //             double valor = Double.parseDouble(valorS);


    
    //         }
    //     } catch (IOException e1) {
    //         System.err.format("Erro de E/S: %s%n", e1);
    //     } catch (Exception e2) {
    //         System.out.println("Erro: " + e2);
    //         System.out.print("Erro - trace da falha: ");
    //         e2.printStackTrace();
    //     }
    // }
}
