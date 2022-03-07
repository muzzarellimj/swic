package semester_one.week_ten.assignment;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Author:          Michael Muzzarelli
 * Date Created:    10/23/2020
 * Last Modified:   10/27/2020
 * Description:     Accept an input path and filename, read the input file,
 *                  translate the text to Morse code, accept an output path
 *                  and filename, output the translated Morse code to a file,
 *                  and optionally display it in a {@link JOptionPane}.
 */
public class MorseCode {

    private final static char DASH = (char) 8212;
    private final static char DOT = (char) 8226;

    /**
     * The entry point to the application.
     *
     * @param args  entry arguments.
     */
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        String inputFilePath = null, outputFilePath = null;
        String inputFileName = null, outputFileName = null, word = null;
        Scanner input = null;
        PrintWriter output = null;
        int wordCount = 0, viewCode = 0;

        inputFilePath = JOptionPane.showInputDialog(null,
                "Where is the input file located?",
                "Morse Code Translator",
                JOptionPane.PLAIN_MESSAGE);

        inputFileName = JOptionPane.showInputDialog(null,
                "What is the name of the input file?",
                "Morse Code Translator",
                JOptionPane.PLAIN_MESSAGE);

        do {
            try {
                input =
                        new Scanner(new File(inputFilePath, inputFileName));
            } catch (FileNotFoundException e) {
                inputFilePath = JOptionPane.showInputDialog(null,
                        "File not found! Where is the input file located?",
                        "Morse Code Translator",
                        JOptionPane.PLAIN_MESSAGE);

                inputFileName = JOptionPane.showInputDialog(null,
                        "What is the name of the input file?",
                        "Morse Code Translator",
                        JOptionPane.PLAIN_MESSAGE);
            }
        } while (input == null);

        while (input.hasNext()) {
            wordCount++;

            word = input.next();

            builder.append(translate(word)).append("          ");

            if (wordCount % 3 == 0) {
                builder.append("\n");
            }
        }

        outputFilePath = JOptionPane.showInputDialog(null,
                "Where should the output file be saved?",
                "Morse Code Translator",
                JOptionPane.PLAIN_MESSAGE);

        outputFileName = JOptionPane.showInputDialog(null,
                "What would you like to name the output file?",
                "Morse Code Translator",
                JOptionPane.PLAIN_MESSAGE);

        do {
            try {
                output =
                        new PrintWriter(new File(outputFilePath,
                                outputFileName));
            } catch (FileNotFoundException e) {
                outputFilePath = JOptionPane.showInputDialog(null,
                        "Where should the output file be saved?",
                        "Morse Code Translator",
                        JOptionPane.PLAIN_MESSAGE);

                outputFileName = JOptionPane.showInputDialog(null,
                        "What would you like to name the output file?",
                        "Morse Code Translator",
                        JOptionPane.PLAIN_MESSAGE);
            }
        } while (output == null);

        output.print(builder);

        viewCode = JOptionPane.showConfirmDialog(null,
                "The Morse code translation has been output to file " +
                        outputFileName + ". Would you like to view the code?",
                "Morse Code Translator", JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (viewCode == JOptionPane.YES_OPTION) {
            showCode(builder);
        } else if (viewCode == JOptionPane.NO_OPTION) {
            System.exit(0);
        }

        input.close();
        output.close();
    }

