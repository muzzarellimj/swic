package semester_one.week_five;

import java.util.Random;

public class RandomNumberExample {

    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println(rand.nextInt());
        System.out.println(rand.nextInt());
        System.out.println(rand.nextInt());
        System.out.println(rand.nextInt());
        System.out.println(rand.nextInt());
        System.out.println(rand.nextInt());
        System.out.println(rand.nextInt());
        System.out.println(rand.nextInt());
        System.out.println(rand.nextInt());

        System.out.println(rand.nextDouble());
        System.out.println(rand.nextDouble());
        System.out.println(rand.nextDouble());
        System.out.println(rand.nextDouble());

        // random test scores from 0-100
        System.out.println(rand.nextDouble() * 100);
        System.out.println(rand.nextDouble() * 100);
        System.out.println(rand.nextDouble() * 100);
        System.out.println(rand.nextDouble() * 100);

        // random "test scores" from -100 - 100
        System.out.println(rand.nextDouble() * 200 - 100);
        System.out.println(rand.nextDouble() * 200 - 100);
        System.out.println(rand.nextDouble() * 200 - 100);
        System.out.println(rand.nextDouble() * 200 - 100);

        System.out.println("random die roll for a six-sided die");
        System.out.println(rand.nextInt(6) + 1);
        System.out.println(rand.nextInt(6) + 1);
        System.out.println(rand.nextInt(6) + 1);
        System.out.println(rand.nextInt(6) + 1);
        System.out.println(rand.nextInt(6) + 1);
        System.out.println(rand.nextInt(6) + 1);

        System.out.println("random die roll for a ten-sided die");
        System.out.println(rand.nextInt(10) + 1);
        System.out.println(rand.nextInt(10) + 1);
        System.out.println(rand.nextInt(10) + 1);
        System.out.println(rand.nextInt(10) + 1);
        System.out.println(rand.nextInt(10) + 1);
        System.out.println(rand.nextInt(10) + 1);
        System.out.println(rand.nextInt(10) + 1);
        System.out.println(rand.nextInt(10) + 1);
        System.out.println(rand.nextInt(10) + 1);
        System.out.println(rand.nextInt(10) + 1);

        // on [A, B]: N % (B - A + 1) + A
        System.out.println(rand.nextInt(31) + 50);
        System.out.println(rand.nextInt(31) + 50);
        System.out.println(rand.nextInt(31) + 50);
        System.out.println(rand.nextInt(31) + 50);
        System.out.println(rand.nextInt(31) + 50);
        System.out.println(rand.nextInt(31) + 50);
    }
}