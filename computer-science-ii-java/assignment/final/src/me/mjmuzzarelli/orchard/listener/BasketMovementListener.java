package me.mjmuzzarelli.orchard.listener;

import me.mjmuzzarelli.orchard.Orchard;
import me.mjmuzzarelli.orchard.gui.Frame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * The {@link BasketMovementListener} class is an extension of the
 * {@link KeyAdapter} class that responds to presses of the A and D key and
 * responds by moving the
 * {@link me.mjmuzzarelli.orchard.gui.component.Basket} across the screen
 * accordingly.
 *
 * @author Michael Muzzarelli
 */
public class BasketMovementListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        Frame frame = Orchard.getInstance();

        switch (e.getKeyCode()) {
            case KeyEvent.VK_D:
                if (frame.getPanel().getBasket().getRightBound() <
                        frame.getFrame().getWidth()) {
                    frame.getPanel().getBasket().translate(20);
                }
                break;

            case KeyEvent.VK_A:
                if (frame.getPanel().getBasket().getLeftBound() > 0) {
                    frame.getPanel().getBasket().translate(-20);
                }
                break;
        }
    }
}