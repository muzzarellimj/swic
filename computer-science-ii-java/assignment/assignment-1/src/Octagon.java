package semester_two.week_two.assignment;

import java.awt.*;

public class Octagon extends Polygon {

    private int length;
    private int deltaX, deltaY;

    public Octagon(int startX, int startY, int length, int deltaX, int deltaY) {
        this.xpoints = new int[8];
        this.ypoints = new int[8];
        this.npoints = 8;
        this.length = length;
        this.deltaX = deltaX;
        this.deltaY = deltaY;

        int a = (int) (0.7 * length);

        xpoints[0] = startX + a;
        ypoints[0] = startY;
        xpoints[1] = startX + a + length;
        ypoints[1] = startY;
        xpoints[2] = startX + a + a + length;
        ypoints[2] = startY + a;
        xpoints[3] = startX + a + a + length;
        ypoints[3] = startY + a + length;
        xpoints[4] = startX + a + length;
        ypoints[4] = startY + a + a + length;
        xpoints[5] = startX + a;
        ypoints[5] = startY + a + a + length;
        xpoints[6] = startX;
        ypoints[6] = startY + a + length;
        xpoints[7] = startX;
        ypoints[7] = startY + a;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public void negateDeltaX() {
        deltaX = -deltaX;
    }

    public void negateDeltaY() {
        deltaY = -deltaY;
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
}