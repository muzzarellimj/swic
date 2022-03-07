package semester_two.week_two.assignment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OctagonGUI {

    private JFrame frame;
    private OctagonPanel panel;
    private Timer timer;

    public OctagonGUI() {
        frame = new JFrame("Octagonal Animation GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        panel = new OctagonPanel();

        timer = new Timer(100, new MovementListener());

        frame.add(panel);
        frame.setVisible(true);
        timer.start();
    }

    private class MovementListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            panel.move();
        }
    }
}