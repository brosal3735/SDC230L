/*****************************************************************************************
 * Name: Broc Salvati
 * Date: December 1st, 2025
 * Assignment: SDC230L Project Week 4 - Console Calculator
 *
 * Description:
 * SimpleCalculator is a utility class that groups together basic calculator
 * operations for use in the console calculator project. It provides methods
 * for adding integer values, subtracting floating point values, and dividing
 * integer values.
 *****************************************************************************************/

public class SimpleCalculator {

    /**
     * Adds two integer values and returns the result.
     *
     * @param a first integer
     * @param b second integer
     * @return sum of a and b
     */
    public static int addIntegers(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts the first double from the second double and returns the result.
     *
     * @param first  the value to subtract
     * @param second the value from which first is subtracted
     * @return second - first
     */
    public static double subtractDoubles(double first, double second) {
        return second - first;
    }

    /**
     * Divides one integer by another and returns the result.
     * This method relies on Java to throw an ArithmeticException
     * if the denominator is zero.
     *
     * @param numerator   the value to be divided
     * @param denominator the value to divide by
     * @return numerator / denominator
     * @throws ArithmeticException if denominator is zero
     */
    public static int divideIntegers(int numerator, int denominator)
            throws ArithmeticException {
        return numerator / denominator;
    }
}