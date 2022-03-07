package semester_one.week_fourteen;

import javax.swing.*;
import java.awt.*;

public class GUI {

    private JFrame window;
    private JButton click;
    private JButton close;
    private JPanel mainPanel;
    private JLabel word;
    private JRadioButton[] sizeOption;
    private JCheckBox[] toppingOption;
    private ButtonGroup sizeOptionGroup;
    private JSlider quantity;

    private JMenuBar menuBar;
    private JMenu options, about;
    private JMenuItem[] optionItems;
    private JMenuItem[] aboutItems;

    public GUI() {
        window = new JFrame();
        click = new JButton();
        close = new JButton();
        mainPanel = new JPanel();
        word = new JLabel();
        sizeOption = new JRadioButton[3];

        for (int i = 0; i < sizeOption.length; i++) {
            sizeOption[i] = new JRadioButton();
        }

        toppingOption = new JCheckBox[4];

        for (int i = 0; i < toppingOption.length; i++) {
            toppingOption[i] = new JCheckBox();
        }

        sizeOptionGroup = new ButtonGroup();

        for (JRadioButton r : sizeOption) {
            sizeOptionGroup.add(r);
        }

        quantity = new JSlider();

        // create the menu
        menuBar = new JMenuBar();
        options = new JMenu("Options");
        about = new JMenu("About");
        optionItems = new JMenuItem[3];
        aboutItems = new JMenuItem[2];

        for (int i = 0; i < optionItems.length; i++) {
            optionItems[i] = new JMenuItem();
        }

        for (int i = 0; i < aboutItems.length; i++) {
            aboutItems[i] = new JMenuItem();
        }

        optionItems[0].setText("Reset");
        optionItems[1].setText("Clear");
        optionItems[2].setText("Select All");

        aboutItems[0].setText("About...");
        aboutItems[0].setMnemonic('A');
        aboutItems[1].setText("Give Up");

        for (JMenuItem m : optionItems) {
            options.add(m);
        }

        for (JMenuItem m : aboutItems) {
            about.add(m);
        }

        menuBar.add(options);
        menuBar.add(about);

        init();
    }

    private void init() {
        // set the window properties
        window.setTitle("My First Window");
        // window.setLocation(200, 300);
        window.setSize(600,650);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        // set panel properties (default is a flow layout)
        mainPanel.setBackground(Color.GREEN);

        // set component properties
        click.setText("Click Here");
        close.setText("Close Me");
        close.setBackground(Color.BLUE);
        close.setForeground(Color.WHITE);
        close.setFont(new Font("Arial", Font.PLAIN, 24));
        word.setText("Words go here...");

        // set the JRadioButton properties
        sizeOption[0].setText("Small");
        sizeOption[1].setText("Medium");
        sizeOption[1].setSelected(true);
        sizeOption[2].setText("Large");

        // set the JCheckBox properties
        toppingOption[0].setText("Nuts");
        toppingOption[1].setText("Cherries");
        toppingOption[2].setText("Whipped Cream");
        toppingOption[2].setSelected(true);
        toppingOption[3].setText("Caramel Drizzle");
        toppingOption[3].setSelected(true);

        // set the JSlider properties
        quantity.setMinimum(1);
        quantity.setMaximum(12);
        quantity.setOrientation(JSlider.VERTICAL);
        quantity.setValue(6);

        // add components to panel
        mainPanel.add(click);
        mainPanel.add(close);
        mainPanel.add(word);

        for (JRadioButton r : sizeOption) {
            mainPanel.add(r);
        }

        for (JCheckBox c : toppingOption) {
            mainPanel.add(c);
        }

        mainPanel.add(quantity);

        // add panel to window
        window.add(mainPanel);
        window.setJMenuBar(menuBar);
    }
}