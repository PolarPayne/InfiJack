package org.remming.infijack;

import logic.Game;
import ui.GUI;

public class Main {
    public static void main(String[] args) {
        int players = 4;
        int padding = 1;
        
        if (args.length >= 1) {
            players = Integer.parseInt(args[0]);
        } else if (args.length >= 2) {
            padding = Integer.parseInt(args[1]);
        }
        new GUI(new Game(players, padding));
    }
}
