package me.mjmuzzarelli.orchard.listener;

import me.mjmuzzarelli.orchard.Orchard;
import me.mjmuzzarelli.orchard.gui.Frame;
import me.mjmuzzarelli.orchard.gui.component.Apple;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * The {@link AppleCreationListener} class is an implementation of the
 * {@link ActionListener} class that creates falling {@link Apple}s as long
 * as the boolean method {@link me.mjmuzzarelli.orchard.gui.Panel#moveApples}
 * returns true.
 *
 * @author Michael Muzzarelli
 */
public class AppleCreationListener implements ActionListener {

    private int applesCreated = 0;

    private Random random;

    private Frame frame;

    @Override
    public void actionPerformed(ActionEvent e) {
        random = new Random();
        frame = Orchard.getInstance();

        if (frame.getPanel().moveApples()) {
            if (applesCreated < 15) {
                createApple(4, new ImageIcon("red-apple.png"),
                        Apple.Effect.NORMAL);

            } else if (applesCreated > 16 && applesCreated < 30) {
                createApple(6, new ImageIcon("green-apple.png"),
                        Apple.Effect.NORMAL);

            } else if (applesCreated > 31) {
                createApple(8, new ImageIcon("red-apple.png"),
                        Apple.Effect.NORMAL);

            } else if (applesCreated == 16 || applesCreated == 30) {
                createApple(10, new ImageIcon("blue-apple.png"),
                        Apple.Effect.BONUS);
            }
        }

        applesCreated++;
    }

    /**
     * Create an {@link Apple} and add it to the respective
     * {@link java.util.ArrayList}.
     *
     * @param deltaY    the delta-y value of this {@link Apple}.
     * @param image     the image that this {@link Apple} should present.
     * @param effect    the {@link Apple.Effect} of this {@link Apple}.
     */
    private void createApple(int deltaY, ImageIcon image, Apple.Effect effect) {
        frame.getPanel().getApples().add(new Apple(random.nextInt(1400),
                random.nextInt(100) - 200, 30, 30,
                deltaY, image, effect));
    }
}