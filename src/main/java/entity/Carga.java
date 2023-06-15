package entity;

public class Carga {
    private int id;
    private int peso;
    private double valorDeclarado;
    private int tempoMaximo;
    private TipoCarga tipoCarga;

    public Carga(int id, int peso, double valorDeclarado, int tempoMaximo, TipoCarga tipoCarga) {
        this.id = id;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
        this.tempoMaximo = tempoMaximo;
        this.tipoCarga = tipoCarga;
    }

    public int getId() {
        return this.id;
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

    public String toString() {
        String cargaData = "ID: " + this.id + " Peso: " + this.peso + " Valor Declarado: " + this.valorDeclarado
                + "Tempo Máximo: "
                + this.tempoMaximo + "\n";
        return cargaData + this.tipoCarga.toString();
    }
}
