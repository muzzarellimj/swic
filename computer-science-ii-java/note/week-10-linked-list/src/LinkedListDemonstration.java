package semester_two.week_eleven;

import java.util.Random;

public class LinkedListDemonstration {

    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        System.out.println("Size of list: " + myList.length());
        myList.print();

        // Add an element to the list
        myList.add(8);
        System.out.println("Size of list: " + myList.length());
        myList.print();

        // Add to the head of the list
        myList.add(6);
        System.out.println("Size of list: " + myList.length());
        myList.print();

        // Again, add to the head of the list
        myList.add(3);
        System.out.println("Size of list: " + myList.length());
        myList.print();

        // Add to the end of the list
        myList.add(15);
        System.out.println("Size of list: " + myList.length());
        myList.print();

        // Again, add at the end of the list
        myList.add(21);
        System.out.println("Size of list: " + myList.length());
        myList.print();

        // Add in the middle
        myList.add(10);
        System.out.println("Size of list: " + myList.length());
        myList.print();

        // Add a random set of 20 items to the list.
        Random rand = new Random();
        for(int i=0; i<20; i++)
            myList.add(rand.nextInt(25) + 1);
        System.out.println("Size of list: " + myList.length());
        myList.print();

        System.out.println(myList.get(0));
        System.out.println(myList.get(12));
        //System.out.println(myList.get(-2));
        //System.out.println(myList.get(200));

        System.out.println("Value 6 is at " + myList.find(6));
        if(myList.find(12) > -1)
            System.out.println("Value 12 is at " + myList.find(12));
        else
            System.out.println("12 is not in the list.");
        if(myList.find(100) > -1)
            System.out.println("Value 100 is at " + myList.find(100));
        else
            System.out.println("100 is not in the list.");


        System.out.println("Max = " + myList.findMax());
        System.out.println("Min = " + myList.findMin());

        myList.removeIndex(2);
        myList.print();
        myList.removeIndex(-3);
        myList.print();
        myList.removeIndex(5);
        myList.print();
        myList.removeIndex(50);
        myList.print();

        System.out.println("Remove 6...");
        myList.remove(6);
        myList.print();
    }
}