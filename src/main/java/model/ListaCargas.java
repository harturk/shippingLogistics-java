package model;

import entity.Carga;
import entity.TipoCarga;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaCargas {
    private ArrayList<Carga> lista;

    // inner class
    private class CargaIdComparator implements Comparator<Carga> {

        @Override
        public int compare(Carga carga1, Carga carga2) {
            return Integer.compare(carga1.getId(), carga2.getId());
        }
    }

    public ListaCargas() {
        lista = new ArrayList<Carga>();
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

    private void ordenaLista() {
        CargaIdComparator comparator = new CargaIdComparator();
        Collections.sort(lista, comparator);
    }
}
