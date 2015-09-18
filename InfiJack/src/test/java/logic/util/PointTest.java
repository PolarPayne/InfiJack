package logic.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void testTrivialX() {
        Point instance = new Point(0, 0);
        assertEquals(0, instance.getX());
    }

    @Test
    public void testTrivialY() {
        Point instance = new Point(0, 0);
        assertEquals(0, instance.getY());
    }

    @Test
    public void testSimpleX() {
        Point instance = new Point(1, 0);
        assertEquals(1, instance.getX());
    }

    @Test
    public void testSimpleY() {
        Point instance = new Point(0, 1);
        assertEquals(1, instance.getY());
    }
    
    @Test
    public void testEqualHashCode() {
        Point instance = new Point(100, -100);
        Point equal = new Point(100, -100);
        assertEquals(instance.hashCode(), equal.hashCode());
    }
    
    @Test
    public void testNonEqualHashCode() {
        Point instance = new Point(42, 0);
        Point notEqual = new Point(0, 13);
        assertNotEquals(instance.hashCode(), notEqual.hashCode());
    }
    
    @Test
    public void testSimpleEquals() {
        Point instance = new Point(0, 0);
        assertTrue(instance.equals(new Point(0, 0)));
    }
    
    @Test
    public void testSimpleNotEquals() {
        Point instance = new Point(0, 0);
        assertFalse(instance.equals(new Point(42, 13)));
    }
    
    @Test
    public void testSimpleXEquals() {
        Point instance = new Point(13, 0);
        assertFalse(instance.equals(new Point(13, 42)));
    }
    
    @Test
    public void testNotEqualToNull() {
        Point instance = new Point(0, 0);
        assertFalse(instance.equals(null));
    }

    @Test
    public void testNotEqualsToInt() {
        Point instance = new Point(0, 0);
        assertFalse(instance.equals(42));
    }
    
    @Test
    public void testToString() {
        Point instance = new Point(13, 42);
        assertEquals("x: 13, y: 42", instance.toString());
    }
}
