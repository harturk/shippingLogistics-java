package entity;

import application.enums.CargaTipo;

public abstract class TipoCarga {
    private int numero;
    private String descricao;
    private CargaTipo tipo;

    public TipoCarga(int numero, String descricao, CargaTipo tipo) {
        this.numero = numero;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public CargaTipo getTipo() {
        return this.tipo;
    }

    public String toString() {
        return "<html>Numero: " + this.numero + "<br>Descricao: " + this.descricao;
    }

}
