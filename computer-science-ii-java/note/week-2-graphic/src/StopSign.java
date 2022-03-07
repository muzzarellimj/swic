package semester_two.week_two.gui;

import java.awt.*;
import java.util.Random;

public class StopSign extends Polygon {
    private int length;
    private int dx, dy;
    private static Random rand;
    public StopSign() {
        this(0,0,50);
    }

    public StopSign(int x, int y, int len) {
        xpoints = new int[8];
        ypoints = new int[8];
        npoints = 8;
        length = len;
        int a = (int)(.7*len);
        xpoints[0] = x + a;
        ypoints[0] = y;
        xpoints[1] = x + a + len;
        ypoints[1] = y;
        xpoints[2] = x + 2*a + len;
        ypoints[2] = y + a;
        xpoints[3] = x + 2*a + len;
        ypoints[3] = y + a + len;
        xpoints[4] = x + a + len;
        ypoints[4] = y + 2*a + len;
        xpoints[5] = x + a;
        ypoints[5] = y + 2*a + len;
        xpoints[6] = x;
        ypoints[6] = y + a + len;
        xpoints[7] = x;
        ypoints[7] = y + a;

        // Initialize vertical and horiztonal movements
        // to some value between 2-10
        rand = new Random();
        dx = rand.nextInt(9) + 2;
        dy = rand.nextInt(9) + 2;
    }

    public int getRightBound() {
        return xpoints[2];
    }

    public int getLeftBound() {
        return xpoints[7];
    }

    public int getUpperBound() {
        return ypoints[0];
    }

    public int getLowerBound() {
        return ypoints[5];
    }

    public int getdx() {
        return dx;
    }

    public int getdy() {
        return dy;
    }

    public void changeHoriztonalLDirection() {
        dx = -dx;
    }

    public void changeVerticalDirection() {
        dy = -dy;
    }
}