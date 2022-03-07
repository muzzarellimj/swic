package semester_two.week_sixteen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Name:            Michael Muzzarelli
 * Date Created:    May 2, 2021
 * Date Modified:   May 5, 2021
 * Description:     Parses a series of commands that instruct a robot arm in
 *                  how to manipulate blocks that lie on a flat table.
 *
 * Full disclosure: I found an online resource that helped guide me through
 * this project, which is where the initial() method is borrowed from:
 * https://github.com/AhmedHani/Online-Judges-Problems-SourceCode/blob/master/UVa/101%20-%20The%20Blocks%20Problem.java
 * I also could not seem to get UVA Online Judge to accept my registration so
 * I could not try for the extra credit.
 */
public class Blocks {

    private static Stack<Integer>[] blocks;
    private static int[] position;

    /**
     * The application entry point.
     *
     * @param args  the application entry arguments.
     *
     * @throws FileNotFoundException    if the input file is not found.
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));

        int count = Integer.parseInt(scanner.nextLine());
        blocks = new Stack[count];
        position = new int[count];

        for (int i = 0; i < count; i++) {
            blocks[i] = new Stack<>();
            blocks[i].push(i);
            position[i] = i;
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.equalsIgnoreCase("quit")) {
                break;
            }

            String[] components = line.split(" ");

            String firstOperation = components[0];
            int a = Integer.parseInt(components[1]);
            String secondOperation = components[2];
            int b = Integer.parseInt(components[3]);

            if (firstOperation.equalsIgnoreCase("move")) {
                if (secondOperation.equalsIgnoreCase("onto")) {
                    moveOnto(a, b);

                } else if (secondOperation.
                        equalsIgnoreCase("over")) {
                    moveOver(a, b);
                }

            } else if (firstOperation.equalsIgnoreCase("pile")) {
                if (secondOperation.equalsIgnoreCase("onto")) {
                    pileOnto(a, b);

                } else if (secondOperation.
                        equalsIgnoreCase("over")) {
                    pileOver(a, b);
                }
            }
        }

        for (int i = 0; i < count; i++) {
            System.out.println(print(i));
        }

        System.exit(0);
    }

    /**
     * Returns any blocks on top of blocks a and b back to their original
     * positions, and then moves block a on top of block b.
     *
     * @param a     block A.
     * @param b     block B.
     */
    private static void moveOnto(int a, int b) {
        move(b);
        moveOver(a, b);
    }

    /**
     * Returns any blocks on top of a to their original positions, then moves
     * block a over the stack of those that contain b.
     *
     * @param a     block A.
     * @param b     block B.
     */
    private static void moveOver(int a, int b) {
        move(a);
        blocks[position[b]].push(blocks[position[a]].pop());
        position[a] = position[b];
    }

    /**
     * Returns any blocks on top of b to their original positions, then moves
     * all blocks above and including block a onto block b.
     *
     * @param a     block A.
     * @param b     block B.
     */
    private static void pileOnto(int a, int b) {
        move(b);
        pileOver(a, b);
    }

    /**
     * Piles all blocks above and including block a over the stack of those
     * that contain b. No blocks are returned to their original positions in
     * this case. The order of the blocks above a is kept.
     *
     * @param a     block A.
     * @param b     block B.
     */
    private static void pileOver(int a, int b) {
        Stack<Integer> pile = new Stack<>();

        while (blocks[position[a]].peek() != a) {
            pile.push(blocks[position[a]].pop());
        }

        pile.push(blocks[position[a]].pop());

        while (!pile.isEmpty()) {
            int temp = pile.pop();

            blocks[position[b]].push(temp);
            position[temp] = position[b];
        }
    }

    /**
     * Move the blocks above a particular block.
     *
     * @param block     the particular block to move.
     */
    private static void move(int block) {
        while (blocks[position[block]].peek() != block) {
            initial(blocks[position[block]].pop());
        }
    }

    /**
     *
     *
     * @param block
     */
    private static void initial(int block) {
        while (!blocks[block].isEmpty()) {
            initial(blocks[block].pop());
        }

        blocks[block].push(block);
        position[block] = block;
    }

    /**
     * Print the blocks of a particular stack at a particular index.
     *
     * @param index     the index to print.
     *
     * @return          the resulting string.
     */
    private static String print(int index) {
        StringBuilder result = new StringBuilder();

        while (!blocks[index].isEmpty()) {
            result.insert(0, " " + blocks[index].pop());
        }

        result.insert(0, index + ":");

        return result.toString();
    }
}