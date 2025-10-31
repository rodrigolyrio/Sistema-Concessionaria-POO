import java.util.ArrayList;

public class Vendedor extends Funcionario {
    private double comissao;
    private ArrayList<Venda> vendas;

    public Vendedor(String nome, String cpf, int dia, int mes, int ano, double salario, double comissao) {
        super(nome, cpf, dia, mes, ano, salario);
        this.comissao = comissao;
        this.vendas = new ArrayList<>();
    }

    public void addVenda(Venda v) {
        this.vendas.add(v);
    }

    public ArrayList<Venda> getVendas() {
        return vendas;
    }

    public double comissaoTotal(int mes, int ano) {
        double totalComissao = 0;
        for (Venda v : this.vendas) {
            if (v.getData().getMes() == mes && v.getData().getAno() == ano) {
                totalComissao += v.valor() * (this.comissao / 100.0);
            }
        }
        return totalComissao;
    }

    public double comissaoTotal(int ano) {
        double totalComissao = 0;
        for (Venda v : this.vendas) {
            if (v.getData().getAno() == ano) {
                totalComissao += v.valor() * (this.comissao / 100.0);
            }
        }
        return totalComissao;
    }

    @Override
    public double getSalario(int mes, int ano) {
        return super.getSalario(mes, ano) + this.comissaoTotal(mes, ano);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
