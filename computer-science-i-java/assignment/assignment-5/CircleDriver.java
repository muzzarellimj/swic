package semester_one.week_fourteen.assignment;

import java.util.Arrays;

/**
 * {@link CircleDriver} is a test class of the {@link Circle} class,
 * examining the results of all of the methods within it.
 *
 * @author Michael Muzzarelli
 *
 * Date Created:    11/17/2020
 * Date Modified:   11/18/2020
 */
public class CircleDriver {

    public static void main(String[] args) {

        // test the get and set methods
        Circle set = new Circle();
        set.setCenter(3, 4);
        set.setRadius(3.6);
        System.out.println("Set center: " +
                Arrays.toString(set.getCenter()));
        System.out.println("Set radius: " + set.getRadius());
        set.setCenter(new int[] { 10, 10 });
        System.out.println("Set center: " +
                Arrays.toString(set.getCenter()));
        set.setCenterX(0);
        set.setCenterY(0);
        System.out.println("Set center x: " + set.getCenterX());
        System.out.println("Set center y: " + set.getCenterY());
        System.out.println();

        // test the area method
        Circle area = new Circle(4, 2, 20);
        System.out.println("Area: " + area.area(area));
        System.out.println();

        // test the circumference method
        Circle circ = new Circle(12, 42, 98);
        System.out.println("Circumference: " + circ.circumference(circ));
        System.out.println();

        // test the distanceTo method
        Circle d1 = new Circle(5, 20, 20);
        Circle d2 = new Circle(3, 15, 9);
        System.out.println("Distance between: " + d1.distanceTo(d2));
        System.out.println();

        // test the intersection method
        Circle i1 = new Circle();
        Circle i2 = new Circle(1, 1, 0);
        System.out.println("Intersection: " + i1.intersects(i2));
        System.out.println();

        // test the scale method
        Circle scale = new Circle();
        scale.scale(16);
        System.out.println("Circle scaled: " + scale.getRadius());
        System.out.println();

        // test the setUnitCircle method
        Circle unit = new Circle();
        unit.setRadius(10);
        unit.setCenter(6, 11);
        System.out.println("Circle manipulated: " + unit.toString());
        unit.setUnitCircle();
        System.out.println("Circle set to unit: " + unit.toString());
        System.out.println();

        // test the shift method
        Circle shift = new Circle();
        shift.shift(-5, 5);
        System.out.println("Circle shifted: " +
                Arrays.toString(shift.getCenter()));
        System.out.println();

        // test the toString method
        Circle string = new Circle(3, 3, 3);
        System.out.println("Circle toString: " + string.toString());
        System.out.println();

        // test the equals method
        Circle e1 = new Circle(1, 1 , 15);
        Circle e2 = new Circle(1 ,1 , 15);
        System.out.println("Circles equal: " + e1.equals(e2));
    }
}