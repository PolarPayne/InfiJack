package logic;

import java.util.HashSet;
import java.util.Set;
import logic.util.Point;
import logic.util.Rectangle;

public class Board {

    private final Set<Point> moves;
    private final Rectangle bounds;
    private int padding;

    public Board(int padding) {
        this.moves = new HashSet<>();
        this.bounds = new Rectangle(0, 0, 0, 0);
        this.padding = padding;
    }

    public void add(Move move) {
        if (this.bounds.contains(move) && !this.moves.contains(move)) {
            this.moves.add(move);
            this.bounds.resize(this.moves, this.padding);
        } else {
            throw new Error("Move must be unique, and inside the bounds.");
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
                .append(this.bounds.getRightBottom().toString()).append("\n");
        for (Point i : moves) {
            sb.append(i).append("\n");
        }
        return sb.toString();
    }

}
