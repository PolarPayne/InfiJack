package logic.util;

public class Point {

    private final int x;
    private final int y;

    /**
     * Immutable point in 2D space.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.x;
        hash = 67 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Point other = (Point) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "x: " + this.x + ", y: " + this.y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    /**
     * Returns a new point that is next to this, in the defined direction.
     * @param direction Direction to move to.
     * @return A moved point.
     */
    public Point moved(Directions direction) {
        switch (direction) {
            case UP:
                return new Point(this.x, this.y-1);
            case RIGHT:
                return new Point(this.x+1, this.y);
            case DOWN:
                return new Point(this.x, this.y+1);
            case LEFT:
                return new Point(this.x-1, this.y);
            default:
                return null;
        }
    }
}
