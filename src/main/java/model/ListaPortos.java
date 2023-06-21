package model;

import entity.Porto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaPortos {
    private static ListaPortos listaPortos;
    private ArrayList<Porto> lista;

    // inner class
    private class PortoIdComparator implements Comparator<Porto> {

        @Override
        public int compare(Porto porto1, Porto porto2) {
            return Integer.compare(porto1.getId(), porto2.getId());
        }

    }

    public static ListaPortos listaPortos() {
        if(listaPortos == null) {
            listaPortos = new ListaPortos();
        }
        return listaPortos;
    }

    private ListaPortos() {
        lista = new ArrayList<Porto>();
    }

    public void cadastrarPorto(int id, String nome, String pais) throws Exception {
        Porto novoPorto = new Porto(id, nome, pais);
        if (exists(novoPorto)) {
            throw new Exception("Porto com o mesmo identificador já foi cadastrado, o cadastro foi cancelado.");
        }else if(id<0) {
            throw new Exception("O identificador do porto não pode ser negativo, o cadastro foi cancelado.");
        }
        lista.add(novoPorto);
        ordenaLista();
    }

    public Porto searchPorto(int id) throws Exception {
        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Nao ha porto cadastrado.");
        }
        for (Porto p : lista) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new IllegalArgumentException("Não existe porto com este identificador.");
    }

    private boolean exists(Porto porto) {
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

    public ArrayList<String> getLista() {
        ArrayList<String> portos = new ArrayList<String>();
        for (Porto porto : lista) {
            portos.add(porto.toString());
        }
        return portos;
    }


    public ArrayList<String> getListCSV(){
        ArrayList<String> a = new ArrayList<>();
        for (Porto c : lista) {
            a.add(c.toStringCSV());
        }
        return a;
    }
    
}
