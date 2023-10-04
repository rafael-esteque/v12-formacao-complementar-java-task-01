public class ContaCorrente {
    public Cliente cliente;
    public String numeroConta;
    public String agencia;
    public double saldo;
    public double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
    }

    public void imprimirContaCorrente() {
        System.out.println("Número da Conta: " + numeroConta);
        System.out.println("Agência: " + agencia);
        System.out.println("Saldo: " + saldo);
        System.out.println("Cheque Especial: " + chequeEspecial);

        // Chama o método imprimirCliente da classe Cliente
        if (cliente != null) {
            cliente.imprimirCliente();
        } else {
            System.out.println("Cliente não disponível.");
        }
    }

    public boolean sacar(double quantia) {
        double limiteTotal = saldo + chequeEspecial;

        if (quantia > 0 && limiteTotal >= quantia) {
            if (saldo >= quantia) {
                saldo -= quantia;
            } else {
                // Se não há saldo suficiente, usa o cheque especial
                chequeEspecial -= (quantia - saldo);
                saldo = 0; // Zera o saldo
            }
            return true; // Indica que o saque foi bem-sucedido
        } else {
            return false; // Indica que o saque não foi possível
        }
    }

    public boolean depositar(double quantia) {
        if (quantia > 0) {
            saldo += quantia;
            return true;
        } else {
            return false;
        }
    }

    public double retornarSaldoComChequeEspecial() {
        return saldo + chequeEspecial;
    }

    public boolean transferir(ContaCorrente contaDestino, double valor) {
        if (valor > 0 && (saldo + chequeEspecial) >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

}