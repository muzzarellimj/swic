package semester_one.week_three;

/**
 * There are a number of operators available including arithmetic,
 * relational, unary, logical, and compound assignment, among others.
 *
 * Arithmetic operators:
 *      + addition
 *      - subtraction
 *      * multiplication
 *      / division, which falls into two categories:
 *          - real division: when either operand is real (double or float)
 *          - integer division: when both operators are integers, standard,
 *            bound within integers because of how bits are formed
 *      % modulus, which keeps within a restricted set of domain values
 *          - 10 % 8, consider all of the values of 8 that are in 10 and what
 *                    is left over
 *            10 % 8 = 2
 *          - 80 % 6 = 2
 *
 * Relational operators:
 *      > greater than
 *      < less than
 *      >= greater than or equal to
 *      <= less than or equal to
 *      == equal to
 *      != not equal to
 *
 * Unary operators:
 *      ++ post- or pre-increment operator, x++ or ++x
 *      -- post- or pre-decrement operator, x-- or --x
 *      - negative, retrieve the negative value of (-B)
 *      + positive, retrieve the positive value of (+B)
 *
 * Logical operators:
 *      && and
 *      || or
 *      ! not
 *      ^ exclusive or, only one is true
 *
 * Compound assignment operators:
 *      x = x + y  ->  x += y
 *      z = z - 3  ->  z -= 3
 *      y = 2 * y  ->  y *= 2
 *      r = r / q  ->  r /= q
 *      s = s % b  ->  s %= b
 *
 * Ternary operators (or conditional):
 *      - used for selection statements, in lieu of if...else statements
 *      a ? b : c;
 *
 * @author Michael Muzzarelli
 * @since September 3, 2020
 */
public class Operators {

    public static void main(String[] args) {
        int x = 5, y = 2, z = 12;

        System.out.println("ARITHMETIC OPERATORS:");
        System.out.println(x + y);
        System.out.println(x - z);
        System.out.println(x * z);
        System.out.println(z / x);
        System.out.println(z / y);

        System.out.println("REAL DIVISION:");
        System.out.println((double) z / (double) x); // typecasting
        System.out.println((double) z / x); // mixed mode expression
        System.out.println(z / (double) x);
        System.out.println((double) (z / x));

        System.out.println("MODULUS OPERATORS:");
        System.out.println(z % x);
        System.out.println(x % z);
        System.out.println(x % y);
        System.out.println((5 * z) % (y + 1));

        System.out.println("RELATIONAL OPERATORS:");
        System.out.println(z < x);
        System.out.println(x <= x);
        System.out.println(y >= 0);
        System.out.println(z + 10 > 6*x);
        System.out.println(y != x);
        System.out.println(3*y == x+1);

        System.out.println("INCREMENTAL AND DECREMENTAL OPERATORS:");
        System.out.println("x = " + x);
        x++;
        ++x;
        System.out.println("x = " + x);
        z = ++x;
        System.out.println("x = " + x + ", z = " + z);
        z = x++;
        System.out.println("x = " + x + ", z = " + z);
        y = ++x + --z;
        System.out.println("x = " + x + ", y = " +  y + ", z = " + z);
        y = 2*(z--) + 3*x++;
        System.out.println("x = " + x + ", y = " +  y + ", z = " + z);
        y = (z--)%4 + (++x)%5;
        System.out.println("x = " + x + ", y = " +  y + ", z = " + z);

        System.out.println("COMPOUND ASSIGNMENT OPERATORS:");
        z -= 10; // z = z - 10;
        x += z; // x = x + z;
        y *= 2; // y = y * 2;
        x %= 2; // x = x % 2;
        z /= 3; // z = z / 3;
        System.out.println("x = " + x + ", y = " +  y + ", z = " + z);

        System.out.println("TERNARY OPERATORS:");

    }
}