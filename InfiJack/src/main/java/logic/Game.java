package logic;

import java.util.ArrayList;
import java.util.Collections;
import logic.players.HumanPlayer;
import logic.players.Player;

public class Game {
    private final ArrayList<Player> players;
    private final Board board;
    
    public Game() {
        this.players = new ArrayList<>();
        this.board = new Board();
    }

    public void addPlayer(HumanPlayer humanPlayer) {
        this.players.add(humanPlayer);
    }
    
    private void randomizeTurnOrder() {
        Collections.shuffle(players);
    }

    public void start() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean over() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
