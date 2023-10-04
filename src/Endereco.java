public class Endereco {
    public int tipo;
    public String logradouro;
    public int numero;
    public String complemento;
    public String cep;
    public String cidade;
    public String estado;
    public String pais;

    public Endereco(int tipo, String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public void imprimeEndereco() {
        System.out.println("Tipo: " + tipo);
        System.out.println("Logradouro: " + tipo);
        System.out.println("Número: " + tipo);
        System.out.println("Complemento: " + tipo);
        System.out.println("CEP: " + tipo);
        System.out.println("Cidade: " + tipo);
        System.out.println("UF: " + tipo);
        System.out.println("País: " + tipo);
    }
}
