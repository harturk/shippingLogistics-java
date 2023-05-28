package entity;

public class Carga {
    private int indentificador;
    private int peso;
    private double valorDeclarado;
    private int tempoMaximo;

    public Carga(int indentificador, int peso, double valorDeclarado, int tempoMaximo) {
        this.indentificador = indentificador;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
        this.tempoMaximo = tempoMaximo;
    }

    public int getIndentificador() {
        return this.indentificador;
    }

    public int getPeso() {
        return this.peso;
    }

    public double getValorDeclarado() {
        return this.valorDeclarado;
    }

    public int getTempoMaximo() {
        return this.tempoMaximo;
    }
}
