import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Campeonato campeonato = new Campeonato(entrada);

        int opcao;

        do {
            System.out.println("===== CAMPEONATO BRASILEIRO =====");
            System.out.println("1 - Cadastrar time");
            System.out.println("2 - Listar times");
            System.out.println("3 - Registrar partida");
            System.out.println("4 - Exibir classificacao");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opcao:");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    campeonato.cadastrarTime();
                    break;

                case 2:
                    campeonato.listarTimes();
                    break;

                case 3:
                    campeonato.registrarPartida();
                    break;

                case 4:
                    campeonato.exibirClassificacao();
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
