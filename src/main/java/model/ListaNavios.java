package model;

import entity.Navio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaNavios {
    private static ListaNavios instancia;
    private ArrayList<Navio> lista;

    // inner class
    private class NavioNomeComparator implements Comparator<Navio> {

        @Override
        public int compare(Navio navio1, Navio navio2) {
            return navio1.getNome().compareTo(navio2.getNome());
        }

    }

    private ListaNavios() {
        lista = new ArrayList<Navio>();
    }

    public static ListaNavios listaNavios(){
        if(instancia==null){
            instancia = new ListaNavios();
        }
        return instancia;
    }

    public void cadastrarNavio(String nome, double velocidade, double autonomia, double custoMilhaPorMilhaBasico) {
        Navio novoNavio = new Navio(nome, velocidade, autonomia, custoMilhaPorMilhaBasico);
        if (igual(novoNavio)) {
            System.err.println("Navio com o mesmo nome já foi cadastrado, o cadastro foi cancelado.");
            return;
        }
        lista.add(novoNavio);

        ordenaLista();

    }

    

    private boolean igual(Navio navio) {
        String nomeNavio = navio.getNome().trim().toUpperCase();
        for (Navio n : lista) {
            String nomeN = n.getNome().trim().toUpperCase();
            if (nomeN.equals(nomeNavio)) {
                return true;
            }
        }
        return false;
    }

    private void ordenaLista() {
        NavioNomeComparator comparator = new NavioNomeComparator();
        Collections.sort(lista, comparator);
    }

}
