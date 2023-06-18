package application.enums;

public enum Situacao {
    PENDENTE("Pendente"),
    EM_ANDAMENTO("Em andamento"),
    FINALIZADO("Finalizado"),
    LOCADO("Locado"),
    CANCELADO("Cancelado");

    private final String descricao;

    private Situacao(final String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
