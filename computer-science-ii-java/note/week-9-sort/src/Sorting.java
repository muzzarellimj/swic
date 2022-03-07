package semester_two.week_nine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The first sorting algorithm we will cover is the Bubble sort.  Take a series of numbers: 8 2 7 9 4 1 6 5 3;
 * Bubble sort will make a comparison between the first two elements and swaps them if necessary. Then it will
 * compare the next two values, then the next two, then the next to, and so on:
 *
 * 8 2 7 9 4 1 6 5 3
 * 2 8 7 9 4 1 6 5 3
 * 2 7 8 9 4 1 6 5 3
 * 2 7 8 4 9 1 6 5 3
 * 2 7 8 4 1 9 6 5 3
 * 2 7 8 4 1 6 9 5 3
 * 2 7 8 4 1 6 5 9 3
 * 2 7 8 4 1 6 5 3 9
 *
 * Then it will do it all over again, if we made any swaps:
 *
 * 2 7 8 4 1 6 5 3 9
 * 2 7 4 8 1 6 5 3 9
 * 2 7 4 1 8 6 5 3 9
 * 2 7 4 1 6 8 5 3 9
 * 2 7 4 1 6 5 8 3 9
 * 2 7 4 1 6 5 3 8 9
 *
 * Then again:
 *
 * 2 4 7 1 6 5 3 8 9
 * 2 4 1 7 6 5 3 8 9
 * 2 4 1 6 7 5 3 8 9
 * 2 4 1 6 5 7 3 8 9
 * 2 4 1 6 5 3 7 8 9
 *
 * Then again:
 *
 * 2 4 1 6 5 3 7 8 9
 * 2 1 4 6 5 3 7 8 9
 * 2 1 4 6 5 3 7 8 9
 * 2 1 4 5 6 3 7 8 9
 * 2 1 4 5 3 6 7 8 9
 *
 * Then again:
 *
 * 2 1 4 5 3 6 7 8 9
 * 1 2 4 5 3 6 7 8 9
 * 1 2 4 5 3 6 7 8 9
 * 1 2 4 3 5 6 7 8 9
 *
 * Then again:
 *
 * 1 2 4 3 5 6 7 8 9
 * 1 2 3 4 5 6 7 8 9
 *
 * Success! The algorithmic analysis of this sort is that the first parse will make (size - 1) comparisons,
 * decrementing with each pass through the algorithm. This is probably the worst sorting algorithm because of how
 * many comparisons it makes. The algorithmic analysis for this sort is O(n) = n^2.
 *
 * The second sorting algorithm we will cover is the selection sort. It takes a series of numbers, compares a
 * particular value with each element in the series, memorizes the index of the lowest value, and makes one swap per
 * pass. The upside is a potential lower number of swaps but the downside is that we cannot exit early. The
 * algorithmic analysis for this sort is O(n) = n^2.
 *
 * The fourth sorting algorithm we will cover is the quick sort.  It takes a series of numbers, partitions it into
 * two data sets, and finds a "pivot point" to compare with each element in the array to make swaps to each side to
 * make one side greater and one side smaller. We then pick another pivot value and restart the process for each
 * subset of data. The algorithmic analysis for this sort is O(n) = nlgn.
 *
 * The fifth sorting algorithm we will cover is the merge sort.  It takes a series of numbers, partitions them into
 * sub-lists until each element is in a sub-list alone, merges them back together, and merges the two sorted lists
 * together. The algorithmic analysis for this sort is O(n) = nlgn.
 *
 * @author Michael Muzzarelli
 */
public class Sorting {

    private static final int SIZE = 100;

