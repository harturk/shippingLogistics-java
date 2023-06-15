package entity;

public abstract class TipoCarga {
    private int numero;
    private String descricao;
    private double fator;

    public TipoCarga(int numero, String descricao, double fator) {
        this.numero = numero;
        this.descricao = descricao;
        this.fator = fator;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public double getFator() {
        return this.fator;
    }

    public String toString() {
        return "Numero: " + this.numero + " Descricao: " + this.descricao;
    }

}
