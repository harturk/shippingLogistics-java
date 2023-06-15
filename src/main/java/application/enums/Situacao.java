package application.enums;

public enum Situacao {
    ONGOING("Em andamento"),
    DELIVERED("Finalizado"),
    CANCELLED("Cancelado");

    private final String descricao;

    private Situacao(final String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
