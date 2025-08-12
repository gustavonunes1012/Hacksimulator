package principal.hack;

import modelos.hack.Jogador;
import servicos.hack.GameEngine;

public class Main {
    public static void main(String[] args) {
        // Inicializa com jogador nulo
        GameEngine game = new GameEngine(null);
        // Exige cadastro e login antes de mostrar o menu
        game.telaInicial();
    }
}
