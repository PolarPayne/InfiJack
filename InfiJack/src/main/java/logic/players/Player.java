package logic.players;

import logic.Move;

/**
 * Interface for all players, AIs should also extend this.
 */
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
