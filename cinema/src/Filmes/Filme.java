package Filmes;

public class Filme {

    private String nome;
    private String genero;
    private int duracao;
    private double preco;
    private int quantidade;
    private int ingressosVendidos;
    private double valorArrecadado;

    public Filme(String nome, String genero, int duracao, double preco, int quantidade) {
        this.nome = nome;
        this.genero = genero;
        this.duracao = duracao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.ingressosVendidos = 0;
        this.valorArrecadado = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getIngressosVendidos() {
        return ingressosVendidos;
    }

    public double getValorArrecadado() {
        return valorArrecadado;
    }

    public void venderIngressos(int quantidade) {
        this.quantidade -= quantidade;
        ingressosVendidos += quantidade;
        valorArrecadado += quantidade * preco;
    }

    public void exibirDados() {
        System.out.println("Filme: " + nome);
        System.out.println("Genero: " + genero);
        System.out.println("Duracao: " + duracao + " minutos");
        System.out.println("Preco: R$ " + preco);
        System.out.println("Ingressos disponiveis: " + quantidade);
        System.out.println("-----------------------------");
    }
}
