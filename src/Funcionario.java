public abstract class Funcionario extends Pessoa {
    protected double salario;

    public Funcionario(String nome, String cpf, int dia, int mes, int ano, double salario) {
        super(nome, cpf, dia, mes, ano);
        this.salario = salario;
    }

    public double getSalario(int mes, int ano) {
        return this.salario;
    }

    @Override
    public String toString() {
        return super.toString() + " - Salário Base: R$" + this.salario;
    }
}
