public class Hibrido extends Veiculo {
    private double autonomiaCombustao;
    private double capacidadeCombustao;
    private double autonomiaBateria;
    private double capacidadeBateria;

    public Hibrido(String marca, String modelo, int anoFab, int mesFab, int anoMod, double valor, double autonomiaCombustao, double capacidadeCombustao, double autonomiaBateria, double capacidadeBateria) {
        super(marca, modelo, anoFab, mesFab, anoMod, valor);
        this.autonomiaCombustao = autonomiaCombustao;
        this.capacidadeCombustao = capacidadeCombustao;
        this.autonomiaBateria = autonomiaBateria;
        this.capacidadeBateria = capacidadeBateria;
    }

    @Override
    public double getAutonomia() {
        return this.autonomiaCombustao + this.autonomiaBateria;
    }

    @Override
    public String toString() {
        return super.toString() + " (Híbrido)";
    }
}