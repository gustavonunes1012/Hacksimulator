
package servicos.hack;
import modelos.hack.Jogador;
import modelos.hack.Missao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameEngine {
    private Jogador jogador;
    private List<Missao> missoes;
    private Scanner scanner;

    public GameEngine(Jogador jogador) {
        this.jogador = jogador;
        this.missoes = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Bem-vindo ao HackEthic, " + jogador.getNome() + "!");
        carregarMissoes();
        mostrarMenu();
    }

    private void carregarMissoes() {
        System.out.println("Carregando missões...");
        modelos.hack.Alvo alvo1 = new modelos.hack.Alvo("Servidor Alpha", "192.168.1.10", 5);
        Missao m1 = new Missao("Invadir o Servidor Alpha e coletar dados sensíveis", alvo1, 3, 100, false);
        missoes.add(m1);
        System.out.println("Missões carregadas com sucesso!");
    }

    private void mostrarMenu() {
        while (true) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1 - Listar missões disponíveis");
            System.out.println("2 - Exibir status do jogador");
            System.out.println("3 - Descansar / Recuperar energia");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    listarMissoes();
                    break;
                case "2":
jogador.exibeStatus();                    
                    break;
                case "3":
                    descansar();
                    break;
                    case "4":
                    System.out.println("Saindo...");
                    return;
                
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void listarMissoes() {
        System.out.println("\n=== Missões Disponíveis ===");
        for (int i = 0; i < missoes.size(); i++) {
            Missao m = missoes.get(i);
            System.out.printf("%d - %s (Dificuldade: %d) - Status: %s\n", i + 1,
                    m.getDescricao(), m.getDificuldade(),
                    m.isMissaoCompleta() ? "COMPLETA" : "PENDENTE");
        }
        System.out.print("Escolha o número da missão para iniciar ou 0 para voltar: ");
        String escolha = scanner.nextLine();
        try {
            int opcao = Integer.parseInt(escolha);
            if (opcao == 0) {
                return;
            }
            if (opcao < 1 || opcao > missoes.size()) {
                System.out.println("Número inválido.");
                return;
            }
            Missao selecionada = missoes.get(opcao - 1);
            iniciarMissao(selecionada);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
        }
    }

    private void iniciarMissao(Missao missao) {
        if (missao.isMissaoCompleta()) {
            System.out.println("Essa missão já foi concluída.");
            return;
        }
        System.out.println("\nIniciando missão:");
        missao.exibeMissao();
        System.out.println("\nTentando atacar o alvo...");
        boolean sucesso = executarAtaque(missao);
        if (sucesso) {
            System.out.println("Parabéns! Missão concluída.");
            missao.setMissaoCompleta(true);
            atualizarJogador(missao);
        } else {
            System.out.println("Falha no ataque. Tente novamente.");
        }
    }

    private boolean executarAtaque(Missao missao) {
        int chanceSucesso = jogador.getNivel() * 10;
        int dificuldade = missao.getDificuldade() * 10;
        int resultado = (int) (Math.random() * 100);
        return resultado + chanceSucesso >= dificuldade;
    }

    private void atualizarJogador(Missao missao) {
        int xpGanho = missao.getRecompensaExp();
        jogador.setExp(jogador.getExp() + xpGanho);
        System.out.println("Você ganhou " + xpGanho + " de experiência!");
        while (jogador.getExp() >= 100) {
            jogador.setNivel(jogador.getNivel() + 1);
            jogador.setExp(jogador.getExp() - 100);
            System.out.println("Parabéns! Você subiu para o nível " + jogador.getNivel() + "!");
        }
    }
    private void descansar() {
    int energiaRecuperada = 30;
    int energiaAtual = jogador.getEnergia();
    int energiaMaxima = 100;

    jogador.setEnergia(Math.min(energiaAtual + energiaRecuperada, energiaMaxima));
    System.out.println("Você descansou e recuperou " + energiaRecuperada + " pontos de energia.");
    System.out.println("Energia atual: " + jogador.getEnergia());
}

}
