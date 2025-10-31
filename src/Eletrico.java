public class Eletrico extends Veiculo {
    private double autonomiaBateria;
    private double capacidadeBateria;

    public Eletrico(String marca, String modelo, int anoFab, int mesFab, int anoMod, double valor, double autonomiaBateria, double capacidadeBateria) {
        super(marca, modelo, anoFab, mesFab, anoMod, valor);
        this.autonomiaBateria = autonomiaBateria;
        this.capacidadeBateria = capacidadeBateria;
    }

    @Override
    public double getAutonomia() {
        return this.autonomiaBateria;
    }

    @Override
    public String toString() {
        return super.toString() + " (Elétrico)";
    }
}
