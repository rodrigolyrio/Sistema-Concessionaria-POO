import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class Entrada {
    public Scanner input;
    private boolean lendoDoArquivo;

    public Entrada() {
        try {
            this.input = new Scanner(new FileInputStream("input.txt"), StandardCharsets.UTF_8.name());
            this.lendoDoArquivo = true;
        } catch (FileNotFoundException e) {
            this.lendoDoArquivo = false;
            this.input = new Scanner(System.in);
        }
    }

    private String lerLinha(String msg) {
        if (!this.lendoDoArquivo) {
            System.out.print(msg);
        }
        String linha = "";
        try {
            do {
                linha = this.input.nextLine();
            } while (linha.trim().isEmpty() || linha.trim().startsWith("#"));
        } catch (NoSuchElementException e) {
        }
        return linha;
    }

    private int lerInteiro(String msg) {
        if (!this.lendoDoArquivo) {
            System.out.print(msg);
        }
        while (this.input.hasNextLine()) {
            String linha = this.input.nextLine();
            if (linha.trim().isEmpty() || linha.trim().startsWith("#")) {
                continue;
            }
            try {
                return Integer.parseInt(linha.trim());
            } catch (NumberFormatException e) {
                continue;
            }
        }
        return -1;
    }

    private double lerDouble(String msg) {
        if (!this.lendoDoArquivo) {
            System.out.print(msg);
        }
        while (this.input.hasNextLine()) {
            String linha = this.input.nextLine();
            if (linha.trim().isEmpty() || linha.trim().startsWith("#")) {
                continue;
            }
            try {
                return Double.parseDouble(linha.trim());
            } catch (NumberFormatException e) {
                continue;
            }
        }
        return -1.0;
    }

    public int menu() {
        String msg = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastrar Cliente\n" +
                "2) Cadastrar Vendedor\n" +
                "3) Cadastrar Gerente\n" +
                "4) Cadastrar Veículo\n" +
                "5) Cadastrar Venda\n" +
                "6) Relatório de Vendas Mensal\n" +
                "7) Relatório de Vendas Anual\n" +
                "8) Relatório de Vendas do Vendedor\n" +
                "0) Sair\n";
        return this.lerInteiro(msg);
    }

    public void cadastrarCliente(Sistema sistema) {
        String nome = this.lerLinha("Digite o nome do cliente: ");
        String cpf = this.lerLinha("Digite o cpf do cliente: ");
        int dia = this.lerInteiro("Digite o dia do nascimento do cliente: ");
        int mes = this.lerInteiro("Digite o mês do nascimento do cliente: ");
        int ano = this.lerInteiro("Digite o ano do nascimento do cliente: ");
        String email = this.lerLinha("Digite o email do cliente: ");

        if (sistema.localizarCliente(cpf) == null && sistema.localizarVendedor(cpf) == null && sistema.localizarGerente(cpf) == null) {
            Cliente c = new Cliente(nome, cpf, dia, mes, ano, email);
            sistema.adicionar(c);
        } else {
            if (!this.lendoDoArquivo) {
                System.out.println("Erro: CPF duplicado. Cliente não adicionado.");
            }
        }
    }

    public void cadastrarVendedor(Sistema sistema) {
        String nome = lerLinha("Digite o nome do vendedor: ");
        String cpf = lerLinha("Digite o cpf do vendedor: ");
        int dia = lerInteiro("Digite o dia do nascimento do vendedor: ");
        int mes = lerInteiro("Digite o mês do nascimento do vendedor: ");
        int ano = lerInteiro("Digite o ano do nascimento do vendedor: ");
        double salario = lerDouble("Digite o salário mensal fixo do vendedor: ");
        double comissao = lerDouble("Digite o percentual de comissão deste vendedor: ");

        if (sistema.localizarCliente(cpf) == null && sistema.localizarVendedor(cpf) == null && sistema.localizarGerente(cpf) == null) {
            Vendedor v = new Vendedor(nome, cpf, dia, mes, ano, salario, comissao);
            sistema.adicionar(v);
        } else {
            if (!this.lendoDoArquivo) {
                System.out.println("Erro: CPF duplicado. Vendedor não adicionado.");
            }
        }
    }

    public void cadastrarGerente(Sistema sistema) {
        String nome = lerLinha("Digite o nome do gerente: ");
        String cpf = lerLinha("Digite o cpf do gerente: ");
        int dia = lerInteiro("Digite o dia do nascimento do gerente: ");
        int mes = lerInteiro("Digite o mês do nascimento do gerente: ");
        int ano = lerInteiro("Digite o ano do nascimento do gerente: ");
        double salario = lerDouble("Digite o salário mensal fixo do gerente: ");
        String senha = lerLinha("Digite a senha do gerente: ");

        if (sistema.localizarCliente(cpf) == null && sistema.localizarVendedor(cpf) == null && sistema.localizarGerente(cpf) == null) {
            Gerente g = new Gerente(nome, cpf, dia, mes, ano, salario, senha);
            sistema.adicionar(g);
        } else {
            if (!this.lendoDoArquivo) {
                System.out.println("Erro: CPF duplicado. Gerente não adicionado.");
            }
        }
    }

    public void cadastrarVeiculo(Sistema sistema) {
        String marca = lerLinha("Digite a Marca do veículo: ");
        String modelo = lerLinha("Digite o Modelo do veículo: ");
        int anoFab = lerInteiro("Digite o ano de fabricação do veículo: ");
        int mesFab = lerInteiro("Digite o mês de fabricação do veículo: ");
        int anoMod = lerInteiro("Digite o ano do modelo do veículo: ");
        double valor = lerDouble("Digite o valor do veículo: ");

        String msg = "Escolha o tipo do veículo:\n" +
                "1) Elétrico\n" +
                "2) Combustão\n" +
                "3) Híbrido: ";
        int tipo = lerInteiro(msg);

        Veiculo v = null;

        switch (tipo) {
            case 1: // Elétrico
                double autonomiaBateriaE = lerDouble("Digite a autonomia da bateria (em km): ");
                double capacidadeBateriaE = lerDouble("Digite a capacidade da bateria (em kwH): ");
                v = new Eletrico(marca, modelo, anoFab, mesFab, anoMod, valor, autonomiaBateriaE, capacidadeBateriaE);
                break;
            case 2: // Combustão
                double autonomiaCombustaoC = lerDouble("Digite a autonomia do motor (em km): ");
                double capacidadeCombustaoC = lerDouble("Digite a capacidade do motor (em L): ");
                v = new Combustao(marca, modelo, anoFab, mesFab, anoMod, valor, autonomiaCombustaoC, capacidadeCombustaoC);
                break;
            case 3: // Híbrido
                double autonomiaCombustaoH = lerDouble("Digite a autonomia do motor (em km): ");
                double capacidadeCombustaoH = lerDouble("Digite a capacidade do motor (em L): ");
                double autonomiaBateriaH = lerDouble("Digite a autonomia da bateria (em km): ");
                double capacidadeBateriaH = lerDouble("Digite a capacidade da bateria (em kwH): ");
                v = new Hibrido(marca, modelo, anoFab, mesFab, anoMod, valor, autonomiaCombustaoH, capacidadeCombustaoH, autonomiaBateriaH, capacidadeBateriaH);
                break;
            default:
                if (!this.lendoDoArquivo) {
                    System.out.println("Opção de veículo inválida.");
                }
                break;
        }

        if (v != null) {
            sistema.adicionar(v);
        }
    }

    public void cadastrarVenda(Sistema sistema) {
        if (!this.lendoDoArquivo) {
            sistema.listarVendedores();
        }
        String cpfVendedor = lerLinha("Digite o CPF do vendedor: ");
        Vendedor vendedor = sistema.localizarVendedor(cpfVendedor);
        if (vendedor == null) {
            if (!this.lendoDoArquivo) {
                System.out.println("Vendedor não encontrado.");
            }
            return;
        }

        if (!this.lendoDoArquivo) {
            sistema.listarVeiculos();
        }
        int numVeiculo = lerInteiro("Escolha um veículo pelo número: ");
        Veiculo veiculo = sistema.getVeiculo(numVeiculo);
        if (veiculo == null) {
            if (!this.lendoDoArquivo) {
                System.out.println("Veículo não encontrado.");
            }
            return;
        }

        if (!this.lendoDoArquivo) {
            sistema.listarClientes();
        }
        String cpfCliente = lerLinha("Digite o CPF do cliente: ");
        Cliente cliente = sistema.localizarCliente(cpfCliente);
        if (cliente == null) {
            if (!this.lendoDoArquivo) {
                System.out.println("Cliente não encontrado.");
            }
            return;
        }

        double desconto = lerDouble("Digite o desconto (em R$): ");
        int dia = lerInteiro("Digite o dia da venda: ");
        int mes = lerInteiro("Digite o mês da venda: ");
        int ano = lerInteiro("Digite o ano da venda: ");
        String chassi = lerLinha("Digite o chassi do veículo: ");

        Venda v = new Venda(veiculo, cliente, vendedor, desconto, dia, mes, ano, chassi);
        sistema.atribuirVendaVendedor(v, vendedor);
    }

    public void relatorioMensal(Sistema s) {
        int mes = lerInteiro("Digite o mês para o relatório: ");
        int ano = lerInteiro("Digite o ano para o relatório: ");
        s.relatorio(mes, ano);
    }

    public void relatorioAnual(Sistema s) {
        int ano = lerInteiro("Digite o ano para o relatório: ");
        s.relatorio(ano);
    }

    public void relatorioVendedor(Sistema s) {
        if (!this.lendoDoArquivo) {
            s.listarVendedores();
        }
        String cpfVendedor = lerLinha("Digite o CPF do vendedor para o relatório: ");
        Vendedor vendedor = s.localizarVendedor(cpfVendedor);
        if (vendedor != null) {
            s.relatorio(vendedor);
        } else {
            if (!this.lendoDoArquivo) {
                System.out.println("Vendedor não encontrado.");
            }
        }
    }
}