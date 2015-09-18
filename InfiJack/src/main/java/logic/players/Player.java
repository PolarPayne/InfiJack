package logic.players;

import logic.Move;
import ui.UI;

public interface Player {

    public Move move(UI ui);

    public char getMark();
}
