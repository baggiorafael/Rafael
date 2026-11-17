import java.util.ArrayList;
import java.util.Scanner;

public class Campeonato {

    private ArrayList<Time> times = new ArrayList<Time>();
    private Scanner entrada;

    public Campeonato(Scanner entrada) {
        this.entrada = entrada;
    }

    public void cadastrarTime() {
        System.out.println("Digite o nome do time:");
        String nome = entrada.nextLine();

        for (int i = 0; i < times.size(); i++) {
            if (times.get(i).getNome().equalsIgnoreCase(nome)) {
                System.out.println("Esse time ja esta cadastrado!");
                return;
            }
        }

        Time novoTime = new Time(nome);
        times.add(novoTime);

        System.out.println("Time cadastrado com sucesso!");
    }

    public void listarTimes() {
        if (times.size() == 0) {
            System.out.println("Nenhum time cadastrado!");
            return;
        }

        for (int i = 0; i < times.size(); i++) {
            times.get(i).exibirDados();
        }
    }

    public Time procurarTime(String nome) {
        for (int i = 0; i < times.size(); i++) {
            if (times.get(i).getNome().equalsIgnoreCase(nome)) {
                return times.get(i);
            }
        }

        return null;
    }

    public void registrarPartida() {
        System.out.println("Digite o nome do time mandante:");
        String nomeMandante = entrada.nextLine();

        System.out.println("Digite o nome do time visitante:");
        String nomeVisitante = entrada.nextLine();

        if (nomeMandante.equalsIgnoreCase(nomeVisitante)) {
            System.out.println("Um time nao pode jogar contra ele mesmo!");
            return;
        }

        Time mandante = procurarTime(nomeMandante);
        Time visitante = procurarTime(nomeVisitante);

        if (mandante == null || visitante == null) {
            System.out.println("Um ou os dois times nao foram encontrados!");
            return;
        }

        System.out.println("Digite os gols do mandante:");
        int golsMandante = entrada.nextInt();

        System.out.println("Digite os gols do visitante:");
        int golsVisitante = entrada.nextInt();
        entrada.nextLine();

        if (golsMandante < 0 || golsVisitante < 0) {
            System.out.println("Os gols nao podem ser negativos!");
            return;
        }

        mandante.adicionarGols(golsMandante, golsVisitante);
        visitante.adicionarGols(golsVisitante, golsMandante);

        if (golsMandante > golsVisitante) {
            mandante.registrarVitoria();
            visitante.registrarDerrota();
        } else if (golsVisitante > golsMandante) {
            visitante.registrarVitoria();
            mandante.registrarDerrota();
        } else {
            mandante.registrarEmpate();
            visitante.registrarEmpate();
        }

        System.out.println("Partida registrada com sucesso!");
    }

    public void exibirClassificacao() {
        if (times.size() == 0) {
            System.out.println("Nenhum time cadastrado!");
            return;
        }

        ArrayList<Time> tabela = new ArrayList<Time>(times);

        // Ordena por pontos e, em caso de empate, por saldo de gols.
        for (int i = 0; i < tabela.size() - 1; i++) {
            for (int j = i + 1; j < tabela.size(); j++) {
                if (tabela.get(j).getPontos() > tabela.get(i).getPontos()
                        || (tabela.get(j).getPontos() == tabela.get(i).getPontos()
                        && tabela.get(j).getSaldoGols() > tabela.get(i).getSaldoGols())) {

                    Time auxiliar = tabela.get(i);
                    tabela.set(i, tabela.get(j));
                    tabela.set(j, auxiliar);
                }
            }
        }

        System.out.println("========== CLASSIFICACAO ==========");
        System.out.printf("%-5s %-18s %4s %3s %3s %3s %4s%n",
                "Pos", "Time", "Pts", "V", "E", "D", "SG");

        for (int i = 0; i < tabela.size(); i++) {
            Time time = tabela.get(i);

            System.out.printf("%-5s %-18s %4d %3d %3d %3d %4d%n",
                    (i + 1) + "o",
                    time.getNome(),
                    time.getPontos(),
                    time.getVitorias(),
                    time.getEmpates(),
                    time.getDerrotas(),
                    time.getSaldoGols());
        }
    }
}
