public class Venda {
    private Veiculo veiculo;
    private Cliente cliente;
    private Vendedor vendedor;
    private double desconto;
    private Data data;
    private String chassi;

    public Venda(Veiculo veiculo, Cliente cliente, Vendedor vendedor, double desconto, int dia, int mes, int ano, String chassi) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.desconto = desconto;
        this.data = new Data(dia, mes, ano);
        this.chassi = chassi;
    }

    public double valor() {
        return this.veiculo.getValor() - this.desconto;
    }

    public void setDesconto(double desconto, Gerente gerente, String senha) {
        if (gerente.validarAcesso(senha)) {
            this.desconto = desconto;
        }
    }

    public Data getData() {
        return data;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    @Override
    public String toString() {
        return "Veiculo: " + this.veiculo.toString() + "\n" +
                "Cliente: " + this.cliente.toString() + "\n" +
                "Valor da venda: R$" + this.valor() + "\n" +
                "Data: " + this.data.toString();
    }
}

