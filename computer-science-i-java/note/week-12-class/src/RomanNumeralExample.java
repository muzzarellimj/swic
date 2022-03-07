package semester_one.week_twelve;

public class RomanNumeralExample {

    public static void main(String[] args) {
        RomanNumeral r1 = new RomanNumeral(),
                     r2 = new RomanNumeral(345),
                     r3 = new RomanNumeral("DCXCIV"),
                     r4 = new RomanNumeral("dcXCiv"),
                     //r5 = new RomanNumeral("MP"),
                     //r6 = new RomanNumeral(4002),
                     // r7 = new RomanNumeral("IIII"),
                     r8 = new RomanNumeral("MMCDLXXXVII"),
                     // r9 = new RomanNumeral("IM"), // 999 = CMXCIX
                     r10 = new RomanNumeral("CMXCIX");

        System.out.println(r1 + " " + r2 + " " + r3 + " " +
                r4 + " " +
                r8 + " " + r10);
        System.out.println(r3.equals(r4));
        System.out.println(r3.add(r4));
        System.out.println(r8.subtract(r3));
        System.out.println(new RomanNumeral(4).multiply(new RomanNumeral(12)));
        System.out.println(r3.divide(r2));
        System.out.println(new RomanNumeral(5).pow(new RomanNumeral()));
    }
}