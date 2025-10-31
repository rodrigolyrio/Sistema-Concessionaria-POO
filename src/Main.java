public class Main {

    // NOME DOS INTEGRANTES: MYLLENA TONIATO, RODRIGO LYRIO

    public static void main(String[] args) {
        Entrada entrada = new Entrada(); //entrada
        Sistema sistema = new Sistema();

        int opcao = entrada.menu();

        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    entrada.cadastrarCliente(sistema);
                    break;
                case 2:
                    entrada.cadastrarVendedor(sistema);
                    break;
                case 3:
                    entrada.cadastrarGerente(sistema);
                    break;
                case 4:
                    entrada.cadastrarVeiculo(sistema);
                    break;
                case 5:
                    entrada.cadastrarVenda(sistema);
                    break;
                case 6:
                    entrada.relatorioMensal(sistema);
                    break;
                case 7:
                    entrada.relatorioAnual(sistema);
                    break;
                case 8:
                    entrada.relatorioVendedor(sistema);
                    break;
            }
            opcao = entrada.menu();
        }
    }
}