import java.util.ArrayList;

public class Sistema {
    private ArrayList<Cliente> clientes;
    private ArrayList<Vendedor> vendedores;
    private ArrayList<Gerente> gerentes;
    private ArrayList<Veiculo> veiculos;

    public Sistema() {
        this.clientes = new ArrayList<>();
        this.vendedores = new ArrayList<>();
        this.gerentes = new ArrayList<>();
        this.veiculos = new ArrayList<>();
    }

    public void adicionar(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void adicionar(Vendedor vendedor) {
        this.vendedores.add(vendedor);
    }

    public void adicionar(Gerente gerente) {
        this.gerentes.add(gerente);
    }

    public void adicionar(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public void listarClientes() {
        System.out.println("\nClientes cadastrados:");
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado");
        } else {
            for (Cliente c : this.clientes) {
                System.out.println(c.toString());
            }
        }
    }

    public void listarVendedores() {
        System.out.println("\nVendedores cadastrados:");
        if (vendedores.isEmpty()) {
            System.out.println("Nenhum vendedor cadastrado");
        } else {
            for (Vendedor v : this.vendedores) {
                System.out.println(v.getNome() + " CPF: " + v.getCpf());
            }
        }
    }

    public void listarVeiculos() {
        System.out.println("\nVeiculos cadastrados:");
        if(veiculos.isEmpty()){
            System.out.println("Nenhum veiculo cadastrado");
        } else {
            int i = 1;
            for(Veiculo v: this.veiculos){
                System.out.println(i + ") " + v);
                i++;
            }
        }
    }

    public Cliente localizarCliente(String cpf) {
        for (Cliente c : this.clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public Vendedor localizarVendedor(String cpf) {
        for (Vendedor v : this.vendedores) {
            if (v.getCpf().equals(cpf)) {
                return v;
            }
        }
        return null;
    }

    public Gerente localizarGerente(String cpf) {
        for (Gerente g : this.gerentes) {
            if (g.getCpf().equals(cpf)) {
                return g;
            }
        }
        return null;
    }

    public Veiculo getVeiculo(int index){
        if(index > 0 && index <= veiculos.size()){
            return veiculos.get(index-1);
        }
        return null;
    }

    public void atribuirVendaVendedor(Venda venda, Vendedor vendedor) {
        vendedor.addVenda(venda);
    }

    public void relatorio(int mes, int ano) {
        System.out.println("\nRELATÓRIO DE VENDAS MENSAL DE " + mes + "/" + ano + ":");
        double totalMes = 0;
        boolean encontrouVenda = false;
        for (Vendedor vendedor : this.vendedores) {
            for (Venda venda : vendedor.getVendas()) {
                if (venda.getData().getMes() == mes && venda.getData().getAno() == ano) {
                    System.out.println("Vendedor: " + vendedor.getNome() + " (Salário neste mês: R$" + vendedor.getSalario(mes, ano) + ")");
                    System.out.println(venda);
                    System.out.println("***************************************");
                    totalMes += venda.valor();
                    encontrouVenda = true;
                }
            }
        }
        if (encontrouVenda) {
            System.out.println("Total: R$" + totalMes);
        } else {
            System.out.println("Nenhuma venda encontrada para este mês.");
        }
        System.out.println();
    }

    public void relatorio(int ano) {
        System.out.println("\nRELATÓRIO DE VENDAS ANUAL DE " + ano + ":");
        double totalAno = 0;
        ArrayList<Venda> vendasDoAno = new ArrayList<>();
        for (Vendedor vendedor : this.vendedores) {
            for (Venda venda : vendedor.getVendas()) {
                if (venda.getData().getAno() == ano) {
                    vendasDoAno.add(venda);
                }
            }
        }

        for (Venda venda : vendasDoAno) {
            System.out.println("Vendedor: " + venda.getVendedor().getNome());
            System.out.println(venda);
            System.out.println("***************************************");
            totalAno += venda.valor();
        }

        if (!vendasDoAno.isEmpty()) {
            System.out.println("Total: R$" + totalAno);
        } else {
            System.out.println("Nenhuma venda encontrada para este ano.");
        }
        System.out.println();
    }

    public void relatorio(Vendedor vendedor) {
        System.out.println("\nRELATÓRIO DE VENDAS DO VENDEDOR:");
        System.out.println(" Vendas do vendedor " + vendedor.getNome() + " :");
        double totalVendedor = 0;
        ArrayList<Venda> vendasDoVendedor = vendedor.getVendas();

        for (Venda venda : vendasDoVendedor) {
            System.out.println(venda);
            System.out.println("***************************************");
            totalVendedor += venda.valor();
        }

        if (!vendasDoVendedor.isEmpty()) {
            System.out.println("Total: R$" + totalVendedor);
        } else {
            System.out.println("Nenhuma venda encontrada para este vendedor.");
        }
    }
}
