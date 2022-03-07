package semester_one.week_four;

import java.util.Scanner;

/**
 * if...
 * if...else for mutually exclusive cases
 * extended if...else for many mutually exclusive cases
 * nested if...else for selection statements inside one another
 * conditional operator, ? :
 */
public class SelectionStatement {

    private static final double BASE_COST = 2.00;

    private static final double SPRINKLE_UPCHARGE = 0.85;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalCost = BASE_COST;
        boolean addSprinkles = false;
        String choice = null;

        // simple if statement: if addSprinkles is true, add upcharge
        System.out.println("...add sprinkles? (true/false)");
        addSprinkles = scanner.nextBoolean();

        if (addSprinkles) {
            totalCost += SPRINKLE_UPCHARGE;
        }

        System.out.println("Cost is $" + totalCost);

        // another simple if statement: if choice is yes, add upcharge
        System.out.println("...add sprinkles? (yes/no)");
        choice = scanner.next();

        if (choice.equals("ok") || choice.equals("yes") ||
                choice.equals("ya") || choice.equals("y")) {
            totalCost += SPRINKLE_UPCHARGE;
        }

        System.out.println(totalCost);
    }
}