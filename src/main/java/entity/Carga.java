package entity;

import application.enums.CargaTipo;
import application.enums.PrioridadeFrete;
import application.enums.SituacaoCarga;

public class Carga {
    private int id;
    private int peso;
    private Porto origem;
    private Porto destino;
    private Cliente cliente;
    private double valorDeclarado;
    private int tempoMaximo;
    private TipoCarga tipoCarga;
    private SituacaoCarga situacao;
    private PrioridadeFrete prioridade;

    public Carga(int id, int peso, Porto origem, Porto destino, Cliente cliente, double valorDeclarado, int tempoMaximo,
            TipoCarga tipoCarga, PrioridadeFrete prioridade) {
        this.id = id;
        this.peso = peso;
        this.origem = origem;
        this.destino = destino;
        this.cliente = cliente;
        this.valorDeclarado = valorDeclarado;
        this.tempoMaximo = tempoMaximo;
        this.tipoCarga = tipoCarga;
        this.situacao = SituacaoCarga.PENDENTE;
        this.prioridade = prioridade;
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

    public Porto getOrigem() {
        return this.origem;
    }

    public Porto getDestino() {
        return this.destino;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public SituacaoCarga getSituacao() {
        return this.situacao;
    }

    public void setSituacao(SituacaoCarga situacao) {
        this.situacao = situacao;
    }

    public PrioridadeFrete getPrioridade() {
        return this.prioridade;
    }

    public double calculaPreco() {
        if (this.tipoCarga.getTipo() == CargaTipo.DURAVEL) {
            return 1.5 * this.peso + ((TipoCargaDuravel) this.getTipoCarga()).getIpi();
        }
        return this.peso * 2;
    }

    public String toString() {
        String cargaData = "<html>ID: " + this.id + "<br>Peso: " + this.peso + "<br>Origem: " + this.origem.getId()
                + "<br>Destino: " + this.destino.getId() + "<br>Cliente: " + this.cliente.getNome()
                + "<br>Valor Declarado: " + this.valorDeclarado
                + "<br>Tempo Máximo: " + this.tempoMaximo + "<br>Prioridade:" + this.prioridade.toString()
                + "</br> Situação: " + this.situacao.getDescricao()

                + "<br><html>";
        return cargaData + this.tipoCarga.toString();
    }

    public String toStringCSV() {
        String data = this.id + ";" + this.cliente.getCod() + ";" + this.origem.getId() + ";" + this.destino.getId()
                + ";" + this.peso + ";" + this.valorDeclarado + ";" + this.tempoMaximo + ";"
                + this.tipoCarga.getNumero() + ";" + this.prioridade + ";" + this.situacao;
        return data;
    }
}
