package model;

import entity.Cliente;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaClientes {
    private ArrayList<Cliente> lista;

    // inner class
    private class ClienteCodComparator implements Comparator<Cliente> {

        @Override
        public int compare(Cliente cliente1, Cliente cliente2) {
            return Integer.compare(cliente1.getCod(), cliente2.getCod());
        }
    }

    public ListaClientes() {
        lista = new ArrayList<Cliente>();
    }

    public void cadastrarCliente(int cod, String nome, String email) {
        Cliente novoCliente = new Cliente(cod, nome, email);
        if (igual(novoCliente)) {
            System.err.println(
                    "Cliente com o mesmo email ou mesmo código já foi cadastrado, o cadastro foi cancelado.");
            return;
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
