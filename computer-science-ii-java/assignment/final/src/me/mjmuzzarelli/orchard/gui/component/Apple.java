package me.mjmuzzarelli.orchard.gui.component;

import javax.swing.ImageIcon;
import java.awt.*;

/**
 * The {@link Apple} class is an extension of the {@link Rectangle} class
 * that represents the apples that fall into the {@link Basket}.
 *
 * @author Michael Muzzarelli
 */
public class Apple extends Rectangle {

    private final int deltaY;

    private final Effect effect;

    private final Image image;

    /**
     * Construct an {@link Apple} object.
     *
     * @param x         the x-coordinate of this {@link Apple}.
     * @param y         the y-coordinate of this {@link Apple}.
     * @param width     the width of this {@link Apple}.
     * @param height    the height of this {@link Apple}.
     * @param deltaY    the delta-y value of this {@link Apple}.
     * @param image     the image that this {@link Apple} should present.
     * @param effect    the {@link Effect} of this {@link Apple}.
     */
    public Apple(int x, int y, int width, int height, int deltaY,
                 ImageIcon image, Effect effect) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.deltaY = deltaY;
        this.image = image.getImage();
        this.effect = effect;
    }

    /**
     * Retrieve the delta-y value of this {@link Apple}.
     *
     * @return  the delta-y value.
     */
    public int getDeltaY() {
        return deltaY;
    }

    /**
     * Retrieve the image that this {@link Apple} should present.
     *
     * @return  the presented image.
     */
    public Image getImage() {
        return image;
    }

    /**
     * Retrieve the lower boundary of this {@link Apple}.
     *
     * @return  the lower boundary.
     */
    public int getLowerBound() {
        return y + height;
    }

    /**
     * Retrieve the {@link Effect} that this {@link Apple} possesses.
     *
     * @return  the {@link Effect} of this {@link Apple}.
     */
    public Effect getEffect() {
        return effect;
    }

    /**
     * The {@link Effect} class represents the point bonus received from
     * catching a red or green ({@link Effect#NORMAL}) or blue
     * ({@link Effect#BONUS}) {@link Apple}.
     *
     * @author Michael Muzzarelli
     */
    public enum Effect {
        NORMAL, BONUS
    }
}