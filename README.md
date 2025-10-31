# Sistema de Gestão de Concessionária (POO)

## Descrição

Aplicação em Java que possui como propósito simular um sistema de gerenciamento para uma concessionária de veículos. O projeto foi desenvolvido como uma demonstração prática dos 4 pilares da Programação Orientada a Objetos (POO): Abstração, Encapsulamento, Herança e Polimorfismo. 

O sistema permite o cadastro de clientes, vendedores e gerentes, bem como de diferentes tipos de veículos (combustão, elétricos e híbridos). Também é possível registrar vendas e gerar relatórios detalhados.

## Funcionalidades

O sistema oferece as seguintes funcionalidades através de um menu interativo:

-   **Cadastro de Clientes:** Permite registrar novos clientes no sistema.
-   **Cadastro de Vendedores:** Adiciona novos vendedores, incluindo informações salariais e de comissão.
-   **Cadastro de Gerentes:** Permite o cadastro de gerentes com permissões especiais.
-   **Cadastro de Veículos:** Suporta o cadastro de 3 tipos de veículos:
    -   Combustão
    -   Elétricos
    -   Híbridos
-   **Registro de Vendas:** Associa um veículo, um cliente e um vendedor para registrar uma nova venda.
-   **Relatórios de Vendas:**
    -   **Mensal:** Exibe todas as vendas realizadas em um determinado mês e ano.
    -   **Anual:** Mostra um resumo de todas as vendas de um ano específico.
    -   **Por Vendedor:** Lista todas as vendas feitas por um vendedor específico.

## Pilares da Programação Orientada a Objetos no Projeto

-   **Abstração:** As classes `Pessoa` e `Veiculo` são exemplos de abstração, definindo atributos e métodos comuns que são herdados por outras classes mais específicas.
-   **Encapsulamento:** Os atributos das classes são declarados como `private` ou `protected`, e o acesso a eles é feito através de métodos `public` (getters e setters), garantindo a integridade dos dados.
-   **Herança:** A herança é amplamente utilizada para reutilizar código e criar uma hierarquia de classes. Como por exemplo: `Funcionario` herda de `Pessoa`, e `Vendedor` e `Gerente` herdam de `Funcionario`. Da mesma maneira, `Combustao`, `Eletrico` e `Hibrido` herdam da classe `Veiculo`.
-   **Poliomorfismo:** O polimorfismo é demonstrado através da sobrescrita de métodos. O método `toString()`, por exemplo, é implementado de forma diferente em várias classes para fornecer uma representação textual adequada para cada objeto...

## Como Executar o Projeto

1.  **Pré-requisitos:**
    * Java Development Kit (JDK) instalado.

2.  **Compilação e Execução:**
    * Clone ou faça o download deste repositório.
    * Navegue até a pasta `src` do projeto.
    * Compile os arquivos `.java` usando o comando:
        ```bash
        javac *.java
        ```
    * Execute a classe principal:
        ```bash
        java Main
        ```

## Estrutura do Projeto

O projeto está organizado da seguinte maneira:

-   **`src/`**: Contém todos os arquivos de código-fonte (`.java`).
    -   **`Main.java`**: Classe principal que inicia o sistema.
    -   **`Sistema.java`**: O núcleo do sistema, responsável por gerenciar todas as operações.
    -   **`Entrada.java`**: Classe utilitária para lidar com a entrada de dados do usuário.
    -   **Classes de Modelo**: `Pessoa`, `Funcionario`, `Cliente`, `Vendedor`, `Gerente`, `Veiculo`, `Combustao`, `Eletrico`, `Hibrido`, `Venda`, `Data`.
-   **`input.txt`**: Um arquivo de texto com dados de entrada que pode ser usado para testar o sistema de forma automatizada.
