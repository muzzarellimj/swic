package semester_two.week_two;

import semester_two.week_one.Complex;

public class Imaginary extends Complex {

    public Imaginary() {
        super();
    }

    public Imaginary(int b) {
        super(0, b);
    }

    @Override
    public double distance() {
        return getImaginary();
    }

    public Imaginary multiply(int c) {
        return new Imaginary(getImaginary() * c);
    }

    public Imaginary opposite() {
        return this.multiply(-1);
    }
}