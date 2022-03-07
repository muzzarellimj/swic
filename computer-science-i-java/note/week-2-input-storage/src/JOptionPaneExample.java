import javax.swing.*;
import java.awt.*;

public class JOptionPaneExample {

    public static void main(String[] args) {
        Color fontColor = new Color(253, 161, 23);
        Color backgroundColor = new Color(65, 65, 65);
        Font messageFont = new Font("Arial", Font.BOLD, 24);

        UIManager.put("OptionPane.messageForeground", fontColor);
        UIManager.put("OptionPane.background", backgroundColor);
        UIManager.put("Panel.background", backgroundColor);
        UIManager.put("OptionPane.messageFont", messageFont);

        JOptionPane.showMessageDialog(null,
                "Playing with the JOptionPane",
                "Display Fun",
                JOptionPane.INFORMATION_MESSAGE);
    }
}