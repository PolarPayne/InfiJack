package ui;

import logic.util.Directions;
import logic.util.Point;
import org.junit.Test;
import static org.junit.Assert.*;

public class CameraTest {
    
    @Test
    public void testNewCamera() {
        Camera instance = new Camera(1);
        assertEquals(0, instance.getX());
        assertEquals(0, instance.getY());
    }
    
    @Test
    public void testSetXY() {
        Camera instance = new Camera(1);
        instance.setXY(new Point(13, 42));
        assertEquals(13, instance.getX());
        assertEquals(42, instance.getY());
    }
    
    @Test
    public void testMove() {
        Camera instance = new Camera(1);
        
        instance.move(Directions.UP);
        assertEquals(0, instance.getX());
        assertEquals(-1, instance.getY());
        
        instance.move(Directions.RIGHT);
        assertEquals(1, instance.getX());
        assertEquals(-1, instance.getY());
        
        instance.move(Directions.DOWN);
        assertEquals(1, instance.getX());
        assertEquals(0, instance.getY());
        
        instance.move(Directions.LEFT);
        assertEquals(0, instance.getX());
        assertEquals(0, instance.getY());
    }
    
    @Test
    public void testGetPoint() {
        Camera instance = new Camera(1);
        assertEquals(new Point(0, 0), instance.getPoint());
    }
    
    @Test
    public void testZeroScale() {
        Camera instance = new Camera(0);
        assertEquals(new Point(0, 0), instance.worldToScreen(42, 13));
    }
    
    @Test
    public void testTransformNoMove() {
        Camera instance = new Camera(1);
        assertEquals(new Point(100, 100), instance.worldToScreen(100, 100));
        assertEquals(new Point(-100, 100), instance.worldToScreen(-100, 100));
        assertEquals(new Point(100, -100), instance.worldToScreen(100, -100));
        assertEquals(new Point(-100, -100), instance.worldToScreen(-100, -100));
    }
    
    @Test
    public void testTransformMove() {
        Camera instance = new Camera(1);
        instance.setXY(new Point(100, 100));
        assertEquals(new Point(0, 0), instance.worldToScreen(100, 100));
        assertEquals(new Point(-200, 0), instance.worldToScreen(-100, 100));
        assertEquals(new Point(0, -200), instance.worldToScreen(100, -100));
        assertEquals(new Point(-200, -200), instance.worldToScreen(-100, -100));
    }
    
    @Test
    public void testTransformWithScale() {
        Camera instance = new Camera(2);
        assertEquals(new Point(2, 2), instance.worldToScreen(1, 1));
        assertEquals(new Point(-2, 2), instance.worldToScreen(-1, 1));
        assertEquals(new Point(2, -2), instance.worldToScreen(1, -1));
        assertEquals(new Point(-2, -2), instance.worldToScreen(-1, -1));
    }
    
    @Test
    public void testTransformWithScaleAndMove() {
        Camera instance = new Camera(2);
        instance.setXY(new Point(1, 1));
        assertEquals(new Point(0, 0), instance.worldToScreen(1, 1));
        assertEquals(new Point(-4, 0), instance.worldToScreen(-1, 1));
        assertEquals(new Point(0, -4), instance.worldToScreen(1, -1));
        assertEquals(new Point(-4, -4), instance.worldToScreen(-1, -1));
    }
}
