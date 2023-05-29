package entity;

public class CargaPerecivel extends TipoCarga {
    private String origem;
    private int validade;

    public CargaPerecivel(int numero, String descricao, String origem, int validade) {
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
}