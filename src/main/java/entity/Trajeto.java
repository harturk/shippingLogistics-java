package entity;

public class Trajeto {
    private Porto origem;
    private Porto destino;
    private double distancia;

    public Trajeto(Porto origem, Porto destino, double distancia) {
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
    }

    public Porto getOrigem() {
        return origem;
    }

    public Porto getDestino() {
        return destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public String toString(){
        return origem + " - " + destino + " - " + distancia;
    }
}
