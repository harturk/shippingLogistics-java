package model;

import entity.Porto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaPortos {
    private ArrayList<Porto> lista;

    // inner class
    private class PortoIdComparator implements Comparator<Porto> {

        @Override
        public int compare(Porto porto1, Porto porto2) {
            return Integer.compare(porto1.getId(), porto2.getId());
        }

    }

    public ListaPortos() {
        lista = new ArrayList<Porto>();
    }

    public void cadastrarPorto(int id, String nome, String pais) {
        Porto novoPorto = new Porto(id, nome, pais);
        if (igual(novoPorto)) {
            System.err.println("Porto com o mesmo identificador já foi cadastrado, o cadastro foi cancelado.");
            return;
        }
        lista.add(novoPorto);
        ordenaLista();
    }

    private boolean igual(Porto porto) {
        int portoId = porto.getId();
        for (Porto p : lista) {
            if (portoId == p.getId()) {
                return true;
            }
        }
        return false;
    }

    private void ordenaLista() {
        PortoIdComparator comparator = new PortoIdComparator();
        Collections.sort(lista, comparator);
    }
}
