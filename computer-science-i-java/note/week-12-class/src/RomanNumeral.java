package semester_one.week_twelve;

/**
 * A class representing Roman numerals from 1 to 4000, inclusive.
 *
 * @author Michael Muzzarelli
 */
public class RomanNumeral {

    private int value;

    public RomanNumeral(String value) {
        value = value.toUpperCase();

        int currentValue = toInt(value.charAt(value.length() - 1));

        for (int i = value.length() - 2; i >= 0; i--) {
            if (toInt(value.charAt(i)) >= toInt(value.charAt(i + 1))) {
                currentValue += toInt(value.charAt(i));
            } else {
                currentValue -= toInt(value.charAt(i));
            }
        }

        // test if the current string 'value' is valid
        if (!value.equals("" + new RomanNumeral(currentValue))) {
            throw new NumberFormatException("Invalid Roman sequence!");
        }

        this.value = currentValue;
    }

    public RomanNumeral(int value) {
        if (value < 1 || value > 4000) {
            throw new IllegalArgumentException("Number is out of bounds!");
        }

        this.value = value;
    }

    public RomanNumeral() {
        this(1);
    }

    private int toInt(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: throw new IllegalArgumentException("Invalid Roman character!");
        }
    }

    public RomanNumeral add(RomanNumeral r) {
        return new RomanNumeral(this.value + r.value);
    }

    public RomanNumeral subtract (RomanNumeral r) {
        return new RomanNumeral(this.value - r.value);
    }

    public RomanNumeral multiply(RomanNumeral r) {
        return new RomanNumeral(this.value * r.value);
    }

    public RomanNumeral divide(RomanNumeral r) {
        return new RomanNumeral(this.value / r.value);
    }

    public RomanNumeral pow(RomanNumeral r) {
        return new RomanNumeral((int) Math.pow(this.value, r.value));
    }

    @Override
    public boolean equals(Object o) {
        return this.value == ((RomanNumeral) o).value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int number = value;

        do {
            if (number >= 1000) {
                builder.append('M');
                number -= 1000;

            } else if (number >= 900) {
                builder.append("CM");
                number -= 900;

            } else if (number >= 500) {
                builder.append('D');
                number -= 500;

            } else if (number >= 400) {
                builder.append("CD");
                number -= 400;

            } else if (number >= 100) {
                builder.append('C');
                number -= 100;

            } else if (number >= 90) {
                builder.append("XC");
                number -= 90;

            } else if (number >= 50) {
                builder.append('L');
                number -= 50;

            } else if (number >= 40) {
                builder.append("XL");
                number -= 40;

            } else if (number >= 10) {
                builder.append('X');
                number -= 10;

            } else if (number >= 9) {
                builder.append("IX");
                number -= 9;

            } else if (number >= 5) {
                builder.append('V');
                number -= 5;

            } else if (number >= 4) {
                builder.append("IV");
                number -= 4;

            } else {
                builder.append('I');
                number -= 1;
            }
        } while (number > 0);

        return builder.toString();
    }
}