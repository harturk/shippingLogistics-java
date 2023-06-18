package entity;

import application.enums.CargaTipo;

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

    public double calculaPreco() {
        if (this.tipoCarga.getTipo() == CargaTipo.DURAVEL) {
            return 1.5 * this.peso + ((TipoCargaDuravel) this.getTipoCarga()).getIpi();
        }
        return this.peso * 2;
    }

    public String toString() {
        String cargaData = "<html>ID: " + this.id + "<br>Peso: " + this.peso + "<br>Valor Declarado: " + this.valorDeclarado
                + "<br>Tempo Máximo: "
                + this.tempoMaximo + "<br><html>";
        return cargaData + this.tipoCarga.toString();
    }
}
