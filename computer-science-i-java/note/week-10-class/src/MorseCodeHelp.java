package semester_one.week_ten;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCodeHelp {

    public static void main(String[] args) {
        int choice = 0;
        choice = JOptionPane.showConfirmDialog(null, "Should we do it?",
                "Show Morse code?", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            System.out.println("Chose yes.");
        } else if (choice == JOptionPane.NO_OPTION) {
            System.out.println("Chose no.");
        }

        Scanner fromFile = null, fromKeyboard = new Scanner(System.in);
        String nameOfFile = null;

        System.out.print("What is the file name?: ");

        do {
            try {
                nameOfFile = fromKeyboard.nextLine();
                fromFile = new Scanner(new File(nameOfFile + ".txt"));
            } catch (FileNotFoundException e) {
                System.out.println("Error... need correct filename!");
                System.out.println("Re-enter filename: ");
            }
        } while (fromFile == null);
    }
}