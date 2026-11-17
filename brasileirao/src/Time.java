public class Time {

    private String nome;
    private int pontos;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int golsMarcados;
    private int golsSofridos;

    public Time(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.vitorias = 0;
        this.empates = 0;
        this.derrotas = 0;
        this.golsMarcados = 0;
        this.golsSofridos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int getEmpates() {
        return empates;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getGolsMarcados() {
        return golsMarcados;
    }

    public int getGolsSofridos() {
        return golsSofridos;
    }

    public int getSaldoGols() {
        return golsMarcados - golsSofridos;
    }

    public void registrarVitoria() {
        pontos += 3;
        vitorias++;
    }

    public void registrarEmpate() {
        pontos++;
        empates++;
    }

    public void registrarDerrota() {
        derrotas++;
    }

    public void adicionarGols(int marcados, int sofridos) {
        golsMarcados += marcados;
        golsSofridos += sofridos;
    }

    public void exibirDados() {
        System.out.println("Time: " + nome);
        System.out.println("Pontos: " + pontos);
        System.out.println("Vitorias: " + vitorias);
        System.out.println("Empates: " + empates);
        System.out.println("Derrotas: " + derrotas);
        System.out.println("Gols marcados: " + golsMarcados);
        System.out.println("Gols sofridos: " + golsSofridos);
        System.out.println("-----------------------------");
    }
}
