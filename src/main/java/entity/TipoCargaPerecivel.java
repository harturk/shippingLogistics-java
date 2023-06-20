package entity;

import application.enums.CargaTipo;

public class TipoCargaPerecivel extends TipoCarga {
    private String origem;
    private int validade;

    public TipoCargaPerecivel(int numero, String descricao, String origem, int validade) {
        super(numero, descricao, CargaTipo.PERECIVEL);
        this.origem = origem;
        this.validade = validade;
    }

    public String getOrigem() {
        return this.origem;
    }

    public int getValidade() {
        return this.validade;
    }

    @Override
    public String toString() {
        return super.toString() + "<br>Origem: " + this.getOrigem() + "<br>Validade: " + this.getValidade()+"<html>";
    }

    public String toStringCSV() {
        return this.getNumero() + ";" + this.getDescricao() + ";" + "PERECIVEL" + ";" + this.origem + ";" + this.validade;
    }
}