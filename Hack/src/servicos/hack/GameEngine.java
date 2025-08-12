
package servicos.hack;
import modelos.hack.Jogador;
import modelos.hack.Missao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameEngine {
    private Jogador jogador;
    private List<Missao> missoes;
    private List<Missao> historicoMissoes = new ArrayList<>();
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
    missoes.clear();
    missoes.add(new Missao("Invadir o Servidor Alpha e coletar dados sensíveis", new modelos.hack.Alvo("Servidor Alpha", "192.168.1.10", 5), 3, 100, false));
    missoes.add(new Missao("Hackear o Banco Central e transferir fundos", new modelos.hack.Alvo("Banco Central", "10.0.0.1", 8), 5, 250, false));
    missoes.add(new Missao("Obter acesso ao sistema de câmeras da cidade", new modelos.hack.Alvo("Central de Câmeras", "172.16.0.5", 4), 2, 80, false));
    missoes.add(new Missao("Desativar firewall de empresa concorrente", new modelos.hack.Alvo("Firewall CorpX", "192.168.2.20", 6), 4, 120, false));
    missoes.add(new Missao("Roubar dados de pesquisa de laboratório secreto", new modelos.hack.Alvo("Lab Secreto", "10.10.10.10", 7), 6, 300, false));
    missoes.add(new Missao("Interceptar comunicações de políticos", new modelos.hack.Alvo("Gabinete Político", "192.168.100.100", 5), 3, 110, false));
    missoes.add(new Missao("Invadir sistema de votação eletrônica", new modelos.hack.Alvo("Urna Eletrônica", "10.0.0.50", 9), 7, 400, false));
    missoes.add(new Missao("Obter acesso ao servidor de streaming", new modelos.hack.Alvo("Servidor Streaming", "172.16.1.1", 3), 2, 70, false));
    missoes.add(new Missao("Sabotar sistema de controle de energia", new modelos.hack.Alvo("Usina Elétrica", "192.168.3.33", 8), 6, 320, false));
    missoes.add(new Missao("Descobrir senha do CEO da MegaCorp", new modelos.hack.Alvo("MegaCorp CEO", "10.1.1.1", 4), 3, 90, false));
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
        boolean respostaCorreta = false;
        int dificuldade = missao.getDificuldade();
        if (dificuldade <= 3) {
            int a = 2 * dificuldade;
            int b = dificuldade + 3;
            System.out.println("Desafio fácil: Qual a soma de " + a + " + " + b + "?");
            String tentativa = scanner.nextLine();
            respostaCorreta = tentativa.equals(String.valueOf(a + b));
        } else if (dificuldade <= 6) {
            System.out.println("Desafio intermediário: Qual dessas opções é uma porta comum de SSH? (a) 21 (b) 22 (c) 80");
            String tentativa = scanner.nextLine();
            respostaCorreta = tentativa.trim().equalsIgnoreCase("b") || tentativa.trim().equals("22");
        } else {
            System.out.println("Desafio avançado: Complete a sequência: hack, h4ck, h4cK, ?");
            String tentativa = scanner.nextLine();
            respostaCorreta = tentativa.trim().equalsIgnoreCase("H4CK");
        }
        int energiaPerdida = 10 + dificuldade * 2;
        jogador.setEnergia(jogador.getEnergia() - energiaPerdida);
        System.out.println("Você perdeu " + energiaPerdida + " de energia ao tentar a missão.");
        if (jogador.getEnergia() <= 0) {
            System.out.println("Você ficou sem energia! Descanse para continuar jogando.");
            jogador.setEnergia(0);
            return;
        }
        boolean sucesso = respostaCorreta && executarAtaque(missao);
        if (sucesso) {
            System.out.println("Parabéns! Missão concluída.");
            missao.setMissaoCompleta(true);
            atualizarJogador(missao);
            historicoMissoes.add(missao);
        } else {
            System.out.println("Falha no ataque. Resposta incorreta ou você não teve sucesso no hack. Tente novamente.");
        }
    }

    private boolean executarAtaque(Missao missao) {
    int nivelJogador = jogador.getNivel();
    int dificuldade = missao.getDificuldade();
    double probabilidade = 0.5 + 0.05 * (nivelJogador - dificuldade);
    if (probabilidade < 0.1) probabilidade = 0.1;
    if (probabilidade > 0.95) probabilidade = 0.95;
    double resultado = Math.random();
    return resultado < probabilidade;
    }

    private void atualizarJogador(Missao missao) {
    int xpGanho = missao.getDificuldade() * 20;
        jogador.setExp(jogador.getExp() + xpGanho);
        System.out.println("Você ganhou " + xpGanho + " de experiência!");
        int nivelAtual = jogador.getNivel();
        int xpParaProximoNivel = 100 + (nivelAtual - 1) * 50;
        while (jogador.getExp() >= xpParaProximoNivel) {
            jogador.setNivel(jogador.getNivel() + 1);
            jogador.setExp(jogador.getExp() - xpParaProximoNivel);
            System.out.println("Parabéns! Você subiu para o nível " + jogador.getNivel() + "!");
            nivelAtual = jogador.getNivel();
            xpParaProximoNivel = 100 + (nivelAtual - 1) * 50;
        }
    }
    private void descansar() {
    int energiaRecuperada = 5;
    int energiaAtual = jogador.getEnergia();
    int energiaMaxima = 100;

    jogador.setEnergia(Math.min(energiaAtual + energiaRecuperada, energiaMaxima));
        System.out.println("Você descansou e recuperou 5 de energia.");
    System.out.println("Energia atual: " + jogador.getEnergia());
}

}
