package logic.players;

import logic.Move;
import ui.UI;

public class HumanPlayer implements Player {
    private final char mark;
    

    public HumanPlayer(char mark) {
        this.mark = mark;
    }

    @Override
    public Move move(UI ui) {
        return ui.getMove(this);
    }

    @Override
    public char getMark() {
        return this.mark;
    }
}
