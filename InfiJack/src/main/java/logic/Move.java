package logic;

import logic.players.Player;
import logic.util.Point;

/**
 * A Point that has an owner.
 */
public class Move extends Point {

    private final Player player;

    /**
     * Move is a point that has an owner.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @param player The player whose move this is.
     */
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
