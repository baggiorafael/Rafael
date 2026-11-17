package Filmes;

import java.util.ArrayList;
import java.util.Scanner;

public class Cinema {

    private Scanner entrada;
    private ArrayList<Filme> filmes = new ArrayList<Filme>();

    public Cinema(Scanner entrada) {
        this.entrada = entrada;
    }

    public void cadastrarFilme() {
        System.out.println("Digite o nome do filme:");
        String nome = entrada.nextLine();

        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getNome().equalsIgnoreCase(nome)) {
                System.out.println("Esse filme ja esta cadastrado!");
                return;
            }
        }

        System.out.println("Digite o genero:");
        String genero = entrada.nextLine();

        System.out.println("Digite a duracao em minutos:");
        int duracao = entrada.nextInt();

        System.out.println("Digite o preco do ingresso:");
        double preco = entrada.nextDouble();

        System.out.println("Digite a quantidade de ingressos:");
        int quantidade = entrada.nextInt();
        entrada.nextLine();

        Filme novoFilme = new Filme(nome, genero, duracao, preco, quantidade);
        filmes.add(novoFilme);

        System.out.println("Filme cadastrado com sucesso!");
    }

    public void listarFilmes() {
        if (filmes.size() == 0) {
            System.out.println("Nenhum filme cadastrado!");
            return;
        }

        for (int i = 0; i < filmes.size(); i++) {
            filmes.get(i).exibirDados();
        }
    }

    public void comprarIngressos() {
        System.out.println("Digite o nome do filme:");
        String nome = entrada.nextLine();

        Filme filmeEncontrado = null;

        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getNome().equalsIgnoreCase(nome)) {
                filmeEncontrado = filmes.get(i);
                break;
            }
        }

        if (filmeEncontrado == null) {
            System.out.println("Filme nao encontrado!");
            return;
        }

        System.out.println("Quantos ingressos deseja comprar?");
        int quantidade = entrada.nextInt();
        entrada.nextLine();

        if (quantidade <= 0) {
            System.out.println("Quantidade invalida!");
            return;
        }

        if (quantidade > filmeEncontrado.getQuantidade()) {
            System.out.println("Nao temos ingressos suficientes!");
            return;
        }

        double total = quantidade * filmeEncontrado.getPreco();
        filmeEncontrado.venderIngressos(quantidade);

        System.out.printf("Compra realizada! Valor total: R$ %.2f%n", total);
    }

    public void relatorioVendas() {
        if (filmes.size() == 0) {
            System.out.println("Nenhum filme cadastrado!");
            return;
        }

        Filme maiorArrecadacao = filmes.get(0);
        double totalGeral = 0;

        System.out.println("========= RELATORIO DE VENDAS =========");

        for (int i = 0; i < filmes.size(); i++) {
            Filme filme = filmes.get(i);

            System.out.println("Filme: " + filme.getNome());
            System.out.println("Ingressos vendidos: " + filme.getIngressosVendidos());
            System.out.printf("Valor arrecadado: R$ %.2f%n", filme.getValorArrecadado());
            System.out.println("---------------------------------------");

            totalGeral += filme.getValorArrecadado();

            if (filme.getValorArrecadado() > maiorArrecadacao.getValorArrecadado()) {
                maiorArrecadacao = filme;
            }
        }

        System.out.println("Filme com maior arrecadacao: " + maiorArrecadacao.getNome());
        System.out.printf("Total arrecadado: R$ %.2f%n", totalGeral);
    }
}
