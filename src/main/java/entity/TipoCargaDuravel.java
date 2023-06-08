package entity;

public class TipoCargaDuravel extends TipoCarga {
    private String setor;
    private String material;
    private double ipi;

    public TipoCargaDuravel(int numero, String descricao, String setor, String material, double ipi) {
        super(numero, descricao, 1.5);
        this.setor = setor;
        this.material = material;
        this.ipi = ipi;
    }

    public String getSetor() {
        return this.setor;
    }

    public String getMaterial() {
        return this.material;
    }

    public double getIpi() {
        return this.ipi;
    }
}