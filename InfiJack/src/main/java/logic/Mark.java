package logic;

import logic.util.Point;

public class Mark extends Point {

    private final char mark;

    public Mark(int x, int y, char mark) {
        super(x, y);
        this.mark = mark;
    }

}
