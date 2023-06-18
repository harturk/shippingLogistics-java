package model;

import java.util.ArrayList;

import entity.Porto;
import entity.Trajeto;

public class ListaTrajetos {
    private ArrayList<Trajeto> lista;
    private static ListaTrajetos INSTANCE;

    private ListaTrajetos() {
        lista = new ArrayList<>();
    }

    public static ListaTrajetos getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ListaTrajetos();
        }
        return INSTANCE;
    }

    public Trajeto searchTrajeto(Porto origem, Porto destino) {
        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Nao ha trajeto cadastrado.");
        }
        for (Trajeto t : lista) {
            if (t.getOrigem().getId() == origem.getId() && t.getDestino().getId() == destino.getId()) {
                return t;
            }
        }
        throw new IllegalArgumentException("Não existe trajeto com essa origem e destino.");
    }

    public boolean exists(int origemId, int destinoId) {
        if (lista.isEmpty()) {
            return false;
        }
        for (Trajeto t : lista) {
            if (t.getOrigem().getId() == origemId && t.getDestino().getId() == destinoId) {
                return true;
            }
        }
        return false;
    }

    public void cadastrarTrajeto(int origem, int destino, double distancia) throws Exception {
        if (exists(origem, destino)) {
            throw new Exception("Trajeto já cadastrado.");
        }
        ListaPortos listaPortos = ListaPortos.listaPortos();
        Porto p1 = listaPortos.searchPorto(origem);
        Porto p2 = listaPortos.searchPorto(destino);
        Trajeto d = new Trajeto(p1, p2, distancia);
        lista.add(d);
    }
}
