package entity;

import application.enums.CustoRegiao;
import application.enums.PrioridadeFrete;
import model.ListaTrajetos;

public class Frete {
    private Navio navio;
    private Carga carga;
    private PrioridadeFrete prioridade;
    private CustoRegiao custoRegiao;

    public Frete(Navio navio, Carga carga, PrioridadeFrete prioridade) {
        this.navio = navio;
        this.carga = carga;
        this.prioridade = prioridade;
        CustoRegiao regiao = CustoRegiao.INTERNACIONAL;
        if (carga.getDestino().getPais().equals(carga.getOrigem().getPais())) {
            regiao = regiao.NACIONAL;
        }
        this.custoRegiao = regiao;
    }

    public Navio getNavio() {
        return this.navio;
    }

    public Carga getCarga() {
        return this.carga;
    }

    public PrioridadeFrete getPrioridade() {
        return this.prioridade;
    }

    public CustoRegiao getCustoRegiao() {
        return this.custoRegiao;
    }

    public double calculafrete() {
        ListaTrajetos listaTrajetos = ListaTrajetos.getInstance();
        Trajeto trajeto = listaTrajetos.searchTrajeto(carga.getOrigem(), carga.getDestino());
        int fatorPrioridade = 1;
        if (this.prioridade == PrioridadeFrete.RAPIDO) {
            fatorPrioridade = 2;
        }
        return (fatorPrioridade * this.navio.getCustoPorMilhaBasico()) * trajeto.getDistancia() + carga.calculaPreco() + this.custoRegiao.getCusto();
    }
}


