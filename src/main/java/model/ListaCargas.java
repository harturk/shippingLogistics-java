package model;

import entity.Carga;
import entity.TipoCarga;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import application.enums.Situacao;

public class ListaCargas {
    private ArrayList<Carga> lista;
    private Map<Integer, Situacao> situacao;
    private static ListaCargas listaCargas;

    // inner class
    private class CargaIdComparator implements Comparator<Carga> {

        @Override
        public int compare(Carga carga1, Carga carga2) {
            return Integer.compare(carga1.getId(), carga2.getId());
        }
    }

    private ListaCargas() {
        lista = new ArrayList<Carga>();
        situacao = new TreeMap<>();
    }

    public static ListaCargas ListaCargas() {
        if(listaCargas == null) {
            listaCargas = new ListaCargas();
        }
        return listaCargas;
    }

    public void cadastrarCarga(
            int identificador,
            int peso,
            double valorDeclarado,
            int tempoMaximo,
            TipoCarga tipoCarga) {
        Carga novaCarga = new Carga(identificador, peso, valorDeclarado, tempoMaximo, tipoCarga);
        if (igual(novaCarga)) {
            System.err.println("Carga com o mesmo identificador já foi cadastrada, o cadastro foi cancelado.");
            return;
        }
        lista.add(novaCarga);
        this.situacao.put(novaCarga.getId(), Situacao.ONGOING);
        ordenaLista();
    }

    private boolean igual(Carga carga) {
        int cargaId = carga.getId();
        for (Carga c : lista) {
            if (cargaId == c.getId()) {
                return true;
            }
        }
        return false;
    }

    private boolean igual(int id) {
        for (Carga c : lista) {
            if (id == c.getId()) {
                return true;
            }
        }
        return false;
    }

    private void ordenaLista() {
        CargaIdComparator comparator = new CargaIdComparator();
        Collections.sort(lista, comparator);
    }

    public void alteraSituacao(int id, String situacao) {
        if (!igual(id)) {
            throw new Exception("Carga não cadastrada.");
        }
        if (this.situacao.get(id) != Situacao.ONGOING) {
            throw new Exception("Situacao dessa carga não pode ser alterada pois se encontra "
                    + this.situacao.get(id).getDescricao());
        }
        switch (situacao) {
            case "CANCELLED":
                this.situacao.put(id, Situacao.CANCELLED);
                break;
            case "DELIVERED":
                this.situacao.put(id, Situacao.DELIVERED);
                break;
        }
    }
}
