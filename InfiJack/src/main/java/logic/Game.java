package logic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import logic.players.HumanPlayer;
import logic.players.Player;
import ui.UI;

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

    public boolean turn(UI ui) {        
        this.board.add(this.players.getFirst().move(ui));
        this.players.addLast(this.players.removeFirst());
        return this.over();
    }

    public boolean over() {
        return false; //TODO implement game over checking
    }
    
    @Override
    public String toString() {
        return this.board.toString();
    }

}
