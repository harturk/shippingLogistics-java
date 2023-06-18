package application.enums;

public enum SituacaoNavio {
    OCUPADO("Ocupado"),
    LIVRE("Livre");

    private final String descricao;

    private SituacaoNavio(final String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
