package semester_one.week_four.assignment;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;

// Author:          Michael Muzzarelli
// Date Created:    9/11/2020
// Last Modified:   9/11/2020
// Description:     Ask, record, and calculate the total cost of an ice cream
//                  order via a JOptionPane.
public class IceCream {

    // the base price of an ice cream cone.
    private static final double BASE_PRICE = 1.99;

    // how much each scoop of ice cream will cost.
    private static final double COST_PER_SCOOP = 0.99;

    // the additional upcharge for dipping the cone.
    private static final double DIP_UPCHARGE = 1.49;

    // the additional upcharge for adding sprinkles.
    private static final double SPRINKLES_UPCHARGE = 1.49;

    // the current tax rate in our area.
    private static final double TAX_RATE = 0.091;

    public static void main(String[] args) {
        Object[] toppingOptions = { "No", "Yes" };
        String input = null;
        int numberOfScoops = 0, dip = 0, sprinkles = 0;
        double totalCost = BASE_PRICE, donation = 0.0;

        Color backgroundColor = new Color(238, 237, 231);
        Color fontColor = new Color(0, 95, 129);
        Font font = new Font("Arial", Font.PLAIN, 20);

        UIManager.put("OptionPane.messageForeground", fontColor);
        UIManager.put("OptionPane.background", backgroundColor);
        UIManager.put("Panel.background", backgroundColor);
        UIManager.put("OptionPane.messageFont", font);

        DecimalFormat formatter = new DecimalFormat("$#,##0.00");

        JOptionPane.showMessageDialog(null,
                "Welcome to Snowly Ice Cream - " +
                        "home of hand-scooped serotonin!",
                "Snowly Ice Cream",
                JOptionPane.PLAIN_MESSAGE, null);

        input = JOptionPane.showInputDialog(null,
                "How many scoops would you like?",
                "Snowly Ice Cream",
                JOptionPane.PLAIN_MESSAGE);
        numberOfScoops = Integer.parseInt(input);
        totalCost += (numberOfScoops * COST_PER_SCOOP);

        dip = JOptionPane.showOptionDialog(null,
                "Would you like your ice cream dipped?",
                "Snowly Ice Cream",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                toppingOptions, null);
        totalCost += (dip * DIP_UPCHARGE);

        sprinkles = JOptionPane.showOptionDialog(null,
                "Would you like your ice cream with sprinkles?",
                "Snowly Ice Cream",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                toppingOptions, null);
        totalCost += (sprinkles * SPRINKLES_UPCHARGE);

        totalCost *= (1 + TAX_RATE);

        input = JOptionPane.showInputDialog(null,
                "How much would you like to donate to the local kid's club?",
                "Snowly Ice Cream", JOptionPane.PLAIN_MESSAGE);
        donation = Double.parseDouble(input);
        totalCost += donation;

        JOptionPane.showMessageDialog(null,
                "Your total cost is " + formatter.format(totalCost),
                "Snowly Ice Cream",
                JOptionPane.PLAIN_MESSAGE, null);
    }
}