package model;
import java.util.ArrayList;

import entity.Distancia;
public class ListaDistancia {
    private ArrayList<Distancia> lista;
    private static ListaDistancia INSTANCE;

    private ListaDistancia() {
        lista = new ArrayList<>();
    }

    public static ListaDistancia getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ListaDistancia();
        }
        return INSTANCE;
    }

    public void cadastrarDistancia(int origem, int destino, double distancia){
        Distancia d = new Distancia(origem, destino, distancia);
        lista.add(d);
    }
}
