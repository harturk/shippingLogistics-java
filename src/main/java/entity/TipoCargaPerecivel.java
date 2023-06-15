package entity;

public class TipoCargaPerecivel extends TipoCarga {
    private String origem;
    private int validade;

    public TipoCargaPerecivel(int numero, String descricao, String origem, int validade) {
        super(numero, descricao, 2);
        this.origem = origem;
        this.validade = validade;
    }

    public String getOrigem() {
        return this.origem;
    }

    public int getValidade() {
        return this.validade;
    }

    public String toString() {
        return super.toString() + " Origem:" + this.getOrigem() + " Validade:" + this.getValidade();
    }
}