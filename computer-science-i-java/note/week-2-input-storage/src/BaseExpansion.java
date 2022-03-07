/**
 * As referred to in Storage, base expansion is the expansion of a
 * value by the base to convert from one number system to another; i.e.,
 * convert from hexadecimal (16) to octal (8).
 *
 *
 * Example: convert 500 (10) to (4).
 *      Start with the base to the power of an increasing number - 4^5, 4^4,
 *      4^3, 4^2. 4^1, 4^0 - and note how many times the power goes into the
 *      value and the remainder, then tally the number of times the power
 *      went into the value.
 *
 *      4^5 (1024) does not go into 500 (0)
 *      4^4 (256) goes into 500 once with 244 remaining (1)
 *      4^3 (64) goes into 244 three times with 52 remaining (3)
 *      4^2 (16) goes into 52 three times with 4 remaining (3)
 *      4^1 (4) goes into 4 one time with 0 remaining (1)
 *      4^0 (1) does not go into 0 (0)
 *
 *      500 (10)  = 13310 (4)
 *
 *
 * Example: find the binary sequence for 100.
 *      Start with traditional division by 2, then read the remainders from
 *      the bottom to the top.
 *
 *      2 goes into 100 50 times with a 0 remainder
 *      2 goes into 50 25 times with a 0 remainder
 *      2 goes into 25 12 times with a 1 remainder
 *      2 goes into 12 6 times with a 0 remainder
 *      2 goes into 6 3 times with a 0 remainder
 *      2 goes into 3 1 time with a 1 remainder
 *      2 goes into 1 0 times with a 1 remainder
 *
 *      100 (10) = 01100100 (2)
 *
 *
 * What about negative numbers?  We know 01100100 = 100, but does
 * 11100100 = -100?  No, for the same reason 10000000 is not negative 0.
 * 11111111 + 1 = 1,00000000, with the 1 represented as an overflow value.
 * 11111111 is -1 but 11111111 + 1 is 1.  This is what is referred to as the
 * two's compliment representation.
 *
 * Example: find the decimal value of 10111010.
 *      The number is a negative, indicated by the sign bit, so we start by
 *      flipping all of the bits...
 *
 *      10111010 = 01000101
 *               = 64 + 4 + 1
 *               = 69
 *
 *      ...then add 1 to the calculated value...
 *
 *               = 70
 *
 *       ...and finally, change it to a negative number.
 *
 *               = -70
 */
public class BaseExpansion {
}