package logic.players;

import logic.Board;
import logic.util.Point;

public class HumanPlayer implements Player {
    private final char mark;
    private Board board;

    public HumanPlayer(char mark) {
        this.mark = mark;
    }

    @Override
    public Point move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setBoard(Board board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
