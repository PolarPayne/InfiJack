package logic;

import logic.players.Player;
import logic.util.Point;

public class Move extends Point {

    private final Player player;

    public Move(int x, int y, Player player) {
        super(x, y);
        this.player = player;
    }

    public char getMark() {
        return this.player.getMark();
    }

    @Override
    public String toString() {
        return "[x:" + this.getX() + ",y:" + this.getY() + "]:" + this.getMark();
    }

}
