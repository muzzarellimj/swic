package semester_two.week_three;

import java.util.ArrayList;
import java.util.Random;

/**
 * An {@link java.util.ArrayList} is an example of a generic data type, which
 * means we can store whatever we want within it; for example, a
 * variably-controlled Apple[]. The criteria for an array list is that
 * OBJECTS must be stored in them; native types cannot be stored within it.
 *
 * Java refers to creating an object from a native type as autoboxing. There
 * is a reverse process referred to as unboxing.
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            scores.add(random.nextInt(50));
        }

        System.out.println(scores);
        System.out.println("There are " + scores.size() + " integers in the " +
                "ArrayList.");

        // remove any 30s in the array
        for (int i = 0; i < 10; i++) {
            scores.remove(new Integer(30 + i));
        }

        System.out.println(scores);
        System.out.println("There are " + scores.size() + " integers in the " +
                "ArrayList.");

        scores.clear();
        System.out.println(scores);
        System.out.println("There are " + scores.size() + " integers in the " +
                "ArrayList.");

        scores.add(3);
        scores.add(5);
        scores.add(7);

        System.out.println(scores);
        System.out.println("There are " + scores.size() + " integers in the " +
                "ArrayList.");

        int value = scores.get(1);
        System.out.println("Value = " + value);
    }
}