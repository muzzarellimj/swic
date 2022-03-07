package me.mjmuzzarelli.orchard;

import me.mjmuzzarelli.orchard.gui.Frame;

/**
 * The {@link Orchard} class is the main entry point to the application.
 *
 * @author Michael Muzzarelli
 */
public class Orchard {

    private static Frame instance;

    /**
     * The main entry point to the {@link Orchard} application.
     *
     * @param args  the application entry arguments.
     */
    public static void main(String[] args) {
        instance = new Frame();
    }

    /**
     * Retrieve the singleton instance of the {@link Orchard} class.
     *
     * @return  the singleton instance of the {@link Orchard} class.
     */
    public static Frame getInstance() {
        return instance;
    }
}