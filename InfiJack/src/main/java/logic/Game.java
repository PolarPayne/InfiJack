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
        this.board = new Board(1);
    }

    public void addPlayer(HumanPlayer humanPlayer) {
        humanPlayer.setBoard(this.board);
        this.players.add(humanPlayer);
        
        this.board.setPadding(this.board.getPadding() + 1);
    }
    
    private void randomizeTurnOrder() {
        Collections.shuffle(players);
    }

    public void start() {
        while (true) {
            for (Player p : this.players) {
                this.board.add(p.move());
                if (this.over()) return;
            }
        }
    }

    public boolean over() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
