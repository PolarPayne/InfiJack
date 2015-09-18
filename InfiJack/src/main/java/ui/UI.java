package ui;

import logic.Move;
import logic.players.HumanPlayer;

public interface UI {
    void start();

    public Move getMove(HumanPlayer humanPlayer);
}
