package semester_two.week_two.gui;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class Picture extends Rectangle {

    private ImageIcon pic;
    private double theta, dTheta;
    private int dx, dy;
    private static int PULSE_FACTOR = 20;
    private static final int MAX_PULSE = 10;
    private final int ORIGINAL_WIDTH;

    public Picture(int x, int y, int width, int height, String fileName) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.theta = 0;
        this.pic = new ImageIcon(fileName);
        this.dx = 8;
        this.dy = 6;
        this.dTheta = 0.2;

        ORIGINAL_WIDTH = width;
    }

    public int getLeftBound() {
        return x;
    }

    public int getRightBound() {
        return x + width;
    }

    public int getUpperBound() {
        return y;
    }

    public int getLowerBound() {
        return y + height;
    }

    public Image getImage() {
        return pic.getImage();
    }

    public int getdx() {
        return dx;
    }

    public int getdy() {
        return dy;
    }

    public void changeVerticalDirection() {
        dy = -dy;
    }

    public double getTheta() {
        return theta;
    }

    public void incrementTheta() {
        theta += dTheta;
    }

    public void changeRotationDirection() {
        dTheta = 2 * -dTheta;
    }

    public void pulse() {
        width = (int) ((100 + PULSE_FACTOR) / 100.0 * ORIGINAL_WIDTH);

        if (width > MAX_PULSE * ORIGINAL_WIDTH ||
                width < 1.0 / MAX_PULSE * ORIGINAL_WIDTH) {
            PULSE_FACTOR *= -1;
        }
    }
}