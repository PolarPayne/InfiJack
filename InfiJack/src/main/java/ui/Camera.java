package ui;

import logic.util.Directions;
import logic.util.Point;

public class Camera {
    private int x;
    private int y;
    private final int scale;
    
    public Camera(int scale) {
        this.x = 0;
        this.y = 0;
        this.scale = scale;
    }
    
    public Point worldToScreen(Point p) {
        return new Point(this.scale * (p.getX() - this.x), this.scale * (p.getY() - this.y));
    }
    
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
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }

}
