package entity;

public class Cliente {
    private int cod;
    private String nome;
    private String email;

    public Cliente(int cod, String nome, String email) {
        this.cod = cod;
        this.nome = nome;
        this.email = email;
    }

    public int getCod() {
        return this.cod;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String toString() {
        return "<html>Cod: " + this.cod+ "<br>nome: " + this.nome +"<br>email: "+ this.email+"<html>";
    }

    public String toStringCSV() {
        String data = this.cod + ";" + this.nome + ";" + this.email;
        return data;
    }
}
