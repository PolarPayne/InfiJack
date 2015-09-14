package logic;

import java.util.HashSet;
import logic.util.Rectangle;
import logic.util.Point;

public class Board {

    private final HashSet<Point> marks;
    private final Rectangle bounds;
    private int padding;

    public Board(int padding) {
        this.marks = new HashSet<>();
        this.bounds = new Rectangle(0, 0, 0, 0);
        this.padding = padding;
    }

    public void add(Mark move) {
        if (this.bounds.contains(move)) {
            this.marks.add(move);
            this.bounds.resize(this.marks, this.padding);
        } else {
            throw new Error("Move must be inside the bounds.");
        }
    }

    int getPadding() {
        return this.padding;
    }

    void setPadding(int padding) {
        this.padding = padding;
    }

}
