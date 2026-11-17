package Filmes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Cinema cinema = new Cinema(entrada);

        int opcao;

        do {
            System.out.println("======= CINEMA =======");
            System.out.println("1 - Cadastrar filme");
            System.out.println("2 - Listar filmes");
            System.out.println("3 - Comprar ingressos");
            System.out.println("4 - Relatorio de vendas");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opcao:");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    cinema.cadastrarFilme();
                    break;

                case 2:
                    cinema.listarFilmes();
                    break;

                case 3:
                    cinema.comprarIngressos();
                    break;

                case 4:
                    cinema.relatorioVendas();
                    break;

                case 0:
                    System.out.println("Programa encerrado!");
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;
            }

        } while (opcao != 0);

        entrada.close();
    }
}
