package semester_two.week_one;

import semester_two.week_two.Imaginary;

import java.util.Random;

public class ComplexTest {

    public static void main(String[] args) {
        Complex c = new Complex(3, 4),
                d = new Complex(3),
                e = new Complex(),
                f = new Complex(3, 4);

        System.out.println(c.toString());
        System.out.println(d.toString());
        System.out.println(e.toString());
        System.out.println(f.toString());
        System.out.println(c.equals(f));

        // construct an array of 20 complex numbers
        Complex[] nums = new Complex[20];
        Random rand = new Random();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = new Complex(rand.nextInt(7) - 3, rand.nextInt(7) - 3);
        }

        for (Complex num : nums) {
            System.out.print(num + " ");
        }

        System.out.println("");

        // testing the arithmetic operators
        int i = rand.nextInt(nums.length), j = rand.nextInt(nums.length);
        System.out.println(nums[i] + " + " + nums[j] + " = " + nums[i].add(nums[j]));
        System.out.println(nums[i] + " - " + nums[j] + " = " + nums[i].subtract(nums[j]));
        System.out.println(nums[i] + " * " + nums[j] + " = " + nums[i].multiply(nums[j]));
        System.out.println(nums[i] + " / " + nums[j] + " = " + nums[i].divide(nums[j]));

        // testing the distance formula
        System.out.println("Distance to " + nums[10] + " = " + nums[10].distance());
        System.out.println("Distance to " + nums[9] + " = " + nums[9].distance());
        System.out.println("Distance to " + nums[8] + " = " + nums[8].distance());

        Imaginary imaginaryA = new Imaginary(),
                  imaginaryB = new Imaginary(5);

        System.out.println(imaginaryA + " and " + imaginaryB);
        System.out.println(imaginaryB.add(imaginaryB).add(imaginaryB).add(imaginaryB).add(imaginaryB));
        System.out.println(imaginaryB.multiply(imaginaryB).multiply(imaginaryB).multiply(imaginaryB).multiply(imaginaryB));
        System.out.println(imaginaryB.multiply(imaginaryB));
        System.out.println(imaginaryB.distance());
        System.out.println(imaginaryB.multiply(8));
        System.out.println(imaginaryB.multiply(8).opposite());
    }
}