package semester_two.week_fifteen;

import java.math.BigDecimal;
import java.math.BigInteger;

public class GenericMethods {

    public static void main(String[] args) {
        // demo of calling the generic method, foo()
        foo("Charlie");
        foo(7);
        foo(3.45);
        foo(new BigInteger("234234424321234234"));

        // demo of calling the bounded generic method, number()
        number(8);
        number(new BigInteger("234234634665345"));
        number(8.123);
        number(new BigDecimal("12.31223131233123"));
        number((short) 3);
    }

    // example of using a method for any generic type T
    private static <T> void foo(T value) {
        System.out.println(value);
    }

    // example of placing an upper bound on generic types
    private static <T extends Number> void number(T value) {
        System.out.println(value.intValue());
    }


}