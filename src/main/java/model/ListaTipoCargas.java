package model;

import entity.TipoCarga;
import entity.TipoCargaDuravel;
import entity.TipoCargaPerecivel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaTipoCargas {
    private ArrayList<TipoCarga> lista;
    private static ListaTipoCargas listaTipoCargas;

    // inner class
    private class TipoCargaNumComparator implements Comparator<TipoCarga> {

        @Override
        public int compare(TipoCarga tipoCarga1, TipoCarga tipoCarga2) {
            return Integer.compare(tipoCarga1.getNumero(), tipoCarga2.getNumero());
        }
    }

    public static ListaTipoCargas ListaTipoCargas() {
        if(listaTipoCargas == null) {
            listaTipoCargas = new ListaTipoCargas();
        }
        return listaTipoCargas;
    }

    private ListaTipoCargas() {
        this.lista = new ArrayList<TipoCarga>();
    }

    public TipoCarga searchTipoCargas(int numero) {
        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Nao ha tipo de cargas cadastrado.");
        }
        for (TipoCarga t : lista) {
            if (t.getNumero() == numero) {
                return t;
            }
        }
        throw new IllegalArgumentException("Não existe tipo de carga com este identificador.");
    }

    public void cadastrarTipoCargaDuravel(
            int numero,
            String descricao,
            String setor,
            String material,
            double ipi) {
        TipoCargaDuravel novoTipoCarga = new TipoCargaDuravel(numero, descricao, setor, material, ipi);
        if (igual(novoTipoCarga)) {
            throw new IllegalArgumentException("Tipo de carga o mesmo numero já foi cadastrada, o cadastro foi cancelado.");
        }
        lista.add(novoTipoCarga);
        ordenaLista();
    }

    public void cadastrarTipoCargaPerecivel(
            int numero,
            String descricao,
            String origem,
            int validade) {
        TipoCargaPerecivel novoTipoCarga = new TipoCargaPerecivel(numero, descricao, origem, validade);
        if (igual(novoTipoCarga)) {
            throw new IllegalArgumentException("Tipo de carga o mesmo numero já foi cadastrada, o cadastro foi cancelado.");
        }
        lista.add(novoTipoCarga);
        ordenaLista();
    }

    private boolean igual(TipoCarga tipoCarga) {
        int tipoCargaNum = tipoCarga.getNumero();
        for (TipoCarga t : lista) {
            if (tipoCargaNum == t.getNumero()) {
                return true;
            }
        }
        return false;
    }

    private void ordenaLista() {
        TipoCargaNumComparator comparator = new TipoCargaNumComparator();
        Collections.sort(lista, comparator);
    }
}
