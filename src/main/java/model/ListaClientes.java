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
        if (instance == null) {
            instance = new ListaClientes();
        }
        return instance;
    }

    private ListaClientes() {
        lista = new ArrayList<Cliente>();
    }

    public void cadastrarCliente(int cod, String nome, String email) throws Exception {
        Cliente novoCliente = new Cliente(cod, nome, email);
        if (codExists(novoCliente)) {
            throw new Exception(
                    "Cliente com o mesmo código já foi cadastrado, o cadastro foi cancelado.");
        }
        if (emailExists(novoCliente)) {
            throw new Exception(
                    "Cliente com o mesmo email já foi cadastrado, o cadastro foi cancelado.");
        }
        if (cod < 0) {
            throw new Exception("O codigo do cliente não pode ser negativo, o cadastro foi cancelado.");
        }
        lista.add(novoCliente);
        ordenaLista();
    }

    private boolean codExists(Cliente cliente) {
        int clienteCod = cliente.getCod();
        for (Cliente c : lista) {
            if (clienteCod == c.getCod()) {
                return true;
            }
        }
        return false;
    }

    private boolean emailExists(Cliente cliente) {
        String clienteEmail = cliente.getEmail();
        for (Cliente c : lista) {
            if (clienteEmail.equals(c.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public Cliente searchCliente(int clienteId) {
        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Nao ha cliente cadastrado.");
        }
        for (Cliente c : lista) {
            if (c.getCod() == clienteId) {
                return c;
            }
        }
        throw new IllegalArgumentException("Não existe cliente com este identificador.");
    }

    private void ordenaLista() {
        ClienteCodComparator comparator = new ClienteCodComparator();
        Collections.sort(lista, comparator);
    }

    public ArrayList<String> getLista() {
        ArrayList<String> listaClientes = new ArrayList<String>();
        for (Cliente c : lista) {
            listaClientes.add(c.toString());
        }
        return listaClientes;
    }

    public ArrayList<String> getListCSV(){
        ArrayList<String> a = new ArrayList<>();
        for (Cliente c : lista) {
            a.add(c.toStringCSV());
        }
        return a;
    }
}
