package principal.hack;

import modelos.hack.Jogador;
import servicos.hack.GameEngine;

public class Main {
    public static void main(String[] args) {
        Jogador jogador = new Jogador("Gustavo");
        GameEngine game = new GameEngine(jogador);
        game.startGame();
    }
}
