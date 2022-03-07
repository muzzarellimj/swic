import java.util.Scanner;

public class Input {

    public static void main(String[] args) {
        /* scanner object is created and accepting input from the keyboard */
        Scanner keyboard = new Scanner(System.in);

        /* print a question of what the user should input */
        System.out.println("How many students are present in class today?");

        /* accept the next entered integer and parse it */
        int numberOfStudents = keyboard.nextInt();

        /* print the value that was parsed to the numberOfStudents variable */
        System.out.println("The number of students in class today is " + numberOfStudents + ".");

        /* print another question of what the user should input */
        System.out.print("What is the tax rate?");

        /* scan the next token of input and return it as a double */
        double taxRate = keyboard.nextDouble();

        /* print the value that was parsed to the taxRate variable */
        System.out.println("New tax rate is " + taxRate + ".");

        /* print a question of what the user should input */
        System.out.print("Is it raining? Reply with true/false.");

        /* scan the next token of input and return it as a boolean */
        boolean isRaining = keyboard.nextBoolean();

        /* print the value that was parsed to the taxRate variable */
        System.out.println("It is " + isRaining + " that it is raining.");
    }
}