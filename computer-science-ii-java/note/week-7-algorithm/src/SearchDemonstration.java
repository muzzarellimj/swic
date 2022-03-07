package semester_two.week_seven;

import semester_two.week_eight.BinarySearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SearchDemonstration {

    public static void main(String[] args) {
        int[] v1 = { 2, 4, 6, 8, 10 };
        int[] v2 = { 1, 2, 3, 4, 5, 6, 7, 8 };

//        System.out.println(Search.sequentialSearch(v1, 0));
//        System.out.println(Search.sequentialSearch(v1, 8));
//        System.out.println(Search.sequentialSearch(v2, 22));
//        System.out.println(Search.sequentialSearch(v2, 8));
//        System.out.println(Search.sequentialSearch(v2, 1));
//        System.out.println(Search.sequentialSearch(v2, 5));

//        System.out.println("--------------------");

        // read in the 10,000 elements from data.txt
        Scanner fromFile = null;

        try {
            fromFile = new Scanner(
                    new File("src/main/resources/search/data8000.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Data file not found!");
            System.exit(0);
        }

        // read in the file elements
        int[] v3 = new int[8000];

        for (int i = 0; i < v3.length; i++) {
            v3[i] = fromFile.nextInt();
        }

        // sort the data in the array
        Arrays.sort(v3);

        // search the file
//        System.out.println(Search.sequentialSearch(v3, 15000));
//        System.out.println(Search.sequentialSearch(v3, 5255));
//        System.out.println(Search.sequentialSearch(v3, 11111));
//        System.out.println(Search.sequentialSearch(v3, 3));
//        System.out.println(Search.sequentialSearch(v3, 19));
//        System.out.println(Search.sequentialSearch(v3, 10723));
//        System.out.println(Search.sequentialSearch(v3, 46575));

//        System.out.println("--------------------");

        // to time methods:
//        long start = System.nanoTime();

        Random random = new Random();
        int numToFind = random.nextInt(10000) + 1;
        System.out.println("Searching for " + numToFind);
        int index = BinarySearch.search(v3, numToFind);

        if (index > -1) {
            System.out.println(numToFind + " found at index " + index);
        } else {
            System.out.println(numToFind + " not found.");
        }
//        long end = System.nanoTime();

//        System.out.println("Elapsed time: " + (end - start) / Math.pow(10, 9)
//                + " seconds.");

        fromFile.close();
    }
}