    public static void main(String[] args) {
        int[] values = new int[SIZE];
        Scanner scanner = null;

        try {
            scanner = new Scanner(new File("src/main/resources/search/data2000.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the input file!");
            System.exit(0);
        }

        for (int i = 0; i < SIZE; i++) {
            values[i] = scanner.nextInt();
        }

        // print unsorted array
         System.out.println(Arrays.toString(values));

        // time the appropriate sort
        long start = System.nanoTime();
        bozoSort(values);
        long end = System.nanoTime();

        // print the sorted array and the time elapsed
        System.out.println(Arrays.toString(values));
        System.out.println("Time elapsed: " + ((end - start) / Math.pow(10, 9)));

        // verify the list is in sorted order
        if(isSorted(values))
            System.out.println("Sorted!");
        else
            System.out.println("Not in sorted order...");
    }

    private static boolean isSorted(int[] a) {
        for(int i=0; i<a.length-1; i++)
            if(a[i] > a[i+1])
                return false;
        return true;
    }

    public static void selectionSort(int[] a) {
        int minIndex = -1, temp = 0;

        for (int i = 0; i < a.length-1; i++) {
            minIndex = i; //assume first element is smallest
            for (int j = i + 1; j < a.length; j++)
                if (a[j] < a[minIndex])
                    minIndex = j;
            if(minIndex != i) {
                temp = a[minIndex];
                a[minIndex]= a[i];
                a[i] = temp;
            }
        }
    }

    public static void bubbleSort(int[] a) {
        boolean madeSwap = true;
        int passNumber = 0, temp = 0;

        while (madeSwap && passNumber < a.length-1) {
            madeSwap = false;

            for (int index = 0; index < a.length-passNumber-1; index++)
                if(a[index] > a[index+1]) {
                    temp = a[index];
                    a[index] = a[index+1];
                    a[index+1] = temp;
                    madeSwap = true;
                }

            passNumber++;
        }
    }

    public static void insertionSort(int[] a) {
        int temp = 0, index = -1;
        boolean indexFound = false;

        for(int i=1; i<a.length; i++) {
            index = i-1;
            temp = a[i];
            indexFound = false;

            while(!indexFound && index >= 0) {
                if(a[index] <= temp) {
                    indexFound = true;
                } else {
                    a[index + 1] = a[index];
                    index--;
                }
            }
            // if(index + 1 != i)
            a[index + 1] = temp;
        }
    }

    public static void quickSort(int[] a) {
        quick(a, 0, a.length - 1);
    }

    private static void quick(int[] a, int low, int high) {
        int pivotIndex = partition(a, low, high);

        if (low < pivotIndex) {
            quick(a, low, pivotIndex - 1);
        }

        if (pivotIndex < high) {
            quick(a, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] a, int low, int high) {
        int pivotValue = a[low];

        while (low < high) {
            while (low != high && a[high] > pivotValue) {
                high--;
            }

            if (low < high) {
                a[low] = a[high];
                low++;
            }

            while (low != high && a[low] < pivotValue) {
                low++;
            }

            if (low < high) {
                a[high] = a[low];
                high--;
            }
        }

        a[low] = pivotValue;

        return low;
    }

    public static void mergeSort(int[] a) {
        int[] duplicate = a.clone();

        order(duplicate, a, 0, a.length - 1);
    }

    private static void order(int[] source, int[] destination, int low, int high) {
        int middle = -1;

        if (low != high) {
            middle = (low + high) / 2;

            order(destination, source, low, middle);
            order(destination, source, middle + 1, high);

            merge(source, destination, low, middle, high);
        }
    }

    private static void merge(int[] source, int[] destination, int low, int middle, int high) {
        int leftIndex = low;
        int rightIndex = middle + 1;
        int destinationIndex = low;

        do {
            if (source[leftIndex] < source[rightIndex]) {
                destination[destinationIndex] = source[leftIndex];
                leftIndex++;
                destinationIndex++;
            } else {
                destination[destinationIndex] = source[rightIndex];
                rightIndex++;
                destinationIndex++;
            }
        } while (leftIndex <= middle && rightIndex <= high);

        if (leftIndex <= middle) {
            do {
                destination[destinationIndex] = source[leftIndex];
                leftIndex++;
                destinationIndex++;
            } while (leftIndex <= middle);
        } else {
            do {
                destination[destinationIndex] = source[rightIndex];
                rightIndex++;
                destinationIndex++;
            } while (rightIndex <= high);
        }
    }

    public static void bozoSort(int[] a) {
        while (!isSorted(a)) {
            int indexA = (int) (Math.random() * a.length);
            int indexB = (int) (Math.random() * a.length);

            int temporary = a[indexB];
            a[indexB] = a[indexA];
            a[indexA] = temporary;
        }
    }
}