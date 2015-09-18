package logic.util;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

public class RectangleTest {

    @Test
    public void testPointInsideRectangleTrivialSinglePoint() {
        Rectangle instance = new Rectangle(0, 0, 0, 0);
        Point p = new Point(0, 0);
        assertTrue(instance.contains(p));
    }

    @Test
    public void testPointInsideRectangleNontrivialTwoPoints() {
        Rectangle instance = new Rectangle(-100, 100, 100, -100);
        Point p1 = new Point(-100, 100);
        Point p2 = new Point(100, -100);
        assertTrue(instance.contains(p1));
        assertTrue(instance.contains(p2));
    }

    @Test
    public void testPointNotInsideRectangleTrivialSinglePoint() {
        Rectangle instance = new Rectangle(0, 0, 0, 0);
        Point p = new Point(0, 1);
        assertFalse(instance.contains(p));
    }
    
    @Test
    public void testSomePointsInsideRectangle() {
        Rectangle instance = new Rectangle(0, 0, 0, 0);
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        assertTrue(instance.contains(p1));
        assertFalse(instance.contains(p2));
    }
    
    @Test
    public void testNoResize() {
        Rectangle instance = new Rectangle(0, 0, 0, 0);
        Set<Point> ps = new HashSet<>();
        ps.add(new Point(0, 0));
        instance.resize(ps, 0);
        assertEquals(new Point(0, 0), instance.getLeftTop());
        assertEquals(new Point(0, 0), instance.getRightBottom());
    }
    
    @Test
    public void testSimpleResize() {
        Rectangle instance = new Rectangle(0, 0, 0, 0);
        Set<Point> ps = new HashSet<>();
        ps.add(new Point(-1, 1));
        instance.resize(ps, 0);
        assertEquals(new Point(-1, 1), instance.getLeftTop());
        assertEquals(new Point(-1, 1), instance.getRightBottom());
    }
    
    @Test
    public void testSimpleResizeWithMultiplePoints() {
        Rectangle instance = new Rectangle(0, 0, 0, 0);
        Set<Point> ps = new HashSet<>();
        ps.add(new Point(-1, 1));
        ps.add(new Point(1, -1));
        instance.resize(ps, 0);
        assertEquals(new Point(-1, 1), instance.getLeftTop());
        assertEquals(new Point(1, -1), instance.getRightBottom());
    }
    
    @Test
    public void testSimpleResizeWithRoom() {
        Rectangle instance = new Rectangle(0, 0, 0, 0);
        Set<Point> ps = new HashSet<>();
        ps.add(new Point(0, 0));
        instance.resize(ps, 1);
        assertEquals(new Point(-1, 1), instance.getLeftTop());
        assertEquals(new Point(1, -1), instance.getRightBottom());
    }
    
    @Test
    public void testResizeWithRoom() {
        Rectangle instance = new Rectangle(0, 0, 0, 0);
        Set<Point> ps = new HashSet<>();
        ps.add(new Point(-1, 1));
        ps.add(new Point(1, -1));
        instance.resize(ps, 1);
        assertEquals(new Point(-2, 2), instance.getLeftTop());
        assertEquals(new Point(2, -2), instance.getRightBottom());
    }
    
    @Test
    public void testResizeWide() {
        Rectangle instance = new Rectangle(0, 0, 0, 0);
        Set<Point> ps = new HashSet<>();
        ps.add(new Point(-100, 0));
        ps.add(new Point(0, 0));
        ps.add(new Point(100, 0));
        instance.resize(ps, 0);
        assertEquals(new Point(-100, 0), instance.getLeftTop());
        assertEquals(new Point(100, 0), instance.getRightBottom());
    }
    
    @Test
    public void testResizeLarge() {
        Rectangle instance = new Rectangle(0, 0, 0, 0);
        Set<Point> ps = new HashSet<>();
        ps.add(new Point(-100, 0));
        ps.add(new Point(0, 0));
        ps.add(new Point(100, 0));
        ps.add(new Point(-100, 100));
        ps.add(new Point(100, -100));
        ps.add(new Point(42, -42));
        instance.resize(ps, 0);
        assertEquals(new Point(-100, 100), instance.getLeftTop());
        assertEquals(new Point(100, -100), instance.getRightBottom());
    }
    
    @Test
    public void testResizeWrongOfByPlusOne() {
        Rectangle instance = new Rectangle(0, 0, 0, 0);
        Set<Point> ps = new HashSet<>();
        ps.add(new Point(-100, 100));
        ps.add(new Point(0, 0));
        ps.add(new Point(100, -100));
        instance.resize(ps, 0);
        assertNotEquals(new Point(-101, 101), instance.getLeftTop());
        assertNotEquals(new Point(101, -101), instance.getRightBottom());
    }
    
    @Test
    public void testResizeWrongOfByMinusOne() {
        Rectangle instance = new Rectangle(0, 0, 0, 0);
        Set<Point> ps = new HashSet<>();
        ps.add(new Point(-100, 100));
        ps.add(new Point(0, 0));
        ps.add(new Point(100, -100));
        instance.resize(ps, 0);
        assertNotEquals(new Point(-99, 99), instance.getLeftTop());
        assertNotEquals(new Point(99, -99), instance.getRightBottom());
    }
    
    @Test(expected = Error.class)
    public void testResizeNegativePadding() {
        Rectangle instance = new Rectangle(0, 0, 0, 0);
        Set<Point> ps = new HashSet<>();
        ps.add(new Point(0, 0));
        instance.resize(ps, -1);
        assertEquals(new Point(0, 0), instance.getLeftTop());
        assertEquals(new Point(0, 0), instance.getRightBottom());
    }
}
