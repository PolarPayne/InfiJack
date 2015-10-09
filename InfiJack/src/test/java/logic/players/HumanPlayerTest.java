package logic.players;

import logic.Move;
import org.junit.Test;
import static org.junit.Assert.*;

public class HumanPlayerTest {
    
    @Test
    public void testNewPlayer() {
        HumanPlayer instance = new HumanPlayer('X');
        assertEquals('X', instance.getMark());
        assertNotEquals('O', instance.getMark());
    }
    
    @Test
    public void testMove() {
        HumanPlayer instance = new HumanPlayer('X');
        assertEquals(new Move(0, 0, instance), instance.move(0, 0));
    }
}
