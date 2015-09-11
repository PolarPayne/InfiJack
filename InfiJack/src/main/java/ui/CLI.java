package ui;

import logic.Game;

public class CLI implements UI{
    private final Game game;
    
    public CLI(Game game) {
        this.game = game;
    }

    @Override
    public void start() {
        while (!game.over()) {
            //TODO cli logic
        }
    }

}
