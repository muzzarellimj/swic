package semester_one.week_ten;

public class ClassDemonstration {

    public static void main(String[] args) {
        Fraction f2 = new Fraction(3,6), f1 = new Fraction(),
                f3 = new Fraction(0,-2), f4 = new Fraction (12,8),
                f5 = new Fraction(-27,36), f6 = new Fraction(18,-26),
                f7 = new Fraction(5, 3), f8 = new Fraction(25,-5),
                f9 = new Fraction(6), f10 = null,
                f11 = new Fraction(13.1842), f12 = new Fraction(-.00821);
        try {
            f10 = new Fraction(3,0);
        }
        catch(IllegalArgumentException e) {

        }

        System.out.println("f1 = " + f1 + ", f2 = " + f2 + ", f3 = " + f3 +
                ", f4 = " + f4 + ", f5 = " + f5 + ", f6 = " +
                f6 + ", f7 = " + f7 + ", f8 = " + f8 + ", f9 = " +
                f9 + ", f10 = " + f10 + ", f11 = " + f11 +
                ", f12 = " + f12);

        int d = f11.getDenominator();
        System.out.println(d);
        f6.setDenominator(12);
        System.out.println(f6);

        System.out.println(f6.multiply(f5)); // f6 * f5
        System.out.println(f6.divide(f5));
        // Programmer would need try/catch block
        // System.out.println(f6.divide(f3));
        System.out.println(f6.add(f5));
        System.out.println(f6.subtract(f5));
        // System.out.println(multiply(f6, f5));
        System.out.println(f4.subtract(f2).add(f5).multiply(f6.divide(f8)));
        System.out.println(f4.multiply(f4));
        System.out.println(f4.pow(5));
        System.out.println(f4.compareTo(f5));

        Fraction a = new Fraction(5, 4);
        Fraction b = new Fraction(5, 4);

        System.out.println(a.equals(b));
        System.out.println(a.doubleValue());
    }
}