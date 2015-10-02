package ui;

import java.awt.Graphics;
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
    private final int height = 480;

    private final int scale = 32;
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
            int x = pp.getX() - size/2;
            int y = pp.getY() - size/2;
            
            switch (m.getMark()) {
                case 'X':
                    g.drawRect(this.width/2 + x, this.height/2 + y, size, size);
                    break;
                case 'O':
                    g.drawOval(this.width/2 + x, this.height/2 + y, size, size);
                    break;
            }
        }
    }

    private void drawSelector(Graphics g) {
        Point p = this.camera.worldToScreen(this.camera.getX(), this.camera.getY());
        int s = size / 2;
        int tlX = p.getX() - s;
        int tlY = p.getY() - s;

        g.drawOval(this.width / 2 + tlX - 4, this.height / 2 + tlY - 4, size + 8, size + 8);
    }

    public void setMark() {
        this.game.setMark(this.camera.getX(), this.camera.getY());
        if (this.game.over()) {
            //Display end game screen.
            throw new RuntimeException("game ended");
        }
    }

    public void moveCursor(Directions direction) {
        Point p = this.camera.getPoint().moved(direction);
        if (this.board.getBounds().contains(p)) {
            this.camera.setXY(p);
        }
    }
}
