package model;

import entity.Navio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaNavios {
    private static ListaNavios instancia;
    private ArrayList<Navio> lista;


    /**
     * 
     *  inner class para definir o comparator
     */
    private class NavioNomeComparator implements Comparator<Navio> {

        @Override
        public int compare(Navio navio1, Navio navio2) {
            return navio1.getNome().compareTo(navio2.getNome());
        }

    }

    /**
     * O constructor esta private pelo motivo que o objeto é um singleton
     */
    private ListaNavios() {
        lista = new ArrayList<Navio>();
    }

    /**
     * Cria o objeto se for a primeira vez
     * @return O objeto em si
     */
    public static ListaNavios listaNavios(){
        if(instancia==null){
            instancia = new ListaNavios();
        }
        return instancia;
    }

    /**
     * Cadastra o navio se nada estiver errado
     * @param nome é o nome do navio e o nome precisa ser unico
     * @param velocidade precisa ser maior que zero
     * @param autonomia precisa ser maior que zero
     * @param custoMilhaPorMilhaBasico precisa ser maior que zero
     * @throws Exception se tentar cadastrar um navio com paramentro errados ira dar uma execao
     */
    public void cadastrarNavio(String nome, double velocidade, double autonomia, double custoMilhaPorMilhaBasico) throws Exception {
        Navio novoNavio = new Navio(nome, velocidade, autonomia, custoMilhaPorMilhaBasico);
        if (exists(novoNavio)) {
            throw new Exception("Navio com o mesmo nome já foi cadastrado, o cadastro foi cancelado.");
        }else if (velocidade<= 0){
            throw new Exception("A velocidade do navio não pode ser menor ou igual a zero, cadastro foi cancelado.");
        }else if (autonomia <= 0){
            throw new Exception("A Autonomia do navio não pode ser menor ou igual a zero, cadastro foi cancelado.");
        }else if (custoMilhaPorMilhaBasico<= 0){
            throw new Exception("O custo por milha do navio não pode ser menor ou igual a zero, cadastro foi cancelado.");
        }
        lista.add(novoNavio);

        ordenaLista();

    }

    
    /**
     * Verifica se tem um navio com mesmo nome na lista
     * @param navio que deseja verificar
     * @return  true se tiver um navio igual
     */
    private boolean exists(Navio navio) {
        String nomeNavio = navio.getNome().trim().toUpperCase();
        for (Navio n : lista) {
            String nomeN = n.getNome().trim().toUpperCase();
            if (nomeN.equals(nomeNavio)) {
                return true;
            }
        }
        return false;
    }

    public Navio searchNavio(String nomeNavio) {
        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Nao ha navio cadastrado.");
        }
        for (Navio n : lista) {
            if (n.getNome().equals(nomeNavio)) {
                return n;
            }
        }
        throw new IllegalArgumentException("Não existe navio com este identificador.");
    }

    /**
     * ordena a lista
     */
    private void ordenaLista() {
        NavioNomeComparator comparator = new NavioNomeComparator();
        Collections.sort(lista, comparator);
    }

    public ArrayList<String> getLista() {
        ArrayList<String> navios = new ArrayList<String>();
        for (Navio n : lista) {
            navios.add(n.toString());
        }
        return navios;
    }

    public ArrayList<Navio> getNavios() {
        return this.lista;
    }


    public ArrayList<String> getListCSV(){
        ArrayList<String> a = new ArrayList<>();
        for (Navio c : lista) {
            a.add(c.toStringCSV());
        }
        return a;
    }

}
