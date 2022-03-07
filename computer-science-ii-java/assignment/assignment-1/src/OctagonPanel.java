package semester_two.week_two.assignment;

import javax.swing.*;
import java.awt.*;

public class OctagonPanel extends JPanel {

    private Octagon[] shapes;

    public OctagonPanel() {
        super();

        shapes = new Octagon[4];
        shapes[0] = new Octagon(100, 100, 100, 8, 8);
        shapes[1] = new Octagon(100, 100, 20, 8, 8);
        shapes[2] = new Octagon(400, 50, 75, 8, 8);
        shapes[3] = new Octagon(100, 100, 40, 8, 8);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLUE.darker());
        for (Octagon o : shapes) {
            g2.fill(o);
        }
    }

    public void move() {
        for (Octagon o : shapes) {
            o.translate(o.getDeltaX(), o.getDeltaY());

            if (o.getRightBound() > getWidth() || o.getLeftBound() < 0) {
                o.negateDeltaX();
            }

            if (o.getUpperBound() < 0 || o.getLowerBound() > getHeight()) {
                o.negateDeltaY();
            }
        }

        repaint();
    }
}