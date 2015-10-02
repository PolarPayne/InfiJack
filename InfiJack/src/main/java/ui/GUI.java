package ui;

import java.awt.Graphics;
import javax.swing.JFrame;
import logic.Board;
import logic.Game;
import logic.util.Directions;
import ui.listeners.KeyboardListener;

public class GUI extends JFrame {
    private final Game game;
    private final Board board;
    private final Camera camera;
    
    private final int width = 640;
    private final int height = 480;
    
    private final int scale = 16;
    private final int size = 32;
    
    public GUI(Game game) {
        this.game = game;
        this.board = game.getBoard();
        
        this.setTitle("InfiJack");
        this.setSize(this.width, this.height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setResizable(false);
        
        this.camera = new Camera(this.scale);
        
        this.addKeyListener(new KeyboardListener(this));
        
        this.setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
                
        drawBounds(g);
        drawMarks(g);
        drawSelector(g);
    }
    
    private void drawBounds(Graphics g) {
        int tlX = this.camera.worldToScreen(this.board.getBounds().getLeftTop()).getX() - size/2;
        int tlY = this.camera.worldToScreen(this.board.getBounds().getLeftTop()).getY() - size/2;
        int brX = this.camera.worldToScreen(this.board.getBounds().getRightBottom()).getX() + size/2;
        int brY = this.camera.worldToScreen(this.board.getBounds().getRightBottom()).getY() + size/2;
        int w = brX - tlX;
        int h = brY - tlY;
        
        g.drawRect(this.width/2 + tlX, this.height/2 + tlY, w, h);
    }
    
    private void drawMarks(Graphics g) {
        //TODO draw marks on the field
    }

    private void drawSelector(Graphics g) {
        //TODO draw the selector
    }

    public void setMark() {
        this.game.setMark(this.camera.getX(), this.camera.getY());
        if (this.game.over()) {
            //Display end game screen.
            throw new RuntimeException("game ended");
        }
    }

    public void moveCursor(Directions direction) {
        this.camera.move(direction);
    }
}
