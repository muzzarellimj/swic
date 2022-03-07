package semester_two.week_five;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {

    // a controlled by a timer
    // b controlled by the keyboard
    // c controlled by the mouse click
    private final Rectangle a, b, c;

    public Display() {
        super();

        setBackground(Color.ORANGE);

        a = new Rectangle(50, 50, 100, 100);
        b = new Rectangle(620, 50, 100, 100);
        c = new Rectangle(50, 420, 100, 100);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw the rectangles
        g.setColor(Color.BLUE);
        g.fillRect(a.x, a.y, a.width, a.height);

        g.setColor(Color.GREEN);
        g.fillRect(b.x, b.y, b.width, b.height);

        g.setColor(Color.MAGENTA);
        g.fillRect(c.x, c.y, c.width, c.height);
    }

    public void update() {
        a.x += 3;
        a.y += 3;

        repaint();
    }

    public void changeLoc(int deltaX, int deltaY) {
        b.x += deltaX;
        b.y += deltaY;

        repaint();
    }

    public void updateBasket(Point p) {
        c.x = (int) p.getX();
        c.y = (int) p.getY();

        repaint();
    }

    public void updateBasketPosition(int x) {
        c.x = x - c.width / 2;

        repaint();
    }

    public int getUpperBound() {
        return c.y;
    }

    public int getLowerBound() {
        return c.y + c.height;
    }
}