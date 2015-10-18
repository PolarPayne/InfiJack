package logic;

import java.util.HashSet;
import java.util.Set;
import logic.util.Point;
import logic.util.Rectangle;

public class Board {

    private final Set<Point> moves;
    private final Rectangle bounds;
    private int padding;

    /**
     * Create a new "infinite" board with a padding.
     *
     * @param padding Defines the area around the outer moves, must be
     * non-negative.
     */
    public Board(int padding) {
        this.moves = new HashSet<>();
        this.bounds = new Rectangle(0, 0, 0, 0);
        this.padding = padding;
    }

    /**
     * Adds the move to the board, checking that it can actually be added there.
     *
     * @param move Move to be added.
     * @throws java.lang.Exception If the move is not valid.
     */
    public void add(Move move) throws Exception {
        if (this.bounds.contains(move) && !this.moves.contains(move)) {
            this.moves.add(move);
            this.bounds.resize(this.moves, this.padding);
        } else {
            throw new Exception("Move must be unique, and inside the bounds.");
        }
    }

    public int getPadding() {
        return this.padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }

    @Override
    public String toString() {
        //TODO print a pretty rectangular field
        StringBuilder sb = new StringBuilder();
        sb.append("bounds:\n\t")
                .append(this.bounds.getLeftTop().toString()).append("\n\t")
                .append(this.bounds.getRightBottom().toString());

        if (!this.moves.isEmpty()) {
            sb.append("\n").append("moves:");
        }
        for (Point i : this.moves) {
            sb.append("\n\t").append(i);
        }
        return sb.toString();
    }

    public Set<Point> getMoves() {
        return this.moves;
    }

    public Rectangle getBounds() {
        return this.bounds;
    }
}
