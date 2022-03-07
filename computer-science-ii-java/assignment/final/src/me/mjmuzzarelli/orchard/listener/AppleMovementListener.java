package me.mjmuzzarelli.orchard.listener;

import me.mjmuzzarelli.orchard.Orchard;
import me.mjmuzzarelli.orchard.gui.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The {@link AppleMovementListener} is an implementation of the
 * {@link ActionListener} class that stops
 * {@link me.mjmuzzarelli.orchard.gui.component.Apple} movement if the
 * boolean method {@link me.mjmuzzarelli.orchard.gui.Panel#moveApples()}
 * returns false.
 *
 * @author Michael Muzzarelli
 */
public class AppleMovementListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Frame frame = Orchard.getInstance();

        if (!frame.getPanel().moveApples()) {
            frame.getAppleMovementTimer().stop();
        }
    }
}