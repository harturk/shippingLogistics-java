package entity;

public class Carga {
    private int indentificador;
    private int peso;
    private double valorDeclarado;
    private int tempoMaximo;
    private TipoCarga tipoCarga;

    public Carga(int indentificador, int peso, double valorDeclarado, int tempoMaximo, TipoCarga tipoCarga) {
        this.indentificador = indentificador;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
        this.tempoMaximo = tempoMaximo;
        this.tipoCarga = tipoCarga;
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

    public TipoCarga getTipoCarga() {
        return this.tipoCarga;
    }
}
