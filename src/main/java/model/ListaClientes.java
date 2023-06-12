package model;

import entity.Cliente;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaClientes {
    private ArrayList<Cliente> lista;
    private static ListaClientes instance;

    // inner class
    private class ClienteCodComparator implements Comparator<Cliente> {

        @Override
        public int compare(Cliente cliente1, Cliente cliente2) {
            return Integer.compare(cliente1.getCod(), cliente2.getCod());
        }
    }

    public static ListaClientes listaClientes() {
        if(instance == null) {
            instance = new ListaClientes();
        }
        return instance;
    }

    private ListaClientes() {
        lista = new ArrayList<Cliente>();
    }

    public void cadastrarCliente(int cod, String nome, String email) throws Exception {
        Cliente novoCliente = new Cliente(cod, nome, email);
        if (igual(novoCliente)) {
            throw new Exception("Cliente com o mesmo email ou mesmo código já foi cadastrado, o cadastro foi cancelado.");
        }else if(cod<0){
            throw new Exception("O codigo do cliente não pode ser negativo, o cadastro foi cancelado.");
        }
        lista.add(novoCliente);
        ordenaLista();
    }

    private boolean igual(Cliente cliente) {
        int clienteCod = cliente.getCod();
        String clienteEmail = cliente.getEmail();
        for (Cliente c : lista) {
            if (clienteCod == c.getCod() || clienteEmail.equals(c.getEmail())) {
                return true;
            }
        }
        return false;
    }

    private void ordenaLista() {
        ClienteCodComparator comparator = new ClienteCodComparator();
        Collections.sort(lista, comparator);
    }
}
