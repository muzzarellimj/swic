package semester_one.week_eight;

public class StringMethods {

    private static final int OFFSET = 3;

    public static void main(String[] args) {
        String message = "This is an excellent day.";

        System.out.println("Number of words: " + getWordCount(message));
        System.out.println("Number of characters: " + getCharCount(message));
        System.out.println("Number of capitals: " + getCapCount(message));
        System.out.println("Number of lowercase: " + getLowCount(message));
        System.out.print("Reverse: ");
        printReverse(message);
        System.out.println();
        System.out.println("Reverse: " + reverse(message));
        System.out.println("Encrypted message: " + encrypt(message));
        System.out.println("Encrypted message: " + encrypt2(message));
        System.out.println("Sum of ASCII values: " + sum(message));
    }

    public static int getWordCount(String message) {
        int wordCount = 0;

        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                wordCount++;
            }
        }

        return wordCount + 1;
    }

    public static int getCharCount(String message) {
        return message.length();
    }

    public static int getCapCount(String message) {
        int capCount = 0;

        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') {
                capCount++;
            }
        }

        return capCount;
    }

    public static int getLowCount(String message) {
        int lowCount = 0;

        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) >= 'a' && message.charAt(i) <= 'z') {
                lowCount++;
            }
        }

        return lowCount;
    }

    public static void printReverse(String message) {
        for (int i = message.length() - 1; i >= 0; i--) {
            System.out.print(message.charAt(i));
        }
    }

    public static String reverse(String message) {
        StringBuilder builder = new StringBuilder();

        for (int i = message.length() - 1; i >= 0; i--) {
            builder.append(message.charAt(i));
        }

        return builder.toString();
    }

    public static String encrypt(String message) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            builder.append((char) (message.charAt(i) + OFFSET));
        }

        return builder.toString();
    }

    public static String encrypt2(String message) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            builder.append((char) (2 * message.charAt(i) - OFFSET));
        }

        return builder.toString();
    }

    // sum will add all of the ASCII values
    public static int sum(String message) {
        int value = 0;

        for (int i = 0; i < message.length(); i++) {
            value += message.charAt(i);
        }

        return value;
    }
}