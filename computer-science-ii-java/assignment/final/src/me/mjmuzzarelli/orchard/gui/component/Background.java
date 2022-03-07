package me.mjmuzzarelli.orchard.gui.component;

import javax.swing.*;
import java.awt.*;

/**
 * The {@link Background} class is an extension of the {@link Rectangle}
 * class that represents the background image of the panel that is painted at
 * a particular width and height.
 *
 * @author Michael Muzzarelli
 */
public class Background extends Rectangle {

    private final Image image;

    /**
     * Construct a {@link Background} object.
     *
     * @param x         the x-coordinate of this {@link Background}.
     * @param y         the y-coordinate of this {@link Background}.
     * @param width     the width of this {@link Background}.
     * @param height    the height of this {@link Background}.
     */
    public Background(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = new ImageIcon("orchard.png").getImage();
    }

    /**
     * Retrieve the image that this {@link Background} should present.
     *
     * @return  the presented image.
     */
    public Image getImage() {
        return image;
    }
}