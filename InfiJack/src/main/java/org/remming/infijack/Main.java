package org.remming.infijack;

import logic.Game;
import ui.GUI;

public class Main {
    public static void main(String[] args) {
        if (args.length > 2) {
            printHelp();
            return;
        }
        
        int players = 2;
        int padding = 1;
        try {
            if (args.length >= 1) {
                players = Integer.parseInt(args[0]);
                if (players < 2) {
                    players = 2;
                }
            }
            if (args.length >= 2) {
                padding = Integer.parseInt(args[1]);
                if (padding < 1) {
                    padding = 1;
                }
            }
        } catch (Exception e) {
            printHelp();
            return;
        }
        new GUI(new Game(players, padding));
    }
    
    public static void printHelp() {
        System.out.println("Usage: java -jar InfiJack.jar [players(2-4)] [padding(>0)]");
    }
}