    /**
     * Translate a word to Morse code.
     *
     * @param word  the word to translate.
     *
     * @return      the {@link StringBuilder} object containing the
     *              translated word.
     */
    public static StringBuilder translate(String word) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            switch (word.charAt(i)) {
                case 'A':
                case 'a':
                    builder.append(DOT).append(DASH);
                    break;

                case 'B':
                case 'b':
                    builder.append(DASH).append(DOT).append(DOT).append(DOT);
                    break;

                case 'C':
                case 'c':
                    builder.append(DASH).append(DOT).append(DASH).append(DOT);
                    break;

                case 'D':
                case 'd':
                    builder.append(DASH).append(DOT).append(DOT);
                    break;

                case 'E':
                case 'e':
                    builder.append(DOT);
                    break;

                case 'F':
                case 'f':
                    builder.append(DOT).append(DOT).append(DASH).append(DOT);
                    break;

                case 'G':
                case 'g':
                    builder.append(DASH).append(DASH).append(DOT);
                    break;

                case 'H':
                case 'h':
                    builder.append(DOT).append(DOT).append(DOT).append(DOT);
                    break;

                case 'I':
                case 'i':
                    builder.append(DOT).append(DOT);
                    break;

                case 'J':
                case 'j':
                    builder.append(DOT).append(DASH).append(DASH).append(DASH);
                    break;

                case 'K':
                case 'k':
                    builder.append(DASH).append(DOT).append(DASH);
                    break;

                case 'L':
                case 'l':
                    builder.append(DOT).append(DASH).append(DOT).append(DOT);
                    break;

                case 'M':
                case 'm':
                    builder.append(DASH).append(DASH);
                    break;

                case 'N':
                case 'n':
                    builder.append(DASH).append(DOT);
                    break;

                case 'O':
                case 'o':
                    builder.append(DASH).append(DASH).append(DASH);
                    break;

                case 'P':
                case 'p':
                    builder.append(DOT).append(DASH).append(DASH).append(DOT);
                    break;

                case 'Q':
                case 'q':
                    builder.append(DASH).append(DASH).append(DOT).append(DASH);
                    break;

                case 'R':
                case 'r':
                    builder.append(DOT).append(DASH).append(DOT);
                    break;

                case 'S':
                case 's':
                    builder.append(DOT).append(DOT).append(DOT);
                    break;

                case 'T':
                case 't':
                    builder.append(DASH);
                    break;

                case 'U':
                case 'u':
                    builder.append(DOT).append(DOT).append(DASH);
                    break;

                case 'V':
                case 'v':
                    builder.append(DOT).append(DOT).append(DOT).append(DASH);
                    break;

                case 'W':
                case 'w':
                    builder.append(DOT).append(DASH).append(DASH);
                    break;

                case 'X':
                case 'x':
                    builder.append(DASH).append(DOT).append(DOT).append(DASH);
                    break;

                case 'Y':
                case 'y':
                    builder.append(DASH).append(DOT).append(DASH).append(DASH);
                    break;

                case 'Z':
                case 'z':
                    builder.append(DASH).append(DASH).append(DOT).append(DOT);
                    break;

                case '0':
                    builder.append(DASH).append(DASH).append(DASH).
                            append(DASH).append(DASH);
                    break;

                case '1':
                    builder.append(DOT).append(DASH).append(DASH).
                            append(DASH).append(DASH);
                    break;

                case '2':
                    builder.append(DOT).append(DOT).append(DASH).
                            append(DASH).append(DASH);
                    break;

                case '3':
                    builder.append(DOT).append(DOT).append(DOT).
                            append(DASH).append(DASH);
                    break;

                case '4':
                    builder.append(DOT).append(DOT).append(DOT).
                            append(DOT).append(DASH);
                    break;

                case '5':
                    builder.append(DOT).append(DOT).append(DOT).
                            append(DOT).append(DOT);
                    break;

                case '6':
                    builder.append(DASH).append(DOT).append(DOT).
                            append(DOT).append(DOT);
                    break;

                case '7':
                    builder.append(DASH).append(DASH).append(DOT).
                            append(DOT).append(DOT);
                    break;

                case '8':
                    builder.append(DASH).append(DASH).append(DASH).
                            append(DOT).append(DOT);
                    break;

                case '9':
                    builder.append(DASH).append(DASH).append(DASH).
                            append(DASH).append(DOT);
                    break;

                case '.':
                    builder.append(DOT).append(DASH).append(DOT).
                            append(DASH).append(DOT).append(DASH);
                    break;

                case ',':
                    builder.append(DASH).append(DASH).append(DOT).
                            append(DOT).append(DASH).append(DASH);
                    break;
            }

            builder.append("  ");
        }

        return builder;
    }

    /**
     * Display the built Morse code translation to a {@link JOptionPane}.
     *
     * @param str  the {@link StringBuilder} containing the translated Morse
     *             code.
     */
    public static void showCode(StringBuilder str) {
        JOptionPane.showMessageDialog(null,
                str, "Morse Code Translator",
                JOptionPane.PLAIN_MESSAGE);
    }
}