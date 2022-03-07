package semester_one.week_three;

import java.text.DecimalFormat;

/**
 * Formatting output.
 *
 * @author Michael Muzzarelli
 * @since September 4, 2020
 */
public class Format {

    public static void main(String[] args) {
        double value = -8.0 / 3, number = 9 / 13.0 * 23456,
                costA = 564654664.80844840, costB = .83;
        int magnitude = 17;
        String name = "Michael";

        DecimalFormat defaultFormatter = new DecimalFormat();
        DecimalFormat formatter = new DecimalFormat("@#,#0.0000");
        DecimalFormat money = new DecimalFormat("$#,##0.00");

        // will print as 2.6666666666666665, this is the default
        System.out.println(value);

        // will print as 2.667, .3f indicates three decimal places and
        // floating point number format
        System.out.printf("%.3f\n", value);

        // will print as 2.667, + provides the positive value
        System.out.printf("%+.3f\n", value);

        // will print as *   -2.667, 10 indicates column width, left justified
        System.out.printf("*%10.3f\n", value);

        // will pint as -2.667, - indicates justification, right justified
        System.out.printf("%-10.3f\n", value);

        System.out.printf("%-10.3f**%+16.2f%n\n", value, number);

        System.out.printf("%-10.3f**%+16.2f%n\n", number, value);

        System.out.printf("%-10.3f*%5d*%+16.2f%n\n", value, magnitude, number);

        System.out.printf("%S%-10.3f*%5d*%+16.2f%n\n",
                name, value, magnitude, number);

        System.out.printf("%s%-10.3f*%5d*%+16.2f%n\n",
                name, value, magnitude, number);

        System.out.printf("%-8.3s%-10.3f*%5d*%+16.2f%n\n",
                name, value, magnitude, number);

        System.out.println(number);
        System.out.println(defaultFormatter.format(number));
        System.out.println(formatter.format(number));
        System.out.println(money.format(costA) + " and " +
                money.format(costB));
    }
}