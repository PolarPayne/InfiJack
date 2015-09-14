package logic.players;

import logic.Board;
import logic.Mark;

public interface Player {

    public Mark move();

    public void setBoard(Board board);
}
