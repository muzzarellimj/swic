package semester_two.week_six;

/**
 * f(x) is a function if every input has one and only one output; i.e.,
 * f(x) = x^2 - 1. A sequence is a function with the domain of natural
 * numbers rather than a potential infinite number of values; i.e.,
 * avn = n^2 - 1 { a1, a2, a3, a4, a5...}. When we plug in the number at the
 * beginning and calculate the output value, we are sequentially generating
 * the output values.
 *
 * A recursive sequence are defined in terms of themselves; i.e.,
 * avn = avn-1 + 1. All recursive sequences must have a base case, which is
 * basically the starting point of our calculations. For example, avn-1 + 1
 * is the general case and av0 = 5 is the base case.
 *
 * The Fibonacci sequence is Fv1 = Fvn-1 + Fvn-2 in which the 0 and 1
 * sequences are both = 1.
 *
 * Recursion in programming is taking the definition
 * Fn = Fn-1 + Fn-2, F0 = F1 = 1 and compiling the recursive addition
 * operations to create F6 = 8F1 + 5F0.
 *
 * Bottom line: when writing recursive routines, make sure there is both
 * enough space and time!
 *
 * One example of a sequence we would want to use recursion for is a
 * Microsoft Paint model, wherein the program recursively finds pixels to
 * color in when using the bucket paint tool. It uses a N-W-S-E model to
 * check what direction it should travel in.
 *
 * @author Michael Muzzarelli
 */
public class Recursion {
}