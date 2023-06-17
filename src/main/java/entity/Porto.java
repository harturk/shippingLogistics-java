package entity;

public class Porto {
    private int id;
    private String nome;
    private String pais;

    public Porto(int id, String nome, String pais) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getPais() {
        return this.pais;
    }

    public String toString(){
        return "<html>ID: "+ this.id + "<br>Nome:" + this.nome + "<br>Pais: " + this.pais+"<html>";
    }
}
