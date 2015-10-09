package logic.players;

import logic.Move;

public interface Player {

    public Move move(int x, int y);

    public char getMark();
}
