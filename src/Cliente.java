public class Cliente {
    public String nome;
    public String cpf;
    public Contato[] contatos;
    public Endereco[] enderecos;

    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    public void imprimirContatos() {
        System.out.println("Contatos do Cliente " + nome + ":");

        // Verifica se há contatos
        if (contatos != null) {
            for (Contato contato : contatos) {
                contato.imprimirContato();
                System.out.println(); // Adiciona uma linha em branco entre os contatos
            }
        } else {
            System.out.println("Nenhum contato disponível.");
        }
    };

    public void imprimirEnderecos() {
        System.out.println("Endereços do Cliente " + nome + ":");

        if (enderecos != null) {
            for (Endereco endereco : enderecos) {
                endereco.imprimeEndereco();
                System.out.println();
            }
        } else {
            System.out.println("Nenhum endereço disponível.");
        }
    };

    public void imprimirCliente() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
    }

}
