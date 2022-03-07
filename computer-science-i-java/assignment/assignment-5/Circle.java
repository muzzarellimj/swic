package semester_one.week_fourteen.assignment;

/**
 * The {@link Circle} class represents a circle object with a predefined
 * radius and center coordinate along a two-dimensional plane.
 *
 * @author Michael Muzzarelli
 *
 * Date Created:    11/17/2020
 * Date Modified:   11/18/2020
 */
public class Circle {

    private double radius;

    private int[] center;

    /**
     * Construct a unit circle with a radius of 1 and center point of (0,0).
     */
    public Circle() {
        this.radius = 1;
        this.center = new int[] { 0, 0 };

        System.out.println("Circle plotted at (" + center[0] + "," + center[1]
                + ") with a radius of " + radius);
    }

    /**
     * Construct a {@link Circle} with the provided radius and center.
     *
     * @param radius    the radius of this {@link Circle}.
     * @param center    the coordinate array of this {@link Circle}.
     *
     * @throws IllegalArgumentException if radius is less than 0 or center
     *                                  coordinate array length is not 2.
     */
    public Circle(double radius, int[] center) {
        if (radius < 0) {
            throw new IllegalArgumentException(
                    "Radius must be greater than 0!");
        }

        if (center.length != 2) {
            throw new IllegalArgumentException(
                    "Center coordinate array must only have 2 values!");
        }

        this.radius = radius;
        this.center = center;

        System.out.println("Circle plotted at (" + center[0] + "," + center[1]
                + ") with a radius of " + radius);
    }

    /**
     * Construct a {@link Circle} with the provided radius and center
     * coordinates.
     *
     * @param radius    the radius of this {@link Circle}.
     * @param centerX   the center point x-coordinate of this {@link Circle}.
     * @param centerY   the center point y-coordinate of this {@link Circle}.
     *
     * @throws IllegalArgumentException if radius is less than 0.
     */
    public Circle(double radius, int centerX, int centerY) {
        if (radius < 0) {
            throw new IllegalArgumentException(
                    "Radius must be greater than 0!");
        }

        this.radius = radius;
        this.center = new int[] { centerX, centerY};

        System.out.println("Circle plotted at (" + centerX + "," + centerY
                + ") with a radius of " + radius);
    }

    /**
     * Retrieve the radius of this {@link Circle}.
     *
     * @return  the radius.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Retrieve the center coordinate of this {@link Circle}.
     *
     * @return  the center coordinate, as an int array.
     */
    public int[] getCenter() {
        return center;
    }

    /**
     * Retrieve the center x-coordinate of this {@link Circle}.
     *
     * @return  the center x-coordinate.
     */
    public int getCenterX() {
        return center[0];
    }

    /**
     * Retrieve the center y-coordinate of this {@link Circle}.
     *
     * @return  the center y-coordinate.
     */
    public int getCenterY() {
        return center[1];
    }

    /**
     * Assign the value of {@link Circle#radius} with the provided value.
     *
     * @param r     the desired radius value.
     *
     * @throws IllegalArgumentException if r is not greater than 0.
     */
    public void setRadius(double r) {
        if (r < 0) {
            throw new IllegalArgumentException(
                    "Radius must be greater than 0!");
        }

        this.radius = r;
    }

    /**
     * Assign the value of {@link Circle#center} with the provided array.
     *
     * @param c     the desired center coordinate values.
     *
     * @throws IllegalArgumentException if the center coordinate array length
     *                                  is not equal to 2.
     */
    public void setCenter(int[] c) {
        if (c.length != 2) {
            throw new IllegalArgumentException(
                    "Center coordinate array must only have 2 values!");
        }

        this.center = c;
    }

    /**
     * Assign the value of {@link Circle#center} with the provided values.
     *
     * @param x     the desired x-coordinate value.
     * @param y     the desired y-coordinate value.
     */
    public void setCenter(int x, int y) {
        this.center = new int[] { x, y };
    }

    /**
     * Assign the x-coordinate value of {@link Circle#center} with the
     * provided value.
     *
     * @param x     the desired x-coordinate value.
     */
    public void setCenterX(int x) {
        this.center[0] = x;
    }

    /**
     * Assign the y-coordinate value of {@link Circle#center} with the
     * provided value.
     *
     * @param y     the desired y-coordinate value.
     */
    public void setCenterY(int y) {
        this.center[1] = y;
    }

    /**
     * Calculate the area of a plotted {@link Circle}.
     *
     * @param c     the {@link Circle} to calculate the area of.
     *
     * @return      the area of the {@link Circle}.
     */
    public double area(Circle c) {
        return Math.PI * c.radius * c.radius;
    }

    /**
     * Calculate the circumference of a plotted {@link Circle}.
     *
     * @param c     the {@link Circle} to calculate the circumference of.
     *
     * @return      the circumference of the {@link Circle}.
     */
    public double circumference(Circle c) {
        return 2 * Math.PI * c.radius;
    }

    /**
     * Calculate the distance between two plotted {@link Circle}s.
     *
     * @param c     the {@link Circle} with which to calculate the distance.
     *
     * @return      the distance between the {@link Circle}s.
     */
    public double distanceTo(Circle c) {
        int x = this.center[0] - c.center[0];
        int y = this.center[1] - c.center[1];

        x *= x;
        y *= y;

        return Math.sqrt(x + y);
    }

    /**
     * Check if two plotted {@link Circle}s intersect with one another.
     *
     * @param c     the {@link Circle} with which to check intersection.
     *
     * @return      whether or not the {@link Circle}s intersect.
     */
    public boolean intersects(Circle c) {
        double d = this.distanceTo(c);
        double r = this.radius + c.radius;

        return d <= r;
    }

    /**
     * Scale the radius of this {@link Circle} by the provided value.
     *
     * @param s     the desired scale.
     *
     * @throws IllegalArgumentException if the scale is less than 0.
     */
    public void scale(double s) {
        if (s <= 0) {
            throw new IllegalArgumentException("Scale must be greater than 0!");
        }

        this.radius *= s;
    }

    /**
     * Assign the radius and center coordinate of this {@link Circle} back to
     * the unit circle standard.
     */
    public void setUnitCircle() {
        this.radius = 1;
        this.center = new int[] { 0, 0 };
    }

    /**
     * Shift the center coordinate of this {@link Circle}.
     *
     * @param x     the desired x-coordinate shift.
     * @param y     the desired y-coordinate shift.
     */
    public void shift(int x, int y) {
        this.center[0] += x;
        this.center[1] += y;
    }

    @Override
    public String toString() {
        return "(" + center[0] + "," + center[1] + "), r = " + radius;
    }

    @Override
    public boolean equals(Object obj) {
        Circle c = (Circle) obj;

        return this.radius == c.radius
                && this.center[0] == c.center[0]
                && this.center[1] == c.center[1];
    }
}