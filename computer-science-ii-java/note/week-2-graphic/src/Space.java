package semester_two.week_two.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Space extends JPanel {

    private final Color BROWN = new Color(150, 75, 0);
    private static Random random;
    private ArrayList<StopSign> signs;
    private Picture pic;
    private int dX, dY;

    public Space() {
        super();

        setBackground(Color.MAGENTA);
        random = new Random();
//        signs = new StopSign[4];
//        signs[0] = new StopSign(100, 100, 100);
//        signs[1] = new StopSign(750, 350, 20);
//        signs[2] = new StopSign(400, 50, 75);
//        signs[3] = new StopSign(0, 500, 40);

        signs = new ArrayList<>();
        signs.add(new StopSign(100, 100, 100));
        signs.add(new StopSign(750, 350, 20));
        signs.add(new StopSign(400, 50, 75));
        signs.add(new StopSign(0, 500, 40));

        dX = 8;
        dY = 6;

        // create the picture
        pic = new Picture(50, 50, 120, 60, "src/main/resources/sword.png");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.YELLOW);
        g2.fillOval(200, 200, 50, 50);

        g2.setColor(BROWN);
        g2.drawOval(200, 200, 50, 50);

        g2.setColor(Color.BLUE.brighter());
        g2.fillOval(400, 400, 50, 50);

        g2.setColor(BROWN);
        g2.drawOval(400, 400, 50, 50);

        g2.setColor(Color.CYAN);
        g2.drawRect(600, 100, 90, 90);
        g2.drawRect(600, 250, 140, 70);

        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Calibri", Font.PLAIN, 35));
        g2.drawString("First Graphics Program", 20, 40);

        g2.setColor(Color.RED);
        int[] x = new int[4];
        int[] y = new int[4];

        for (int i = 0; i < 4; i++) {
            x[i] = random.nextInt(600);
            y[i] = random.nextInt(400);
        }

        g2.drawPolygon(x, y, 4);

        g.setColor(Color.WHITE);
        int[] ssx = {150, 270, 355, 355, 270, 150, 65, 65};
        int[] ssy = {50, 50, 135, 255, 340, 340, 255, 135};
        g.fillPolygon(ssx, ssy, 8);

        // draw the array of stop signs
        g2.setColor(Color.BLUE.darker());
        for (StopSign s : signs) {
            g2.fill(s);
        }

        // draw the picture
        g2.rotate(pic.getTheta(), pic.getCenterX(), pic.getCenterY());
        g2.drawImage(pic.getImage(), pic.x, pic.y, pic.width, pic.height, null);
        g2.rotate(-pic.getTheta(), pic.getCenterX(), pic.getCenterY());
    }

    // move only the stop signs
    // move dx dy into the stop sign
    // translate each stop sign
    //
    public boolean moveObjects() {
        for (StopSign ss : signs) {
            ss.translate(ss.getdx(), ss.getdy());

            if(ss.getLeftBound() < 0 || ss.getRightBound() > getWidth())
                ss.changeHoriztonalLDirection();
            if(ss.getUpperBound() < 0 || ss.getLowerBound() > getHeight())
                ss.changeVerticalDirection();
        }

        // move the picture
        pic.translate(0, pic.getdy());
        pic.incrementTheta();
        pic.pulse();

        // check if the picture reaches the border
        if (pic.getUpperBound() > getHeight() || pic.getLowerBound() < 0) {
            pic.changeVerticalDirection();
            pic.changeRotationDirection();
        }

        repaint();

        return true;
    }
}