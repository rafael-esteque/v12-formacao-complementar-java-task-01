public class Contato {
    public String descricao;
    public String telefone;
    public int tipo;

    public Contato(String descricao, String telefone, int tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public void imprimirContato() {
        System.out.println("Descrição: " + descricao);
        System.out.println("Telefone: " + telefone);
        System.out.println("Tipo: " + tipo);
    }
}
