package semester_one.week_seven.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// Author:          Michael Muzzarelli
// Date Created:    9/30/2020
// Date Modified:   9/30/2020
// Description:     Read a file, casinoDumpFile.txt, an output the
//                  distribution of errors and values 7, 77, 777, 7777, and
//                  77777, optionally to a file.
public class Sevens {

    public static void main(String[] args) {
        Scanner fromKeyboard = null;
        Scanner fromFile = null;
        PrintWriter toFile = null;

        int count7 = 0, count77 = 0, count777 = 0, count7777 = 0,
                count77777 = 0, countError = 0;

        int countTotal = 0, countValid = 0;

        double percent7 = 0.0, percent77 = 0.0, percent777 = 0.0,
                percent7777 = 0.0, percent77777 = 0.0, percentError = 0.0;

        String saveToFile = null;

        String fileName = null;

        try {
            fromKeyboard = new Scanner(System.in);
            fromFile = new Scanner(new File("casinoDataDump.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Dump file could not be found - closing...");
            System.exit(0);
        }

        while (fromFile.hasNext()) {
            String value = fromFile.next();

            if (value.startsWith("-")) {
                countError++;
            }

            switch (value) {
                case "7": count7++; break;
                case "77:": count77++; break;
                case "777": count777++; break;
                case "7777": count7777++; break;
                case "77777": count77777++; break;
            }

            countTotal++;
        }

        countValid = countTotal - countError;

        percent7 = (double) count7 / countValid * 100;
        percent77 = (double) count77 / countValid * 100;
        percent777 = (double) count777 / countValid * 100;
        percent7777 = (double) count7777 / countValid * 100;
        percent77777 = (double) count77777 / countValid * 100;
        percentError = (double) countError / countTotal * 100;

        System.out.println("LUCKY SEVEN DISTRIBUTION:\n");
        System.out.printf("%-30s%-10s%-10s%n",
                "CATEGORY", "COUNT", "PERCENTAGE");
        System.out.printf("%-30s%-10d%-8f%%%n",
                "Distribution of error: ", countError, percentError);
        System.out.printf("%-30s%-10d%-8f%%%n",
                "Distribution of 7: ", count7, percent7);
        System.out.printf("%-30s%-10d%-8f%%%n",
                "Distribution of 77: ", count77, percent77);
        System.out.printf("%-30s%-10d%-8f%%%n",
                "Distribution of 777: ", count777, percent777);
        System.out.printf("%-30s%-10d%-8f%%%n",
                "Distribution of 7777: ", count7777, percent7777);
        System.out.printf("%-30s%-10d%-8f%%%n",
                "Distribution of 77777: ", count77777, percent77777);

        System.out.print("\nWould you like to save these values to a file? "
                + "Enter 'yes' or 'no.' ");
        saveToFile = fromKeyboard.next();

        if (saveToFile.equalsIgnoreCase("yes")) {
            System.out.print("What would you like to call this file? ");
            fileName = fromKeyboard.next();

            try {
                toFile = new PrintWriter(fileName + ".txt");
            } catch (FileNotFoundException e) {
                System.out.println("Distribution file could not be found - " +
                        "closing...");
                System.exit(0);
            }

            toFile.println("LUCKY SEVEN DISTRIBUTION:\n");
            toFile.printf("%-30s%-10s%-10s%n",
                    "CATEGORY", "COUNT", "PERCENTAGE");
            toFile.printf("%-30s%-10d%-8f%%%n",
                    "Distribution of error: ", countError, percentError);
            toFile.printf("%-30s%-10d%-8f%%%n",
                    "Distribution of 7: ", count7, percent7);
            toFile.printf("%-30s%-10d%-8f%%%n",
                    "Distribution of 77: ", count77, percent77);
            toFile.printf("%-30s%-10d%-8f%%%n",
                    "Distribution of 777: ", count777, percent777);
            toFile.printf("%-30s%-10d%-8f%%%n",
                    "Distribution of 7777: ", count7777, percent7777);
            toFile.printf("%-30s%-10d%-8f%%%n",
                    "Distribution of 77777: ", count77777, percent77777);

            System.out.println("Output of distribution file complete. Have a "
                    + "great day!");

        } else if (saveToFile.equalsIgnoreCase("no")) {
            System.out.println("Have a great day!");
        }

        fromKeyboard.close();
        fromFile.close();

        if (toFile != null) {
            toFile.close();
        }
    }
}