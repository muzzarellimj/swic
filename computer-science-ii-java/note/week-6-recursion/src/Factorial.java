package semester_two.week_six;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0;

        System.out.print("Enter a value for n: ");
        n = input.nextInt();

        System.out.println(n + "! = " + factorial(n));
        System.out.println(n + "! = " + factorialRec(n));
    }

    private static int factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Value must be greater than 0!");
        } else if (n == 0) {
            return 1;
        }

        int product = n;

        for (int i = n - 1; i > 1; i--) {
            product *= i;
        }

        return product;
    }

    private static BigInteger factorialRec(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Value must be greater than 0!");
        } else if (n == 0) {
            return BigInteger.ONE;
        }

        return new BigInteger(String.valueOf(n)).multiply(factorialRec(n - 1));
    }
}