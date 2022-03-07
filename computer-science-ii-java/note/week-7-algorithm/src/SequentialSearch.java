package semester_two.week_seven;

/**
 * Sequential search: O(n) = n
 *
 * n = 2000, base case times:
 *
 *
 */
public class SequentialSearch {

    /**
     * Return the first index of the value searched.
     *
     * @param n             the input data.
     * @param searchValue   the value to search for.
     *
     * @return              the first index of the value searched.
     */
    public static int sequentialSearch(int[] n, int searchValue) {
        boolean found = false;
        int index = 0;

        long start = System.nanoTime();

        do {
            if (n[index] == searchValue) {
                found = true;
            } else {
                index++;
            }
        } while (!found && index < n.length);

        long end = System.nanoTime();

        System.out.println("In search method: " + (end - start) /
            Math.pow(10, 9));

        return (index >= n.length) ? -1 : index;
    }
}