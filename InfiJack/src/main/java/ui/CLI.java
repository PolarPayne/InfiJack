package ui;

import java.util.Scanner;
import logic.Game;
import logic.Move;
import logic.players.HumanPlayer;

public class CLI implements UI{
    private final Game game;
    private Scanner scanner;
    
    public CLI(Game game) {
        this.game = game;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void start() {
        while (!this.game.turn(this));
    }

    @Override
    public Move getMove(HumanPlayer player) {
        System.out.println(this.game);
        System.out.print("x: ");
        int x = this.scanner.nextInt();
        System.out.print("y: ");
        int y = this.scanner.nextInt();
        return new Move(x, y, player);
    }

}
