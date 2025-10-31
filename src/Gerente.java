public class Gerente extends Funcionario {
    private String senha;

    public Gerente(String nome, String cpf, int dia, int mes, int ano, double salario, String senha) {
        super(nome, cpf, dia, mes, ano, salario);
        this.senha = senha;
    }

    public boolean validarAcesso(String senha) {
        if (this.senha.equals(senha)) {
            return true;
        } else {
            System.out.println("\nSenha inválida.");
            return false;
        }
    }
}
