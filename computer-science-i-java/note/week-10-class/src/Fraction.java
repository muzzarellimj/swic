package semester_one.week_ten;

/**
 * Fraction class allows programmers to use fractions, like 1/3.
 */
public class Fraction {

    private int numerator, denominator;

    /**
     * Construct an object to represent a fraction.
     * @param numerator     the fraction numerator.
     * @param denominator   the fraction denominator.
     * @throws IllegalArgumentException if the denominator is zero.
     */
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }

        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public Fraction(int numerator) {
        this(numerator, 1);
    }

    public Fraction(double number) {
        /*this(Integer.parseInt(String.valueOf(number).replace(".", ""),
             (int)Math.pow(10, String.valueOf(number).length()-
                               String.valueOf(number).indexOf('.') - 1)));
        */
        String num = String.valueOf(number);
        int index = num.indexOf(".");

        numerator = Integer.parseInt(num.replace(".",""));
        denominator = (int)Math.pow(10,num.length()-index-1);
        simplify();
    }

    public Fraction() {
        this.numerator = 1;
        this.denominator = 9;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        simplify();
    }

    public void setDenominator(int denominator) throws IllegalArgumentException {
        if(denominator == 0)
            throw new IllegalArgumentException("cant set denominator equal to zero.");
        this.denominator = denominator;
        simplify();
    }

    // functionality
    public Fraction multiply(Fraction frac) {
        int num = this.numerator * frac.numerator;
        int den = this.denominator * frac.denominator;
        Fraction prod = new Fraction(num, den);
        return prod;
        // return new Fraction(num, den);
        // return new Fraction(this.numerator * frac.numerator,
        //                    this.denominator * frac.denominator);
    }

    public Fraction divide(Fraction frac) {
        int num = this.numerator * frac.denominator;
        int den = this.denominator * frac.numerator;
        Fraction quotient = new Fraction(num, den);
        return quotient;
    }

    // a/b + c/d = (ad + cb)/(bd)
    public Fraction add(Fraction frac) {
        int num = this.numerator * frac.denominator +
                frac.numerator * this.denominator;
        int den = this.denominator * frac.denominator;
        Fraction sum = new Fraction(num, den);
        return sum;
        // return new Fraction( this.numerator * frac.denominator +
        //          frac.numerator * this.denominator,
        //          this.denominator * frac.denominator);
    }

    public Fraction subtract(Fraction frac) {
        int num = this.numerator * frac.denominator -
                frac.numerator * this.denominator;
        int den = this.denominator * frac.denominator;
        Fraction diff = new Fraction(num, den);
        return diff;
    }

    public Fraction pow(int exponent) {
        return new Fraction((int)Math.pow(numerator, exponent),
                (int)Math.pow(denominator, exponent));
        /*

        Fraction f = new Fraction(numerator, denominator);
        Fraction prod = new Fraction(1, 1);
        for(int i=1; i<=exponent; i++)
            prod = prod.multiply(f);
        */
    }

    // returns -1 if less, 0 if equal, 1 is greater
    public int compareTo(Fraction f) {
        double cur = (double)numerator / denominator;
        double pas = (double)(f.numerator) / f.denominator;
        if(cur < pas)
            return -1;
        else if(cur > pas)
            return 1;
        return 0;
    }

    @Override
    public String toString() {
        if (denominator == 1) {
//            return "" + numerator;
            return String.valueOf(numerator);
        }

        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object f) {
        return this.numerator == ((Fraction) f).numerator &&
                this.denominator == ((Fraction) f).denominator;
    }

    private void simplify() {
        if(numerator == 0)
            denominator = 1;
        else {
            if(denominator < 0) {
                numerator = -numerator; // numerator *= -1;
                denominator = -denominator;
            }
            int gcf = (Math.abs(numerator) > denominator)?
                    denominator:Math.abs(numerator);
            while(numerator%gcf!=0 || denominator%gcf!=0)
                gcf--;

            if(gcf != 1) {
                numerator /= gcf;
                denominator /= gcf;
            }
        }
    }

    public double doubleValue() {
        return (double) numerator / denominator;
    }
}