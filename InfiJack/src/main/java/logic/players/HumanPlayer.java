package logic.players;

import logic.Move;
import ui.GUI;

public class HumanPlayer implements Player {
    private final char mark;
    

    public HumanPlayer(char mark) {
        this.mark = mark;
    }

    @Override
    public char getMark() {
        return this.mark;
    }

    @Override
    public Move move(int x, int y) {
        return new Move(x, y, this);
    }
}
