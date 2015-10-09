package logic.players;

import logic.Move;

public class HumanPlayer implements Player {
    private final char mark;
    
    /**
     * Defines a player, each player also has a mark.
     * @param mark A unique mark for a player.
     */
    public HumanPlayer(char mark) {
        this.mark = mark;
    }

    @Override
    public char getMark() {
        return this.mark;
    }

    @Override
    public Move move(int x, int y) {
        return new Move(x, y, this);
    }
}
