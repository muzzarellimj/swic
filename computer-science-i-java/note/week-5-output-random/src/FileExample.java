package semester_one.week_five;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class FileExample {

    public static void main(String[] args) {
        Random rand = new Random();
        PrintWriter toFile = null;

        try {
            toFile = new PrintWriter("numbers.txt");
        } catch (FileNotFoundException e) {
            // anything to react to issues creating file
            System.out.println("Cannot open file.");
            System.exit(0);
        }

        // print 100 random numbers from 1-100
        for (int i = 1; i <= 100; i++) {
            toFile.print(rand.nextInt(100) + 1 + " ");
        }

        toFile.close();

        System.out.println("Numbers.txt created.");
    }
}