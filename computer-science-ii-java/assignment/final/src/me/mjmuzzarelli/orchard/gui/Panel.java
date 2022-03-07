package me.mjmuzzarelli.orchard.gui;

import me.mjmuzzarelli.orchard.gui.component.Apple;
import me.mjmuzzarelli.orchard.gui.component.Background;
import me.mjmuzzarelli.orchard.gui.component.Basket;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The {@link Panel} class is an extension of the {@link JPanel} class that
 * represents the game panel that the {@link Background}, {@link Basket}, and
 * {@link Apple}s are displayed on.
 *
 * @author Michael Muzzarelli
 */
public class Panel extends JPanel {

    private int applesMissed;

    private final ArrayList<Apple> apples;
    private final Background background;
    private final Basket basket;

    /**
     * Construct an {@link Panel} object.
     */
    public Panel() {
        super();

        apples = new ArrayList<>();
        background = new Background(0, 0, 1400, 600);
        basket = new Basket(650, 450, 100, 100, Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics = (Graphics2D) g;

        graphics.drawImage(background.getImage(), (int) background.getX(),
                (int) background.getY(), (int) background.getWidth(),
                (int) background.getHeight(), null);

        graphics.setColor(basket.getColor());
        graphics.fill(basket);

        for (Apple a : apples) {
            graphics.drawImage(a.getImage(), (int) a.getX(), (int) a.getY(),
                    (int) a.getWidth(), (int) a.getHeight(), null);
        }

        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(0, 0, 1400, 30);

        graphics.setColor(Color.BLACK);
        graphics.drawString("Apples Caught: " + basket.getAppleCount(), 10, 20);
        graphics.drawString("Apples Missed: " + applesMissed, 720, 20);
    }

    /**
     * Check if the {@link Apple}s should continue falling on the panel.
     *
     * @return  if the {@link Apple}s should continue falling.
     */
    public boolean moveApples() {
        for (Apple a : apples) {
            a.translate(0, a.getDeltaY());
        }

        for (int i = 0; i < apples.size(); i++) {
            if (apples.get(i).getLowerBound() >= getHeight()) {
                apples.remove(apples.get(i));

                applesMissed++;

            } else if (basket.intersects(apples.get(i))) {
                if (apples.get(i).getEffect() == Apple.Effect.NORMAL) {
                    apples.remove(apples.get(i));

                    basket.incrementAppleCount(1);
                } else if (apples.get(i).getEffect() == Apple.Effect.BONUS) {
                    apples.remove(apples.get(i));

                    basket.incrementAppleCount(5);
                }
            }
        }

        if (basket.getAppleCount() == 25) {
            getGraphics().drawImage(new ImageIcon("victory.png").getImage(),
                    425, 75, 600, 500, null);

            return false;
        }

        repaint();

        return true;
    }

    /**
     * Retrieve the {@link ArrayList} of {@link Apple}s to be displayed on
     * this {@link Panel} panel.
     *
     * @return  the {@link ArrayList} of {@link Apple} to be displayed.
     */
    public ArrayList<Apple> getApples() {
        return apples;
    }

    /**
     * Retrieve the {@link Basket} that should be displayed on this
     * {@link Panel} panel.
     *
     * @return  the {@link Basket} to be displayed.
     */
    public Basket getBasket() {
        return basket;
    }
}