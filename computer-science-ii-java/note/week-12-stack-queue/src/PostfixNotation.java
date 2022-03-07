package semester_two.week_twelve;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Infix notation is mathematical notation; i.e., 2 + 3 * 4.
 *
 * Postfix notation, however, dictates that the operation follows the operands; i.e., 2 3 4 * +
 *
 * Prior to this, there was prefix notation (Polish notation), which dictated that the operator goes before the
 * operands; i.e., + 2 * 3 4.  One benefit of Polish notation is that it does not require parentheses and can only be
 * interpreted one way.
 *
 * Postfix examples:
 *      4 - 3 * 4 / (2 + 7)  ->  4 3 4 * 2 7 + / -
 *      8 * 2 * 3 + 4 / 2 ^ 3 - 1  ->  8 2 * 3 * 4 2 3 ^ / + 1 -
 *      2 + 3 * 4 + 5  ->  2 3 4 * + 5 +
 *      (2 + 3) * (4 + 5)  ->  2 3 + 4 5 + *
 *      2 + 3 * (4 + 5)  ->  2 3 4 5 + * +
 *      (2 + 3) * 4 + 5  ->  2 3 + 4 * 5 +
 *
 * Our algorithm to evaluate things in postfix notation is:
 *      1) If the element is a number: push it on the stack.
 *      2) If the element is an operator: pop last two operands (R, L), perform the arithmetic, and push the result.
 *      3) Last element on the stack is the "answer."
 *
 * @author Michael Muzzarelli
 */
public class PostfixNotation {

    public static int evaluate(String s) throws InputMismatchException {
        Stack<Integer> values = new Stack<>();
        Scanner input = new Scanner(s);
        String operator = null;
        int leftOp = 0, rightOp = 0;

        while (input.hasNext()) {
            if (input.hasNextInt()) {
                values.push(input.nextInt());

            } else {
                operator = input.next();

                // guarantee two elements on stack to pop
                if (values.size() < 2) {
                    throw new InputMismatchException("Illegal postfix expression!");
                }

                rightOp = values.pop().intValue();
                leftOp = values.pop().intValue();

                switch (operator) {
                    case "+": values.push(leftOp + rightOp); break;
                    case "-": values.push(leftOp - rightOp); break;
                    case "*": values.push(leftOp * rightOp); break;
                    case "%": values.push(leftOp % rightOp); break;
                    case "/":
                        if(rightOp == 0)  {
                            throw new NumberFormatException("Cannot divide by zero.");
                        }

                        values.push(leftOp / rightOp); break;
                    case "^": values.push((int)Math.pow(leftOp,rightOp)); break;
                    default: throw new InputMismatchException("Operator unrecognized.");
                }
            }
        }

        if (values.size() != 1) {
            throw new InputMismatchException("Illegal postfix exception!");
        }

        return values.peek().intValue();
    }

    public static String infixToPostfix(String s) {
        // step one: strip all spaces
        s = s.replaceAll(" ", "");

        // step two: if the leading character is "-", change to "~"
        if (s.charAt(0) == '-') {
            s = "~" + s.substring(1);
        }

        // step three: find all negation symbols, change to "~"
        s = s.replaceAll("\\+-", "+~");
        s = s.replaceAll("--", "-~");
        s = s.replaceAll("\\*-", "*~");
        s = s.replaceAll("/-", "/~");
        s = s.replaceAll("%-", "%~");
        s = s.replaceAll("\\^-", "^~");
        s = s.replaceAll("\\(-", "(~");

        // step four: find all operators, add space to separate from operands
        s = s.replaceAll("\\+", " + ");
        s = s.replaceAll("-", " - ");
        s = s.replaceAll("\\*", " * ");
        s = s.replaceAll("/", " / ");
        s = s.replaceAll("%", " % ");
        s = s.replaceAll("\\^", " ^ ");
        s = s.replaceAll("\\(", " ( ");
        s = s.replaceAll("\\)", " ) ");

        // step five: replace negation symbol "~" with "-1 *"
        s = s.replaceAll("~", " -1 * ");

        Scanner input = new Scanner(s);
        Stack<String> ops = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        String token = null;

        while (input.hasNext()) {
            if (input.hasNextInt()) {
                postfix.append(input.nextInt()).append(" ");

            } else {
                token = input.next();

                // verify next token is a recognizable operator
                if(!(token.equals("+") || token.equals("-") ||
                        token.equals("*") || token.equals("/") ||
                        token.equals("%") || token.equals("^") ||
                        token.equals("(") || token.equals(")")))
                    throw new IllegalArgumentException("Operator not recognized.");

                if (ops.isEmpty() || token.equals("(")) {
                    ops.push(token);

                } else if (token.equals(")")) {
                    while (!ops.peek().equals("(")) {
                        postfix.append(ops.pop()).append(" ");
                    }

                    ops.pop();

                } else if (precedenceOf(ops.peek().charAt(0)) <
                        precedenceOf(token.charAt(0))) {
                    ops.push(token);

                } else {
                    while (!ops.isEmpty() &&
                            precedenceOf(ops.peek().charAt(0)) >=
                            precedenceOf(token.charAt(0))) {
                        postfix.append(ops.pop()).append(" ");
                    }

                    ops.push(token);
                }
            }
        }

        // pop the rest of the operators off the stack and append
        while (!ops.isEmpty()) {
            postfix.append(ops.pop()).append(" ");
        }

        return postfix.substring(0, postfix.length() - 1);
    }

    private static int precedenceOf(char operator) {
        int precedence = 0;

        switch (operator) {
            case '^': precedence++;
            case '/':
            case '*':
            case '%': precedence++;
            case '+':
            case '-': precedence++;
        }

        return precedence;
    }
}