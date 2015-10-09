package logic;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import logic.players.HumanPlayer;
import logic.players.Player;

public class Game {

    private final Deque<Player> players;
    private final Board board;
    private static final char[] marks = {'X', 'O'};

    /**
     * Handles the game logic.
     * 
     * @param players Amount of players.
     */
    public Game(int players) {
        this.board = new Board(1);
        
        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < players; i++) {
            playerList.add(new HumanPlayer(Game.marks[i]));
            this.board.setPadding(this.board.getPadding() + 1);
        }
        //Deque cannot be shuffled
        Collections.shuffle(playerList);
        
        this.players = new ArrayDeque<>(playerList);
    }

    /**
     * Checks whether the game has ended or not. 
     * @return true if the game is over, otherwise false
     */
    public boolean over() {
        return false; //TODO implement game over checking
    }
    
    @Override
    public String toString() {
        return this.board.toString();
    }
    
    /**
     * Peek who is gonna play next.
     * @return Player who plays next.
     */
    public Player nextPlayer() {
        return this.players.peekFirst();
    }

    /**
     * Places a mark on the (x, y) coordinate.
     * @param x
     * @param y
     */
    public void setMark(int x, int y) {
        this.board.add(this.players.getFirst().move(x, y));
        this.players.addLast(this.players.removeFirst());
    }
    
    public Board getBoard() {
        return this.board;
    }
    
    /**
     * Translate a players mark into a color.
     * @param c Mark of the player.
     * @return Color of the player, null otherwise.
     */
    public static Color markToColor(char c) {
        switch (c) {
            case 'X':
                return Color.RED;
            case 'O':
                return Color.BLUE;
        }
        return null;
    }

}
