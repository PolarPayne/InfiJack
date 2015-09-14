package logic.players;

import logic.Board;
import logic.Mark;

public class HumanPlayer implements Player {
    private final char mark;
    private final Board board;

    public HumanPlayer(char mark) {
        this.mark = mark;
        this.board = null;
    }

    @Override
    public Mark move() {
        if (this.board == null)
            throw new Error("Board must be set before calling move()");
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setBoard(Board board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
