package semester_one.week_fourteen;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * There are a few layouts that are commonly used.
 *  - FlowLayout (default for JPanel)
 *  - BoxLayout - vertical or horizontal box, lined up
 *  - BorderLayout - lay out objects in borders
 *  - GridLayout - organize in rows and columns
 *  - GridBagLayout - similar to Grid but more control over object placement
 */
public class GUILayout {

    private final int GRID_SIZE = 5;

    private JFrame frame;
    private JButton[] button;
    private JButton[] square;
    private JPanel centerPanel;
    private Random random;

    // used to, BorderLayout: NORTH, SOUTH, EAST, WEST, CENTER
    // instead, BorderLayout: PAGE_START, PAGE_END, LINE_END, LINE_START, CENTER

    public GUILayout() {
        // create objects necessary for the class
        random = new Random();

        // create the frame
        frame = new JFrame("Layout Demonstration");

        // set the frame attributes
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // create the panel
        centerPanel = new JPanel();
        centerPanel.setBackground(new Color(75,75,200).darker());
        centerPanel.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));

        // create the buttons
        button = new JButton[6];

        for (int i = 0; i < button.length; i++)
            button[i] = new JButton();

        button[0].setText("NORTH");
        button[1].setText("SOUTH");
        button[2].setText("EAST");
        button[3].setText("WEST");
        button[4].setText("CENTER LEFT");
        button[5].setText("CENTER RIGHT");

        // create the center 'sqaure' buttons
        square = new JButton[GRID_SIZE * GRID_SIZE];

        for (int i = 0; i < square.length; i++) {
            square[i] = new JButton("" + (i + 1));
            square[i].setBackground(new Color(random.nextInt(255),
                    random.nextInt(255), random.nextInt(255)));
            square[i].setForeground(Color.WHITE);
        }

        // add all the components and display the frame
        for (JButton b : square)
            centerPanel.add(b);

        frame.add(button[0], BorderLayout.PAGE_START);
        frame.add(button[1], BorderLayout.PAGE_END);
        frame.add(button[2], BorderLayout.LINE_END);
        frame.add(button[3], BorderLayout.LINE_START);
//        centerPanel.add(button[4]);
//        centerPanel.add(button[5]);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUILayout();
    }
}