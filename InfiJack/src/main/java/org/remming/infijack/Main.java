package org.remming.infijack;

import logic.Game;
import logic.players.HumanPlayer;
import ui.CLI;
import ui.UI;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.addPlayer(new HumanPlayer('x'));
        game.addPlayer(new HumanPlayer('o'));
        
        UI cli = new CLI(game);
        cli.start();
    }
}
