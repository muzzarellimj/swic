package semester_two.week_fourteen;

import semester_two.week_one.Complex;

import java.math.BigInteger;
import java.util.Random;

public class GenericDemonstration {

    public static void main(String[] args) {
        Random random = new Random();

        // raw use
//        Box b1 = new Box(3);
//        Box b2 = new Box(8);
//        Box b3 = new Box(12);

        // proper use
        Box<Integer> b1 = new Box<>(3);
        Box<Integer> b2 = new Box<>(8);
        Box<Integer> b3 = new Box<>(12);
        Box<String> b4 = new Box<>("Java");
        Box<Character> b5 = new Box<>('+');
        Box<Complex> b6 = new Box<>(new Complex(3, 5));
        Box<BigInteger> b7 = new Box<>(new BigInteger("128381238123831238123"));

        Box<Complex>[] arrayOfBoxes = new Box[20];
        for (int i = 0; i < arrayOfBoxes.length; i++) {
            arrayOfBoxes[i] = new Box<>(new Complex(random.nextInt(13 - 6), random.nextInt(13 - 6)));
        }

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        System.out.println(b5);
        System.out.println(b6);
        System.out.println(b7);

        for (Box<Complex> c : arrayOfBoxes) {
            System.out.println(c);
        }

        String second = b4.getData();
        int myInt = b1.getData();
        Complex c = arrayOfBoxes[3].getData();

        System.out.println(second);
        System.out.println(myInt);
        System.out.println(c);
    }
}