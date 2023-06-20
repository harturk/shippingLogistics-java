package application.enums;

public enum SituacaoCarga {
    PENDENTE("Pendente"),
    FINALIZADO("Finalizado"),
    LOCADO("Locado"),
    CANCELADO("Cancelado");

    private final String descricao;

    private SituacaoCarga(final String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
