package application;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Classe de Leitura. Código trazido da aula, com um pequeno ajuste onde
 * inclui-se um
 * parâmetro para informar se o csv lido tem, ou não, cabeçalho.
 */

public class Leitura {
    private String path;
    private boolean hasHeader = false;

    public Leitura(String path) {
        this.path = path;
    }

    public Leitura(String path, boolean hasHeader) {
        this.path = path;
        this.hasHeader = hasHeader;
    }

    /**
     * Leitura dos dados dos objetos Pessoa de arquivo texto
     * Alternativa 1: uso do Scanner token a token
     */
    public void leRegistrosTexto() {
        String titulo;
        String precoBase;
        String tipo;
        String categoriaDuracao;
        try (Scanner sc = new Scanner(Files.newBufferedReader(Paths.get(this.path), Charset.defaultCharset()))) {
            sc.useDelimiter("[;\\n]"); // separadores: ; e nova linha
            if (this.hasHeader) {
                sc.nextLine();
            }
            while (sc.hasNext()) {
                titulo = sc.next().trim(); // Primeiro campo: titulo
                precoBase = sc.next().trim(); // Segundo campo: preco base
                tipo = sc.next().trim(); // Terceiro campo: tipo
                categoriaDuracao = sc.next().trim(); // Quarto campo: categoria ou duracao
                // Método para adicionar
                // Mensagem de inserção ou não
            }
        } catch (IOException e1) {
            System.err.format("Erro de E/S: %s%n", e1);
        } catch (Exception e2) {
            System.out.println("Erro: " + e2);
            System.out.print("Erro - trace da falha: ");
            e2.printStackTrace();
        }
    }
}
