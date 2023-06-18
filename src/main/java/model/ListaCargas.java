package model;

import entity.Carga;
import entity.Cliente;
import entity.Porto;
import entity.TipoCarga;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import application.enums.SituacaoCarga;

public class ListaCargas {
    private ArrayList<Carga> lista;
    private static ListaCargas listaCargas;

    // inner class
    private class CargaIdComparator implements Comparator<Carga> {

        @Override
        public int compare(Carga carga1, Carga carga2) {
            return Integer.compare(carga1.getId(), carga2.getId());
        }
    }

    public static ListaCargas listaCargas() {
        if(listaCargas == null) {
            listaCargas = new ListaCargas();
        }
        return listaCargas;
    }

    private ListaCargas() {
        lista = new ArrayList<Carga>();
    }

    public void cadastrarCarga(
            int identificador,
            int peso,
            int origemId,
            int destinoId,
            int clienteId,
            double valorDeclarado,
            int tempoMaximo,
            int tipoCarga
    ) throws Exception {
        ListaPortos portos = ListaPortos.listaPortos();
        ListaClientes clientes = ListaClientes.listaClientes();
        Porto origem = portos.searchPorto(origemId);
        Porto destino = portos.searchPorto(destinoId);
        Cliente cliente = clientes.searchCliente(clienteId);
        ListaTipoCargas listaTipoCargas = ListaTipoCargas.ListaTipoCargas();
        TipoCarga tipoCargaFinal = listaTipoCargas.searchTipoCargas(tipoCarga);
        Carga novaCarga = new Carga(identificador, peso, origem, destino, cliente, valorDeclarado, tempoMaximo, tipoCargaFinal);
        if (exists(novaCarga)) {
            throw new Exception("Carga com o mesmo identificador já foi cadastrada, o cadastro foi cancelado.");
        }
        lista.add(novaCarga);
        ordenaLista();
    }

    private boolean exists(Carga carga) {
        if (lista == null || lista.isEmpty()) {
            return false;
        }
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

    public Carga searchCarga(int idCarga) {
        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Nao ha carga cadastrado.");
        }
        for (Carga c : lista) {
            if (c.getId() == idCarga) {
                return c;
            }
        }
        throw new IllegalArgumentException("Não existe carga com este identificador.");
    }

    public ArrayList<String> getLista(){
        ArrayList<String> carga = new ArrayList<>();
        for (Carga c : lista) {
            carga.add(c.toString());
        }
        return carga;
    }
}
