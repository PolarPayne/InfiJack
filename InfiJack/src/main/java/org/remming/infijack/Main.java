package org.remming.infijack;

import logic.Game;
import ui.CLI;
import ui.UI;

public class Main {
    public static void main(String[] args) {
        UI cli = new CLI(new Game(2));
        cli.start();
    }
}
