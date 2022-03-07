package semester_two.week_twelve;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class JavaLinkedListDemonstration {

    public static void main(String[] args) {
        Random random = new Random();
        LinkedList<Integer> score = new LinkedList<>();

        System.out.println("Initially, size = " + score.size());

        for (int i = 0; i < 25; i++) {
            score.add(random.nextInt(101));
        }

        System.out.println(score);
        System.out.println("Size is now " + score.size());

        Object[] value = score.toArray();
        System.out.println(Arrays.toString(value));

        for (int i = 0; i < 100; i+=2) {
            score.remove(new Integer(i));
        }

        System.out.println(score);
    }
}