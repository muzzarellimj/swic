package semester_one.week_thirteen;

import semester_one.week_ten.Fraction;

import java.math.BigInteger;
import java.util.Random;

public class ObjectArrays {

    private static Random random = new Random();

    public static void main(String[] args) {
        dayTwo();
    }

    private static void dayOne() {
        Fraction[] ratio = new Fraction[30];

        for (int i = 0; i < ratio.length; i++) {
            ratio[i] = new Fraction(random.nextInt(100), random.nextInt(100));
        }

        for (Fraction f : ratio) {
            System.out.println(f + " ");
        }
    }

    private static void dayTwo() {
        StringBuilder randomDigitString = new StringBuilder();
        int strLength = 0;

        // create an array of booleans
        boolean[] beenClicked = new boolean[9];
        for (boolean b : beenClicked)
            System.out.print(b + " ");

        System.out.println();

        // create an array of a dozen BigIntegers of random lengths from 12-50
        // random digits
        BigInteger[] numbers = new BigInteger[12];

        for (int i = 0; i < numbers.length; i++) {
            strLength = random.nextInt(39) + 12;
            for (int j = 0; j < strLength; j++) {
                randomDigitString.append(random.nextInt(10));
            }
            numbers[i] = new BigInteger(randomDigitString.toString());
            randomDigitString = randomDigitString.delete(0,
                    randomDigitString.length());
        }

        for (BigInteger bi : numbers)
            System.out.print(bi + " ");

        System.out.println();

        // find the sum of all the big integers in the array
        BigInteger sum = BigInteger.ZERO;
        BigInteger prod = BigInteger.ONE;

        for (BigInteger bi : numbers) {
            sum = sum.add(bi);
            prod = prod.multiply(bi);
        }

        System.out.println("Sum = " + sum);
        System.out.println("Product = " + prod);

        for (BigInteger bi : numbers) {
            System.out.print(bi + " + ");
        }
    }
}