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

    public boolean over() {
        return false; //TODO implement game over checking
    }
    
    @Override
    public String toString() {
        return this.board.toString();
    }
    
    public Player nextPlayer() {
        return this.players.peekFirst();
    }

    public void setMark(int x, int y) {
        this.board.add(this.players.getFirst().move(x, y));
        this.players.addLast(this.players.removeFirst());
    }

    public Board getBoard() {
        return this.board;
    }
    
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
