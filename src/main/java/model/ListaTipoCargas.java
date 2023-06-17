package model;

import entity.TipoCarga;
import entity.TipoCargaDuravel;
import entity.TipoCargaPerecivel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaTipoCargas {
    private ArrayList<TipoCarga> lista;

    // inner class
    private class TipoCargaNumComparator implements Comparator<TipoCarga> {

        @Override
        public int compare(TipoCarga tipoCarga1, TipoCarga tipoCarga2) {
            return Integer.compare(tipoCarga1.getNumero(), tipoCarga2.getNumero());
        }
    }

    public ListaTipoCargas() {
        this.lista = new ArrayList<TipoCarga>();
    }

    public void cadastrarTipoCargaDuravel(
            int numero,
            String descricao,
            String setor,
            String material,
            double ipi) {
        TipoCargaDuravel novoTipoCarga = new TipoCargaDuravel(numero, descricao, setor, material, ipi);
        if (igual(novoTipoCarga)) {
            throw new Exception("Tipo de carga o mesmo numero já foi cadastrada, o cadastro foi cancelado.");
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
            throw new Exception("Tipo de carga o mesmo numero já foi cadastrada, o cadastro foi cancelado.");
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
