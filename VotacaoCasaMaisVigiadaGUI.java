import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

public class VotacaoCasaMaisVigiadaGUI extends JFrame {
    private ArrayList<Jogador> jogadores;

    private JTextField txtNome;
    private JButton btnVotar;

    public VotacaoCasaMaisVigiadaGUI() {
        jogadores = cadastrarJogadores();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Votação Casa Mais Vigiada");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel lblNome = new JLabel("Nome do participante:");
        txtNome = new JTextField(20);
        btnVotar = new JButton("Votar");

        btnVotar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                votar();
            }
        });

        add(lblNome);
        add(txtNome);
        add(btnVotar);
    }

    private ArrayList<Jogador> cadastrarJogadores() {
        ArrayList<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador("Alane Dias"));
        jogadores.add(new Jogador("Beatriz Reis"));
        jogadores.add(new Jogador("Davi Brito"));
        jogadores.add(new Jogador("Deniziane Ferreira"));
        jogadores.add(new Jogador("Fernanda Bande"));
        jogadores.add(new Jogador("Giovanna Lima"));
        jogadores.add(new Jogador("Giovanna Pitel"));
        jogadores.add(new Jogador("Isabelle Nogueira"));
        jogadores.add(new Jogador("Juninho"));
        jogadores.add(new Jogador("Leidy Elin"));
        jogadores.add(new Jogador("Lucas Henrique"));
        jogadores.add(new Jogador("Lucas Luigi"));
        jogadores.add(new Jogador("Lucas Pizane"));
        jogadores.add(new Jogador("Marcus Vinicius"));
        jogadores.add(new Jogador("Matteus Amaral"));
        jogadores.add(new Jogador("Maycon Cosmer"));
        jogadores.add(new Jogador("MC Bin Laden"));
        jogadores.add(new Jogador("Michel Nogueira"));
        jogadores.add(new Jogador("Nizam"));
        jogadores.add(new Jogador("Raquele Cardozo"));
        jogadores.add(new Jogador("Rodriguinho"));
        jogadores.add(new Jogador("Thalyta Alves"));
        jogadores.add(new Jogador("Vanessa Lopes"));
        jogadores.add(new Jogador("Vinicius Rodrigues"));
        jogadores.add(new Jogador("Wanessa Camargo"));
        jogadores.add(new Jogador("Yasmin Brunet"));
        return jogadores;
    }

    private void votar() {
        String nome = txtNome.getText().trim();
        if (!nome.isEmpty()) {
            boolean encontrado = false;
            for (Jogador jogador : jogadores) {
                if (jogador.getNome().equalsIgnoreCase(nome)) {
                    jogador.incrementaUmVoto();
                    encontrado = true;
                    JOptionPane.showMessageDialog(this, "Eliminado", "Voto registrado para " + nome, JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(this, "Participante não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, insira o nome do participante.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        txtNome.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VotacaoCasaMaisVigiadaGUI().setVisible(true);
            }
        });
    }
}
