package entity;

public class Distancia {
    private int origem;
    private int destino;
    private double distancia;

    public Distancia(int origem, int destino, double distancia) {
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
    }

    public int getOrigem() {
        return origem;
    }

    public int getDestino() {
        return destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public String toString(){
        return origem + " - " + destino + " - " + distancia;
    }
}
