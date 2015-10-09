package ui;

import logic.util.Directions;
import logic.util.Point;

public class Camera {
    private int x;
    private int y;
    private final int scale;
    
    /**
     * Camera, with a center coordinate (x, y) that starts from origin and a scale.
     * @param scale Factor to scale all graphics.
     */
    public Camera(int scale) {
        this.x = 0;
        this.y = 0;
        this.scale = scale;
    }
    
    /**
     * Transformation from world coordinates to screen coordinates, with the defined scale.
     * @param p Point to be transformed.
     * @return Transformed point.
     */
    public Point worldToScreen(Point p) {
        return new Point(this.scale * (p.getX() - this.x), this.scale * (p.getY() - this.y));
    }
    
    public Point worldToScreen(int x, int y) {
        return this.worldToScreen(new Point(x, y));
    }
    
    /**
     * Moves the camera by one to the direction.
     * @param d A cardinal direction.
     */
    public void move(Directions d) {
        switch (d) {
            case UP:
                this.y--;
                break;
            case RIGHT:
                this.x++;
                break;
            case DOWN:
                this.y++;
                break;
            case LEFT:
                this.x--;
                break;
        }
    }
    
    public void setXY(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }

    /**
     * Return cameras coordinate as a point.
     * @return Point defining cameras coordinate.
     */
    public Point getPoint() {
        return new Point(this.x, this.y);
    }

}
