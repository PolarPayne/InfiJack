package logic.players;

import logic.Move;

public interface Player {

    /**
     * Returns a new move that is owned by this player.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @return A move at (x, y) owned by this player.
     */
    public Move move(int x, int y);

    public char getMark();
}
