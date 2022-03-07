/**
 * In regard to storage, there are primitive data types...
 *  - to store integers: int, short, byte, and long
 *  - to store real numbers: float and double
 *  - to store letters: char
 *  - to store true/false values: boolean
 *
 * ...and there are abstract data types...
 *  - examples: JOptionPane, UIManager, Color, Font, ImageIcon, etc.
 *
 * In regard to the size of integers...
 *  - byte: 1 byte or 8 bits; ex: _ _ _ _ _ _ _ _
 *  - short: 2 bytes or 16 bits; ex: _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _
 *  - int: 4 bytes or 32 bits; ex: _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _
 *  - long: 8 bytes or 64 bits; ex: _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _,
 *                                  _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _
 *
 * We deal in a couple of number systems:
 *  - binary: base 2: 0 1 10 11 100 101 110 111 1000 1001 1010...
 *  - octal: base 8: 0 1 2 3 4 5 6 7 10 11 12 13 14 15 16 17 20 21 22 23 24 25 26 27...
 *  - hexadecimal: base 16: 0 1 2 3 4 5 6 7 8 9 A B C D E F 10 11 12 13 14 15 16 17 18 19 1A 1B 1C 1D 1E 1F 20 21...
 *
 * Binary expansion:
 *  - binary numbers are represented only with 1 and 0, ex: 0110, so we deal in 2^1 rather than 10^1.
 *  - base value is represented with subscript immediately following the number.
 *  - traditional number expansion looks like... 418 = 4*10^2 + 1*10^1 + 8*10^0 = 418
 *  - binary number expansion looks like... 0110 = 0*2^3 + 1*2^2 + 1*2^1 + 0*1^0 = 6
 *
 * Binary practice:
 *  - 1010 = 1*2^3 + 0*2^2 + 1*2^1 + 0*2^0 = 8 + 0 + 2 + 0 = 10
 *
 * Hexadecimal practice:
 *  - FA8F = 15*16^3 + 10*16^2 + 8*16^1 + 15*16^0 = 64,143
 *
 * Primitive data values:
 *  - byte: _ _ _ _ _ _ _ _
 *          _ first bit is the sign bit, with 0 = positive, 1 = negative
 *          0 1 1 1 1 1 1 1 = 127
 *
 *  - short: _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _
 *           _ first bit is the sign bit, with 0 = positive, 1 = negative
 *           0 1 1 1 1 1 1 1  1 1 1 1 1 1 1 1 = 32,767
 *
 *  - int: _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _
 *         _ first bit is the sign bit, with 0 = positive, 1 = negative
 *         0 1 1 1 1 1 1 1  1 1 1 1 1 1 1 1  1 1 1 1 1 1 1 1  1 1 1 1 1 1 1 1 = 2,147,483,647
 *      - integer is the default value because it stores most information rather than running into issues fitting
 *        large values in smaller data objects (byte, short).
 *
 *  - long: _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _,
 *          _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _
 *          _ first bit is the sign bit, with 0 = positive, 1 = negative
 *          0 1 1 1 1 1 1 1  1 1 1 1 1 1 1 1  1 1 1 1 1 1 1 1  1 1 1 1 1 1 1 1
 *          1 1 1 1 1 1 1 1  1 1 1 1 1 1 1 1  1 1 1 1 1 1 1 1  1 1 1 1 1 1 1 1 = 9,223,372,036,854,775,807
 *
 *  - BigInteger is the data type introduced when a long is still not large enough to store the values.
 *
 *  - float: _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _
 *           _ first bit is the sign bit, with 0 = positive, 1 = negative
 *             _ _ _ _ _ _ _, _ exponent, which also includes a sign bit
 *                              _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _ mantissa, which is the precision
 *           _ 0 1 1 1 1 1 1, 1 _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, largest power is +127
 *       - similar to scientific notation, 3.1415 = .31415x10^1
 *
 *  - double: _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _,
 *            _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _
 *            _ first bit is the sign bit, with 0 = positive, 1 = negative
 *              _ _ _ _ _ _ _, _ _ _ _ exponent, which also includes a sign bit
 *                                     _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _,
 *            _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _, _ _ _ _ _ _ _ _ mantissa, which is the precision
 *       - similar to scientific notation, 3.02 = .302x10^1
 */
public class Storage {
}