import java.util.ArrayList;
import java.util.Scanner;

class Jogador {
    private String nome;
    private int votos;

    public Jogador(String nome) {
        this.nome = nome;
        this.votos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVotos() {
        return votos;
    }

    public void incrementaUmVoto() {
        this.votos = getVotos() + 1;
    }
}

public class VotacaoCasaMaisVigiada {

    public static void main(String[] args) {
        ArrayList<Jogador> jogadores = cadastrarJogadores();

        votacao(jogadores);

        apuracaoFinal(jogadores);

    }

    public static ArrayList<Jogador> cadastrarJogadores() {
        ArrayList<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador("Alane Dias"));
        jogadores.add(new Jogador("Beatriz Reis"));
        jogadores.add(new Jogador("Davi Brito")):
        jogadores.add(new Jogador("Deniziane Ferreira"));
        jogadores.add(new Jogador("Fernanda Bande"));
        jogadores.add(new Jogador("Giovana Lima"));
        jogadores.add(new Jogador("Giovana Pitel"));
        jogadores.add(new Jogador("Isabelle Nogueira"));
        jogadores.add(new Jogador("Juninho"));
        jogadores.add(new Jogador("Leidy Elin"));
        jogadores.add(new Jogador("Lucas Henrique"));
        jogadores.add(new Jogador("Lucas Luigi"));
        jogadores.add(new Jogador("Lucas Pizane"));
        jogadores.add(new Jogador("Marcus Vinicius"));
        jogadores.add(new Jogador("Mateus Amaral"));
        jogadores.add(new Jogador("Maycon Cosmer"));
        jogadores.add(new Jogador("MC Bin Laden"));
        jogadores.add(new Jogador("Michel Nogueira"));
        jogadores.add(new Jogador("Nizam"));
        jogadores.add(new Jogador("Raquele Cardozo"));
        jogadores.add(new Jogador("Rodriguinho"));
        jogadores.add(new Jogador("Thalita Alves"));
        jogadores.add(new Jogador("Vanessa Lopes"));
        jogadores.add(new Jogador("Vinicius Rodrigues"));
        jogadores.add(new Jogador("Wanessa Camargo"));
        jogadores.add(new Jogador("Yasmin Brunet"));
        return jogadores;
    }

    public static void votacao(ArrayList<Jogador> jogadores) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("A votação foi iniciada. Quem você quer eliminar? ou 'sair' para encerrar:");
        String voto = scanner.nextLine();

        while (!voto.equalsIgnoreCase("sair")) {
            boolean encontrado = false;
            for (Jogador jogador : jogadores) {
                if (jogador.getNome().equalsIgnoreCase(voto)) {
                    jogador.incrementaUmVoto();
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Não encontramos o participante. Por favor, digite o nome novamente ou 'sair' para encerrar:");
            } else {
                break;
            }
            voto = scanner.nextLine();
        }
        scanner.close();
    }

    public static void apuracaoFinal(ArrayList<Jogador> jogadores) {
        Jogador eliminado = jogadores.get(0);

        for (Jogador jogador : jogadores) {
            if (jogador.getVotos() > eliminado.getVotos()) {
                eliminado = jogador;
            }
        }

        System.out.println("Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu conseguir dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu vou conseguir te eliminar com alegria. Com " + eliminado.getVotos() + " votos, é você quem sai " + eliminado.getNome());
    }
}
