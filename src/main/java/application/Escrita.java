package application;

import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Escrita {
    private PrintWriter pw;

    // Construtor
    public Escrita(String fileName) {
        Path path = Paths.get(fileName);
        try {
            pw = new PrintWriter(Files.newBufferedWriter(path, Charset.defaultCharset()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void printOutput(String s) {
        pw.println(s);
    }

    public void closeOutput() {
        pw.close();
    }
}