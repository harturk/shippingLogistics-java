package application;

import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Escrita {
    private PrintWriter pw;

    // Construtor
    public Escrita(String fileName) throws Exception {
        Path path = Paths.get("../programacao-orientada-objetos-trab-final", "src", "Arquivos",fileName);
        pw = new PrintWriter(Files.newBufferedWriter(path, Charset.defaultCharset()));

    }

    public void printOutput(ArrayList<String> s) {
        for (String string : s) {
            pw.println(string);
            
        }
    }

    public void closeOutput() {
        pw.close();
    }
}