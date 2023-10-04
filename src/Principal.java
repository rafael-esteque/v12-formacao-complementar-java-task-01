import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Endereco endereco1Rafael = new Endereco(1, "Rua ABC", 123, "Apto 456", "12345-671", "São Paulo", "SP", "Brasil");
        Contato contato1Rafael = new Contato("rafael@mail", "123456789", 1);
        Endereco endereco2Rafael = new Endereco(2, "Rua ABC2", 1232, "Apto 4562", "12345-671", "São Paulo", "SP", "Brasil");
        Contato contato2Rafael = new Contato("rafael2@mail", "223456789", 2);

        Endereco endereco1Mayra = new Endereco(1, "Rua DEF", 456, "Apto 789", "54321-871", "Porto Alegre", "RS", "Brasil");
        Contato contato1Mayra = new Contato("mayra@mail", "987654321", 1);
        Endereco endereco2Mayra = new Endereco(2, "Rua DEF2", 4562, "Apto 7892", "54321-871", "Porto Alegre", "RS", "Brasil");
        Contato contato2Mayra = new Contato("mayra2@mail", "287654321", 2);

        Contato[] contatosRafael = {contato1Rafael, contato2Rafael};
        Endereco[] enderecosRafael = {endereco1Rafael, endereco2Rafael};

        Contato[] contatosMayra = {contato1Mayra, contato2Mayra};
        Endereco[] enderecosMayra = {endereco1Mayra, endereco2Mayra};

        Cliente rafael = new Cliente("Rafael", "123.456.789-01", contatosRafael, enderecosRafael);
        Cliente mayra = new Cliente("Mayra", "987.654.321-02", contatosMayra, enderecosMayra);

        ContaCorrente contaRafael = new ContaCorrente(rafael, "1", "001", 1000.0, 500.0);
        ContaCorrente contaMayra = new ContaCorrente(mayra, "2", "001", 10000.0, 5000.0);

        // Inicia o autoatendimento para as contas criadas
        autoAtendimento(contaRafael, contaMayra);
    }

    private static void autoAtendimento(ContaCorrente conta1, ContaCorrente conta2) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o número da conta no início do atendimento
        System.out.print("Digite o número da conta");
        int numeroConta = scanner.nextInt();

        ContaCorrente contaCorrenteAtual = (numeroConta == 1) ? conta1 : conta2;

        while (true) {
            System.out.println("\nBoas vindas, " + contaCorrenteAtual.cliente.nome);
            System.out.println("Conta nº: " + contaCorrenteAtual.numeroConta);
            System.out.println("Seu saldo: " + contaCorrenteAtual.saldo);
            System.out.println("Opções:");
            System.out.println("1. Sacar");
            System.out.println("2. Depositar");
            System.out.println("3. Transferir");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção (1-4): ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Sacar
                    System.out.print("Digite o valor a ser sacado: ");
                    double valorSaque = scanner.nextDouble();
                    contaCorrenteAtual.sacar(valorSaque);
                    break;

                case 2:
                    // Depositar
                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    contaCorrenteAtual.depositar(valorDeposito);
                    break;

                case 3:
                    // Transferir
                    System.out.print("Digite o valor a ser transferido: ");
                    double valorTransferencia = scanner.nextDouble();
                    System.out.print("Digite o número da conta de destino: ");
                    int contaDestino = scanner.nextInt();

                    ContaCorrente contaDestinoAtual = (contaDestino == 1) ? conta1 : conta2;

                    if (contaDestinoAtual == contaCorrenteAtual) {
                        System.out.println("Não é possível transferir para a sua própria conta.");
                    } else {
                        if (contaCorrenteAtual.transferir(contaDestinoAtual, valorTransferencia)) {
                            System.out.println("Transferência realizada com sucesso para " + contaDestinoAtual.cliente.nome);
                        } else {
                            System.out.println("Transferência não foi possível. Verifique o saldo.");
                        }
                    }
                    break;

                case 4:
                    // Sair
                    System.out.println("\n ********************* \nATENDIMENTO ENCERRADO \n *********************");
                    System.out.println();
                    // Imprime os dados completos da conta
                    System.out.println("DADOS DA CONTA:");
                    System.out.println();
                    contaCorrenteAtual.imprimirContaCorrente();
                    System.out.println();
                    contaCorrenteAtual.cliente.imprimirEnderecos();
                    System.out.println();
                    contaCorrenteAtual.cliente.imprimirContatos();
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}