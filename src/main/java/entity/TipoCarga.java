package entity;

public class TipoCarga {
    private int numero;
    private String descricao;
    private double fator;

    public TipoCarga(int numero, String descricao, String tipo) {
        this.numero = numero;
        this.descricao = descricao;
        switch (tipo) {
            case "PERECIVEL":
                this.fator = 2.0;
                break;
            case "DURAVEL":
                this.fator = 1.5;
                break;
            default:
                throw new IllegalArgumentException("Tipo de carga inválido");
        }
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
}
