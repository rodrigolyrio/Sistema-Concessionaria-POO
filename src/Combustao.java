public class Combustao extends Veiculo {
    private double autonomiaCombustao;
    private double capacidadeCombustao;

    public Combustao(String marca, String modelo, int anoFab, int mesFab, int anoMod, double valor, double autonomiaComb, double capacidadeComb) {
        super(marca, modelo, anoFab, mesFab, anoMod, valor);
        this.autonomiaCombustao = autonomiaComb;
        this.capacidadeCombustao = capacidadeComb;
    }

    @Override
    public double getAutonomia() {
        return this.autonomiaCombustao;
    }

    @Override
    public String toString() {
        return super.toString() + " (Combustão)";
    }
}

