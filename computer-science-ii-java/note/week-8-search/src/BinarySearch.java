package semester_two.week_eight;

/**
 * Binary search takes a series of values and splits them in half by finding
 * the low point, the high point, and calculating the midpoint using integer
 * division.
 *
 *  1. Find the low and high points.
 *  2. Calculate the midpoint using integer division.
 *  3. Is value[midpoint] equal to our search element?
 *  4. If #3 is not true, disregard half the list by finding if the search
 *     element is greater than or less than the value[midpoint]. If search
 *     element > value[midpoint], make low = midpoint + 1. If search element
 *     < value[midpoint], make high = midpoint - 1.
 *  5. Repeat steps 2 through 5 until we either: a) find the search element,
 *     or b) if low > high.
 *
 * @author Michael Muzzarelli
 */
public class BinarySearch {

    public static int search(int[] n, int value) {
        long start = System.nanoTime();
        boolean stop = false;

        int low = 0;
        int mid = -1;
        int high = n.length - 1;
        int index = -1;

        do {
            if (value == n[low]) {
                stop = true;
                index = low;
            } else if (value == n[high]) {
                stop = true;
                index = high;
            } else {
                mid = (low + high) / 2;

                if (value == n[mid]) {
                    stop = true;
                    index = mid;
                } else if (value > n[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        } while (low <= high && !stop);

        long end = System.nanoTime();

        System.out.println("Elapsed time in binary search: "
                + (end - start) / Math.pow(10, 9) + " seconds.");

        return index;
    }
}