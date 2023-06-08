package entity;

public class Navio {
    private String nome;
    private double velocidade;
    private double autonomia;
    private double custoPorMilhaBasico;

    public Navio(String nome, double velocidade, double autonomia, double custoMilhaPorMilhaBasico) {
        this.nome = nome;
        this.velocidade = velocidade;
        this.autonomia = autonomia;
        this.custoPorMilhaBasico = custoMilhaPorMilhaBasico;
    }

    /**
     * 
     * @return nome
     */
    public String getNome() {
        return this.nome;
    }


    /**
     * 
     * @return valocidade
     */
    public double getVelocidade() {
        return this.velocidade;
    }


    /**
     * 
     * @return autonomia
     */
    public double getAutonomia() {
        return this.autonomia;
    }

    /**
     * 
     * @return custoPorMilhaBasico
     */
    public double getCustoPorMilhaBasico() {
        return this.custoPorMilhaBasico;
    }
}
