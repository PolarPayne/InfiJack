package logic;

import logic.players.HumanPlayer;
import org.junit.Test;
import static org.junit.Assert.*;

public class MoveTest {

    @Test
    public void testNewMove() {
        Move instance = new Move(0, 0, new HumanPlayer('X'));
        assertEquals('X', instance.getMark());
        assertNotEquals('O', instance.getMark());
    }
    
    @Test
    public void testToString() {
        Move instance = new Move(0, 0, new HumanPlayer('X'));
        assertEquals("[x:0,y:0]:X", instance.toString());
    }
}
