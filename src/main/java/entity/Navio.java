package entity;

import application.enums.SituacaoNavio;

public class Navio {
    private String nome;
    private double velocidade;
    private double autonomia;
    private double custoPorMilhaBasico;
    private SituacaoNavio situacao;

    public Navio(String nome, double velocidade, double autonomia, double custoMilhaPorMilhaBasico) {
        this.nome = nome;
        this.velocidade = velocidade;
        this.autonomia = autonomia;
        this.custoPorMilhaBasico = custoMilhaPorMilhaBasico;
        this.situacao = SituacaoNavio.LIVRE;
    }

    /**
     * @return nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * @return valocidade
     */
    public double getVelocidade() {
        return this.velocidade;
    }

    /**
     * @return autonomia
     */
    public double getAutonomia() {
        return this.autonomia;
    }

    /**
     * @return custoPorMilhaBasico
     */
    public double getCustoPorMilhaBasico() {
        return this.custoPorMilhaBasico;
    }

    public SituacaoNavio getSituacao() {
        return this.situacao;
    }

    public void setSituacao(SituacaoNavio situacao) {
        this.situacao = situacao;
    }

    public String toString() {
        return "<html>Nome: " + this.nome + "<br>Velocidade: " + this.velocidade + "<br>Autonomia: " + this.autonomia
                + "<br>Situacao: " + this.situacao.getDescricao() + "<br>Custo por milha: " + this.custoPorMilhaBasico + "<html>";
    }

    public String toStringCSV() {
        String data = this.nome + ";" + this.velocidade + ";" + this.autonomia + ";" + this.custoPorMilhaBasico;
        return data;
    }
}
