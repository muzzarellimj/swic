package semester_two.week_six;

import java.util.Scanner;

/**
 * Fibonacci:   Fn = Fn-1 + Fn+2, F0 = F1 = 1.
 *              Fn+2 = Fn+1 + Fn, F0 = F1 = 1
 *              GENERAL           BASE
 *
 * Factorial:   n! = n(n-1)(n-2)...(3)(2)(1).
 *              n! = n * (n-1)!, 0! = 1!
 *              GENERAL          BASE
 *
 * @author Michael Muzzarelli
 */
public class RecursionDemonstration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // prompt for and show the n-th element in the Fibonacci sequence
        // and do so iteratively and recursively
        System.out.print("Enter a positive value: ");
        int n = scanner.nextInt();

        System.out.println(n + superscript(n) + " element of the Fibonacci " +
                "sequence is " + fib(n));
        System.out.println(n + superscript(n) + " element of the Fibonacci " +
                "sequence is " + fibRec(n));
    }

    private static String superscript(int n) throws IllegalArgumentException {
        if (n < 1) {
            throw new IllegalArgumentException("Invalid value of n!");
        }

        if (n%100 == 11 || n%100 == 12 || n%100 == 13) {
            return "th";
        } else {
            switch (n%10) {
                case 1: return "st";
                case 2: return "nd";
                case 3: return "rd";
                default: return "th";
            }
        }
    }

    // iterative
    private static int fib(int n) {
        int temp = 0, prev = 1, prevPrev = 1;

        if (n == 1 || n == 2) {
            return 1;
        }

        for (int i = 3; i < n; i++) {
            temp = prevPrev;
            prevPrev = prev;
            prev = prevPrev + temp;
        }

        return prev + prevPrev;
    }

    // recursive
    private static int fibRec(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibRec(n -1) + fibRec(n - 2);
        }
    }
}