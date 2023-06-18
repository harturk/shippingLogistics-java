package application.enums;

public enum PrioridadeFrete {
    BARATO(1),
    RAPIDO(2);

    private final double fator;

    private PrioridadeFrete(final double fator) {
        this.fator = fator;
    }

    public double getFator() {
        return this.fator;
    }
}
