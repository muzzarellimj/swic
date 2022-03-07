package semester_one.week_thirteen;

import java.util.Random;

public class Arrays {

    private static final int CLASS_SIZE = 24;
    private static final int NUM_SIMULATIONS = 100;

    public static void main(String[] args) {
        // dayOne();
        dayTwo();
    }

    public static void dayOne() {
        // store exam ii scores of all 24 calc i students
        double[] studentScores = new double[CLASS_SIZE];

        // give students random scores
        Random rand = new Random();

        for (int i = 0; i < studentScores.length; i++) {
            studentScores[i] = rand.nextDouble() * 100;
        }

        // print the array values
        for (int i = 0; i < studentScores.length; i++) {
            System.out.println(studentScores[i]);
        }

        // find the maximum
        double max = studentScores[0];

        for (int i = 1; i < studentScores.length; i++) {
            if (studentScores[i] > max) {
                max = studentScores[i];
            }
        }

        System.out.println("Maximum = " + max);

        // find the minimum
        double min = studentScores[0];

        for (int i = 1; i < studentScores.length; i++) {
            if (studentScores[i] < min) {
                min = studentScores[i];
            }
        }

        System.out.println("Minimum = " + min);

        // print the average
        int sum = 0;

        for (int i = 0; i < studentScores.length; i++) {
            sum += studentScores[i];
        }

        System.out.println("Average = " + sum / studentScores.length);

        // simulate finding the average of 24 student scores 100 times to see
        // the average of the averages
        double simSum = 0, avgSum = 0;

        for (int i = 1; i < studentScores.length; i++) {
            for (int j = 0; j < studentScores.length; j++) {
                studentScores[i] = rand.nextDouble() * 100;
            }

            simSum = 0;

            for (int j = 0; j < studentScores.length; j++) {
                simSum += studentScores[j];
            }

            avgSum += simSum / studentScores.length;
        }

        System.out.println("Average of " + NUM_SIMULATIONS + " averages is "
                + avgSum / NUM_SIMULATIONS);
    }

    public static void dayTwo() {
        int[] numbers = new int[100];

        Random rand = new Random();
        // create 100 elements of random numbers from 50 to 80
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(31) + 50;
        }

        // print all elements of numbers with an enhanced for loop
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        // find the average of numbers with an enhanced loop
        int sum = 0;

        for (int value : numbers) {
            sum += value;
        }

        System.out.println(" ");
        System.out.println("Average = " + (double) sum / numbers.length);

        // create an array of characters from A-Z
        char[] characters = new char[9000];

        for (int i = 0; i < characters.length; i++) {
            characters[i] = (char) (rand.nextInt(26) + 'A');
        }

        for (char c : characters) {
            System.out.print(c);
        }

        System.out.println(" ");

        // create a frequency array to store the number of occurrences of
        // each letter in the characters array
        int[] frequency = new int[26];

        for (char c : characters) {
            frequency[c - 'A']++;
        }

        for (int i : frequency) {
            System.out.print(i + " ");
        }
    }
}