package model;

import java.util.ArrayList;

import application.enums.PrioridadeFrete;
import application.enums.SituacaoCarga;
import application.enums.SituacaoNavio;
import entity.Carga;
import entity.Frete;
import entity.Navio;
import entity.Trajeto;

public class ListaFretes {
    private static ListaFretes fretes;
    private ArrayList<Frete> lista;

    /**
     * O constructor esta private pelo motivo que o objeto é um singleton
     */
    private ListaFretes() {
        lista = new ArrayList<Frete>();
    }

    /**
     * Cria o objeto se for a primeira vez
     * @return O objeto em si
     */
    public static ListaFretes listaFretes(){
        if(fretes == null){
            fretes = new ListaFretes();
        }
        return fretes;
    }

    public void insereFrete(int idCarga, String prioridade) throws Exception {
        ListaCargas cargas = ListaCargas.listaCargas();
        Carga carga = cargas.searchCarga(idCarga);
        if (cargas.getSituacao(carga) != SituacaoCarga.PENDENTE) {
            throw new Exception("Carga já se encontra atribuída a uma entrega.");
        }
        PrioridadeFrete prioridadeFrete = PrioridadeFrete.BARATO;
        if (prioridade.equals("RAPIDO")) {
            prioridadeFrete = PrioridadeFrete.RAPIDO;
        }
        Navio navio = getNavioDisponivel(carga);
        Frete frete = new Frete(navio, carga, prioridadeFrete);
        lista.add(frete);
        this.alteraSituacaoCarga(carga, "LOCADO");
        this.alteraSituacaoNavio(navio);
    }

    public Navio getNavioDisponivel(Carga carga) throws Exception {
        ListaNavios navios = ListaNavios.listaNavios();
        ListaTrajetos trajetos = ListaTrajetos.getInstance();
        Trajeto trajeto = trajetos.searchTrajeto(carga.getOrigem(), carga.getDestino());
        for (Navio n : navios.getNavios()) {
            if (n.getSituacao() == SituacaoNavio.LIVRE && n.getAutonomia() <= trajeto.getDistancia()) {
                return n;
            }
        }
        this.alteraSituacaoCarga(carga, "CANCELADO");
        throw new Exception("Nao existe navio disponivel para efetuar essa entrega.");
    }

    public void entregaCarga(Frete frete) throws Exception {
        this.alteraSituacaoCarga(frete.getCarga(), "FINALIZADO");
        this.alteraSituacaoNavio(frete.getNavio());
    }

    private void alteraSituacaoCarga(Carga carga, String situacao) throws Exception {
        if (carga.getSituacao() == SituacaoCarga.CANCELADO || carga.getSituacao() == SituacaoCarga.FINALIZADO) {
            throw new Exception("Situacao dessa carga não pode ser alterada pois se encontra "
                    + carga.getSituacao().getDescricao());
        }
        switch (situacao) {
            case "CANCELADO":
                carga.setSituacao(SituacaoCarga.CANCELADO);
                break;
            case "FINALIZADO":
                carga.setSituacao(SituacaoCarga.FINALIZADO);
                break;
            case "PENDENTE":
                carga.setSituacao(SituacaoCarga.PENDENTE);
                break;
            case "LOCADO":
                carga.setSituacao(SituacaoCarga.LOCADO);
                break;
            case "EM_ANDAMENTO":
                carga.setSituacao(SituacaoCarga.EM_ANDAMENTO);
                break;
        }
    }

    private void alteraSituacaoNavio(Navio navio) {
        if (navio.getSituacao() == SituacaoNavio.OCUPADO) {
            navio.setSituacao(SituacaoNavio.LIVRE);
            return;
        }
        navio.setSituacao(SituacaoNavio.OCUPADO);
    }
}
