package semester_one.week_five;

import java.util.Scanner;
import java.util.Random;

public class SelectionStatementExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        String isIsNot = null;

        // Write a switch statement to determine if a given number is prime,
        // composite, or neither: [1, 10].
        System.out.print("Pick a number between 1-10: ");
        number = scanner.nextInt();

        switch (number) {
            // PRIME: 2 3 5 7
            // COMPOSITE: 4 6 8 9 10
            // NEITHER: 1
            case 1 :
                System.out.println("1 is neither prime nor composite."); break;

            case 2 :
            case 3 :
            case 5 :
            case 7 :
                System.out.println(number + " is prime."); break;

            // default catches the rest of the potential cases
            default:
                System.out.println(number + " is composite.");
        }

        // Illustrate using the conditional operator A ? B : C (ternary)
        isIsNot = (number == 2 || number == 3 || number == 5 || number == 7) ?
                " is " : " is not ";

        System.out.println(number + isIsNot + "prime.");

        // to generate a random number between two values: [a, b]
        // nextInt(b - a + 1) + a
    }
}