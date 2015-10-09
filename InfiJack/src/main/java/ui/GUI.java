package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import logic.Board;
import logic.Game;
import logic.Move;
import logic.util.Directions;
import logic.util.Point;
import logic.util.Rectangle;
import ui.listeners.KeyboardListener;

public class GUI extends JFrame {

    private final Game game;
    private final Board board;
    private final Camera camera;

    private final int width = 640;
    private final int height = 640;

    private final int scale = 32;
    private final int size = scale;

    /**
     * The base game object that starts the GUI.
     * 
     * @param game The game object to be created.
     */
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
        Rectangle b = this.board.getBounds();
        Point lt = this.camera.worldToScreen(b.getLeftTop());
        Point rb = this.camera.worldToScreen(b.getRightBottom());

        int ltX = lt.getX() - size / 2;
        int ltY = lt.getY() - size / 2;
        int rbX = rb.getX() + size / 2;
        int rbY = rb.getY() + size / 2;

        int w = rbX - ltX;
        int h = rbY - ltY;

        g.drawRect(this.width / 2 + ltX, this.height / 2 + ltY, w, h);
    }

    private void drawMarks(Graphics g) {
        for (Point p : this.board.getMoves()) {
            Move m = (Move) p;
            Point pp = this.camera.worldToScreen(m);
            int x = pp.getX() - size/2 + 2;
            int y = pp.getY() - size/2 + 2;
            
            g.setColor(Game.markToColor(m.getMark()));
            switch (m.getMark()) {
                case 'X':
                    g.fillRect(this.width/2 + x, this.height/2 + y, size-4, size-4);
                    g.setColor(Color.BLACK);
                    g.drawRect(this.width/2 + x, this.height/2 + y, size-4, size-4);
                    break;
                case 'O':
                    g.fillOval(this.width/2 + x, this.height/2 + y, size-4, size-4);
                    g.setColor(Color.BLACK);
                    g.drawOval(this.width/2 + x, this.height/2 + y, size-4, size-4);
                    break;
            }
        }
    }

    private void drawSelector(Graphics g) {
        Point p = this.camera.worldToScreen(this.camera.getX(), this.camera.getY());
        int s = size / 2;
        int tlX = p.getX() - s;
        int tlY = p.getY() - s;
        
        
        g.setColor(Game.markToColor(this.game.nextPlayer().getMark()));
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g.drawOval(this.width / 2 + tlX - 4, this.height / 2 + tlY - 4, size + 8, size + 8);
    }

    /**
     *  Sets a mark as the current player to the coordinate defined by camera.
     */
    public void setMark() {
        this.game.setMark(this.camera.getX(), this.camera.getY());
        if (this.game.over()) {
            //Display end game screen.
            throw new RuntimeException("game ended");
        }
    }

    /**
     *  Move the camera (aka the cursor) to the direction by one. 
     * @param direction A cardinal direction.
     */
    public void moveCursor(Directions direction) {
        Point p = this.camera.getPoint().moved(direction);
        if (this.board.getBounds().contains(p)) {
            this.camera.setXY(p);
        }
    }
}
