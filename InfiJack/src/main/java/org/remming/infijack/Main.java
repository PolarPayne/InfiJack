package org.remming.infijack;

import logic.Game;
import ui.GUI;

public class Main {
    public static void main(String[] args) {
        new GUI(new Game(2));
    }
}
