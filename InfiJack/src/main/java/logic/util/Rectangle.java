package logic.util;

import java.util.Set;

/**
 * Rectangle that is defined by its top left and bottom right corners.
 * Can be resized to fit a set of points.
 */
public class Rectangle {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    /**
     * Rectangle in 2d space.
     * @param x1 Top left x.
     * @param y1 Top left y.
     * @param x2 Bottom right x.
     * @param y2 Bottom right y.
     */
    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * Check if point is inside a rectangle.
     * @param p Point to be checked.
     * @return True if the point is inside this rectangle, otherwise false.
     */
    public boolean contains(Point p) {
        if (p.getX() >= this.x1 && p.getX() <= this.x2) {
            if (p.getY() >= this.y1 && p.getY() <= this.y2) {
                return true;
            }
        }
        return false;
    }

    /**
     * Resizes the rectangle to contain all points contained in set, with
     * padding. If set is null or empty, nothing is done (empty set is a subset
     * of every other set).
     *
     * @param points A set of all points
     * @param padding Amount of room around points, must be non-negative
     */
    public void resize(Set<Point> points, int padding) {
        if (points == null) {
            return;
        }
        if (points.isEmpty()) {
            return;
        }
        if (padding < 0) {
            throw new Error("padding must be non-negative");
        }

        int maxX = 0, maxY = 0, minX = 0, minY = 0;

        //A hack to get an arbitary element from a set to initialize values
        for (Point p : points) {
            maxX = p.getX();
            maxY = p.getY();
            minX = p.getX();
            minY = p.getY();
            break;
        }

        for (Point p : points) {
            if (p.getX() >= maxX) {
                maxX = p.getX();
            }
            if (p.getY() >= maxY) {
                maxY = p.getY();
            }
            if (p.getX() <= minX) {
                minX = p.getX();
            }
            if (p.getY() <= minY) {
                minY = p.getY();
            }
        }

        this.x1 = minX - padding;
        this.y1 = minY - padding;
        this.x2 = maxX + padding;
        this.y2 = maxY + padding;
    }

    /**
     *
     * @return Top left as a point.
     */
    public Point getLeftTop() {
        return new Point(this.x1, this.y1);
    }

    /**
     *
     * @return Bottom right as a point.
     */
    public Point getRightBottom() {
        return new Point(this.x2, this.y2);
    }
    
    public int getWidth() {
        return this.x2 - this.x1 + 1;
    }
    
    public int getHeight() {
        return this.y2 - this.y1 + 1;
    }
}
