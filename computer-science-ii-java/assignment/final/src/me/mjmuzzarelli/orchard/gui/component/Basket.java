package me.mjmuzzarelli.orchard.gui.component;

import java.awt.*;

/**
 * The {@link Basket} class is an extension of the {@link Polygon} class that
 * represents the basket that the {@link Apple}s will fall into.
 *
 * @author Michael Muzzarelli
 */
public class Basket extends Polygon {

    private int appleCount;

    private final Color color;

    /**
     * Construct a {@link Basket} object.
     *
     * @param x         the x-coordinate of this {@link Basket}.
     * @param y         the y-coordinate of this {@link Basket}.
     * @param width     the width of this {@link Basket}.
     * @param height    the height of this {@link Basket}.
     * @param color     the {@link Color} of this {@link Basket}.
     */
    public Basket(int x, int y, int width, int height, Color color) {
        this.xpoints = new int[4];
        this.ypoints = new int[4];
        this.npoints = 4;
        this.color = color;

        xpoints[0] = x;
        ypoints[0] = y;

        xpoints[1] = x + width;
        ypoints[1] = y;

        xpoints[2] = (int) (x + (0.85 * width));
        ypoints[2] = y + height;

        xpoints[3] = (int) (x + (0.15 * width));
        ypoints[3] = y + height;
    }

    /**
     * Retrieve the count of apples caught by this {@link Basket}.
     *
     * @return  the caught apple count.
     */
    public int getAppleCount() {
        return appleCount;
    }

    /**
     * Increment the {@link Basket#appleCount} by the provided value.
     *
     * @param value     the value to increment by.
     */
    public void incrementAppleCount(int value) {
        appleCount += value;
    }

    /**
     * Decrement the {@link Basket#appleCount} by the provided value.
     *
     * @param value     the value to decrement by.
     */
    public void decrementAppleCount(int value) {
        appleCount -= value;
    }

    /**
     * Retrieve the {@link Color} of this {@link Basket}.
     *
     * @return  the {@link Color} of this {@link Basket}.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Retrieve the left boundary of this {@link Basket}.
     *
     * @return  the left boundary of this {@link Basket}.
     */
    public int getLeftBound() {
        return xpoints[0];
    }

    /**
     * Retrieve the right boundary of this {@link Basket}.
     *
     * @return  the right boundary of this {@link Basket}.
     */
    public int getRightBound() {
        return xpoints[1];
    }

    /**
     * Translate this {@link Basket} by the provided delta-x value.
     *
     * @param deltaX    the delta-x value to translate this {@link Basket} by.
     */
    public void translate(int deltaX) {
        translate(deltaX, 0);
    }
}