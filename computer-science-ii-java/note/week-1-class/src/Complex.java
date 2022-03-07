package semester_two.week_one;

/**
 * A class representing a complex number.
 *
 * @author Michael Muzzarelli
 */
public class Complex {

    private int real, imaginary;

    public Complex() {
        this.real = 0;
        this.imaginary = 0;
    }

    public Complex(int real) {
        this.real = real;
        this.imaginary = 0;
    }

    public Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void setReal(int value) {
        this.real = value;
    }

    public void setImaginary(int value) {
        this.imaginary = value;
    }

    public int getReal() {
        return real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public Complex add(Complex c) {
        return new Complex(this.real + c.real, this.imaginary + c.imaginary);
    }

    public Complex subtract(Complex c) {
        return new Complex(this.real - c.real, this.imaginary - c.imaginary);
    }

    public Complex multiply(Complex c) {
        return new Complex(this.real * c.real - this.imaginary * c.imaginary,
                this.real * c.imaginary + this.imaginary * c.real);
    }

    public Complex divide(Complex c) {
        int temp = c.real * c.real + c.imaginary * c.imaginary;

        return new Complex((this.real * c.real + this.imaginary * c.imaginary) / temp,
                (this.real * c.imaginary + this.imaginary * c.real) / temp);

    }

    public double distance() {
        return Math.hypot(real, imaginary);
    }

    @Override
    public String toString() {
        if (real == 0 && imaginary == 0) {
            return "0";

        } else if (imaginary == 0) {
            return real + "";

        } else if (real == 0 && imaginary == 1) {
            return "i";

        } else if (real == 0 && imaginary == -1) {
            return "-i";

        } else if (real == 0) {
            return imaginary + "i";

        } else if (imaginary < -1) {
            return real + (imaginary + "i");

        } else if (imaginary == -1) {
            return real + "-i";

        } else if (imaginary == 1) {
            return real + "+i";

        } else {
            return real + "+" + imaginary + "i";
        }
    }

    @Override
    public boolean equals(Object o) {
        return  this.real == ((Complex) o).real &&
                this.imaginary == ((Complex) o).imaginary;
    }
}