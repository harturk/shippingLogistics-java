package application.enums;

public enum CustoRegiao {
    NACIONAL(10000),
    INTERNACIONAL(50000);

    private final double custo;

    private CustoRegiao(final double custo) {
        this.custo = custo;
    }

    public double getCusto() {
        return this.custo;
    }
}
