package semester_one.week_fifteen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * The game class of the {@link TicTacToe} application.
 *
 * @author Michael Muzzarelli
 * @since November 30, 2020
 */
public class Game {

    private static final int GRID_SIZE = 3;

    private JFrame window;
    private JPanel mPanel;
    private ButtonListener listener;
    private JButton[] grid;
    private Font buttonFont;
    private boolean playerX;
    private int turnNumber;
    private Random random;

    public Game() {
        // construct the window
        window = new JFrame("Tic-Tac-Toe");
        System.out.println(Toolkit.getDefaultToolkit().getScreenSize());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
                (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        window.setLocationRelativeTo(null);

        // define the font
        int fontSize = 120 - 20 * (GRID_SIZE / 3);
        if (fontSize <= 3) {
            fontSize = 10;
        }
        buttonFont = new Font("Arial", Font.BOLD, fontSize);

        // define the player turn
        playerX = true;

        // define the turn number
        turnNumber = 1;

        // define the random object
        random = new Random();

        // define the listener
        listener = new ButtonListener();

        // construct the panel
        mPanel = new JPanel();
        mPanel.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE, 5, 5));
        mPanel.setBackground(Color.WHITE);

        // construct the buttons
        grid = new JButton[GRID_SIZE * GRID_SIZE];

        for (int i = 0; i < grid.length; i++) {
            grid[i] = new JButton();
            grid[i].setFont(buttonFont);
            grid[i].addActionListener(listener);
//            grid[i].addMouseListener(new AnnoyingListener());
            grid[i].setBackground(new Color(245, 245, 245));
        }

        // add components to the panel
        for (JButton b : grid) {
            mPanel.add(b);
        }

        // add panel to the window
        window.add(mPanel);

        // set the window visibility
        window.setVisible(true);
    }

    // different methods to creating listeners
    //      a) create an instance of a listener class
    //      b) bind an anonymous instance of a listener class to a graphical component
    //      c) combine an anonymous class when registering the listener
    //      d) use lambda expressions

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();

            if (button.getText().equals("")) {
                if (playerX) {
                    button.setText("X");
                    button.setForeground(Color.GREEN.darker());
                } else {
                    button.setText("O");
                    button.setForeground(Color.RED);
                }

                playerX = !playerX;
            }

            if (checkWinner()) {
                JOptionPane.showMessageDialog(mPanel, "We have a winner!", "Congratulations!",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (turnNumber > GRID_SIZE * GRID_SIZE) {
                JOptionPane.showMessageDialog(mPanel, "We have a cat's game!", "No moves left!",
                        JOptionPane.INFORMATION_MESSAGE);
            }

//            reset();
        }
    }

    private boolean checkWinner() {
        boolean isWinner = true;

        for (int i = 0; i < GRID_SIZE; i++) {
            isWinner = true;
            if (!grid[GRID_SIZE * i].getText().equals("")) {
                int j = 1;
                while (j < GRID_SIZE && isWinner) {
                    if (!grid[GRID_SIZE * i].getText().equals(grid[GRID_SIZE * i + j++].getText())) {
                        isWinner = false;
                    }
                }

                if (isWinner) {
                    return true;
                }
            }
        }

        /*
        // check for winners along the rows
        if (!grid[0].getText().equals("") && grid[0].getText().equals(grid[1].getText()) &&
            grid[0].getText().equals(grid[2].getText())) {
            return true;
        }

        else if (!grid[3].getText().equals("") && grid[3].getText().equals(grid[4].getText()) &&
                grid[3].getText().equals(grid[5].getText())) {
            return true;
        }

        else if (!grid[6].getText().equals("") && grid[6].getText().equals(grid[7].getText()) &&
                grid[6].getText().equals(grid[8].getText())) {
            return true;
        }

        // check for winners along the columns
        else if (!grid[6].getText().equals("") && grid[0].getText().equals(grid[3].getText()) &&
                grid[0].getText().equals(grid[6].getText())) {
            return true;
        }

        else if (grid[1].getText().equals(grid[4].getText()) &&
                grid[1].getText().equals(grid[7].getText())) {
            return true;
        }

        else if (grid[2].getText().equals(grid[5].getText()) &&
                grid[2].getText().equals(grid[8].getText())) {
            return true;
        }

        //check for winners along the diagonals
        else if (grid[0].getText().equals(grid[4].getText()) &&
                grid[0].getText().equals(grid[8].getText())) {
            return true;
        }

        else if (grid[6].getText().equals(grid[3].getText()) &&
                grid[0].getText().equals(grid[6].getText())) {
            return true;
        }

        return false; */

        return false;
    }

    private void reset() {
        playerX = true;
        turnNumber = 1;

        for (JButton b : grid) {
            b.setText("");
        }
    }

    private class AnnoyingListener extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            if (!playerX) {
                window.setLocation(random.nextInt(800), random.nextInt(600));
            }
        }
    }
}