package semester_two.week_two.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GUI {

    private JFrame frame;
    private Space space;
    private Timer bTimer;
    private Timer oTimer;
    private Random random;

    public GUI() {
        // create the frame and set properties
        frame = new JFrame("GUI Demonstration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        random = new Random();

        // create the space panel
        space = new Space();

        // create the timer and timer listener
        bTimer = new Timer(1500, new TimerListener());
        oTimer = new Timer(100, new MovementListener());

        // add components to the frame and set visible, start the timer
        frame.add(space);
        frame.setVisible(true);
        oTimer.start();
        bTimer.start();
    }

    // define the timer listener
    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            space.setBackground(new Color(random.nextInt(255),
                    random.nextInt(255), random.nextInt(255)));
        }
    }

    // define the movement listener
    private class MovementListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!space.moveObjects()) {
                oTimer.stop();
            }
        }
    }
}