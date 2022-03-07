package semester_two.week_twelve;

public class PostfixNotationDemonstration {

    public static void main(String[] args) {
        String expA = "13 4 5 * + 8 2 / -",
                expB = "4 5 - 3 * 2 3 ^ + 11 +",
                expC = "2 3 * 2 ^ 10 24 5 6 1 + * - * +",
                expD = "-2 3 - -4 * -1 + 1 +";
        // Answers: 29, 16, -74

        System.out.println(PostfixNotation.evaluate(expA));
        System.out.println(PostfixNotation.evaluate(expB));
        System.out.println(PostfixNotation.evaluate(expC));
        System.out.println(PostfixNotation.evaluate(expD));
        System.out.println(PostfixNotation.evaluate("2 -3 ^"));
        //System.out.println(PostfixNotation.evaluate("3 0 /"));
        System.out.println(PostfixNotation.evaluate("0 0 + 0 - 0 *"));
        System.out.println(PostfixNotation.evaluate("4 0 ^"));
        //System.out.println(PostfixNotation.evaluate("2 3 4 *"));
        //System.out.println(PostfixNotation.evaluate("2 + 3"));
        //System.out.println(PostfixNotation.evaluate("2 -3"));
        System.out.println(PostfixNotation.evaluate("5 3 %"));
        System.out.println(PostfixNotation.evaluate("8 3 %"));

        System.out.println("Done testing evaluations...");

        // Test conversion from infix to PostfixNotation
        System.out.println(PostfixNotation.infixToPostfix("25 + 3 * (4 - 2)"));
        System.out.println(PostfixNotation.infixToPostfix("5+353*(4-2)"));
        System.out.println(PostfixNotation.infixToPostfix("5 + 3*(41 - 2)"));
        System.out.println(PostfixNotation.infixToPostfix("5+3177  *  (40-20)"));
        System.out.println(PostfixNotation.infixToPostfix("  5 + 3 * ( 4 - 2 ) "));
        System.out.println(PostfixNotation.infixToPostfix("2^(((3-4)*2 + (2*3)^2 * 2) - 30*(3-1))"));
        System.out.println(PostfixNotation.evaluate(PostfixNotation.infixToPostfix("2^(((3-4)*2 + (2*3)^2 * 2) - 30*(3-1))")));
        System.out.println(PostfixNotation.evaluate(PostfixNotation.infixToPostfix("5 + 3 * (4 - 2)")));

        // Still need to address subtraction vs negation.
        System.out.println(PostfixNotation.infixToPostfix("2 - -3"));
        System.out.println(PostfixNotation.evaluate(PostfixNotation.infixToPostfix("2 - -3")));
        System.out.println(PostfixNotation.infixToPostfix("2 * -3"));
        System.out.println(PostfixNotation.evaluate(PostfixNotation.infixToPostfix("2 * -3")));
        System.out.println(PostfixNotation.infixToPostfix("-2 - -3"));
        System.out.println(PostfixNotation.evaluate(PostfixNotation.infixToPostfix("-2 - -3")));
        System.out.println(PostfixNotation.infixToPostfix("-2 - (4*-5)"));
        System.out.println(PostfixNotation.evaluate(PostfixNotation.infixToPostfix("-2 - (4*-5)")));
        System.out.println(PostfixNotation.infixToPostfix("3*-(-(4-1)*2)"));
        System.out.println(PostfixNotation.evaluate(PostfixNotation.infixToPostfix("3*-(-(4-1)*2)")));

        // Last to address is ^

    }
}