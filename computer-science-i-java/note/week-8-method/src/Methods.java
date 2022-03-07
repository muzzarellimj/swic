package semester_one.week_eight;

public class Methods {

    public static void main(String[] args) {
        System.out.println("Starting in main...");
        System.out.println(Math.pow(2, 10));
        printHeading(555);
        printHeading(802);
        printHeading("Headquarters");
        System.out.println("What did you see?");
    }

    public static void printHeading() {
        System.out.println("Fruit Store");
        System.out.println("Store #431");
        System.out.println("Waco, TX");
    }

    public static void printHeading(int storeNumber) {
        System.out.println("Fruit Store");
        System.out.println("Store #" + storeNumber);
        System.out.println("Waco, TX");
    }

    public static void printHeading(String word) {
        System.out.println("Fruit Store");
        System.out.println("Store " + word);
        System.out.println("Waco, TX");
    }

    public static void printHeading(double value) {
        System.out.println("Fruit Store");
        System.out.println("Store " + value);
        System.out.println("Waco, TX");
    }
}