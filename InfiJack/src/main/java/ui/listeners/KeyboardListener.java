package ui.listeners;

import logic.util.Directions;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import ui.GUI;

public class KeyboardListener implements KeyListener {
    
    private final GUI ui;

    /**
     * A basic keyboard listener that checks for arrows and wasd input.
     * @param ui The ui that needs to be controlled.
     */
    public KeyboardListener(GUI ui) {
        this.ui = ui;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();

        if (k == KeyEvent.VK_SPACE) {
            ui.setMark();
        } else {
            if (k == KeyEvent.VK_W || k == KeyEvent.VK_UP) {
                ui.moveCursor(Directions.UP);
            }
            if (k == KeyEvent.VK_D || k == KeyEvent.VK_RIGHT) {
                ui.moveCursor(Directions.RIGHT);
            }
            if (k == KeyEvent.VK_S || k == KeyEvent.VK_DOWN) {
                ui.moveCursor(Directions.DOWN);
            }
            if (k == KeyEvent.VK_A || k == KeyEvent.VK_LEFT) {
                ui.moveCursor(Directions.LEFT);
            }
        }
        ui.repaint();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
