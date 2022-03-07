package me.mjmuzzarelli.orchard.gui;

import me.mjmuzzarelli.orchard.listener.AppleCreationListener;
import me.mjmuzzarelli.orchard.listener.AppleMovementListener;
import me.mjmuzzarelli.orchard.listener.BasketMovementListener;

import javax.swing.*;

/**
 * The {@link Frame} class is a pseudo-extension of the {@link JFrame}
 * class that constructs the application frame and provides visibility to the
 * components of the frame.
 *
 * @author Michael Muzzarelli
 */
public class Frame {

    private final JFrame frame;

    private final Panel panel;

    private final Timer appleCreationTimer;
    private final Timer appleMovementTimer;

    /**
     * Construct a {@link Frame} object.
     */
    public Frame() {
        frame = new JFrame("Orchard");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1400, 600);

        panel = new Panel();

        appleCreationTimer = new Timer(2500, new AppleCreationListener());
        appleMovementTimer = new Timer(10, new AppleMovementListener());

        frame.addKeyListener(new BasketMovementListener());

        frame.add(panel);

        frame.setVisible(true);

        appleCreationTimer.start();
        appleMovementTimer.start();
    }

    /**
     * Retrieve the {@link JFrame} that is constructed with this
     * {@link Frame}.
     *
     * @return  the constructed {@link JFrame}.
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Retrieve the {@link Panel} panel that is added to this {@link Frame}.
     *
     * @return  the {@link Panel} panel.
     */
    public Panel getPanel() {
        return panel;
    }

    /**
     * Retrieve the {@link Timer} linked to the {@link AppleCreationListener}.
     *
     * @return  the {@link AppleCreationListener} {@link Timer}.
     */
    public Timer getAppleCreationTimer() {
        return appleCreationTimer;
    }

    /**
     * Retrieve the {@link Timer} linked to the {@link AppleMovementListener}.
     *
     * @return  the {@link AppleMovementListener} {@link Timer}.
     */
    public Timer getAppleMovementTimer() {
        return appleMovementTimer;
    }
}