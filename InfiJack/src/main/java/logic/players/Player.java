package logic.players;

import logic.Move;
import ui.GUI;

public interface Player {

    public Move move(int x, int y);

    public char getMark();
}
