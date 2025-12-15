/*****************************************************************************************
 * Name: Broc Salvati
 * Date: December 15th, 2025
 * Assignment: SDC230 Project - Console Calculator (Utility Class)
 *
 * Description:
 * SimpleCalculator is a utility class that groups together basic calculator
 * operations for use in the console calculator project.
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
     * Java will throw ArithmeticException if denominator is zero.
     *
     * @param numerator   value to be divided
     * @param denominator value to divide by
     * @return numerator / denominator
     * @throws ArithmeticException if denominator is zero
     */
    public static int divideIntegers(int numerator, int denominator) throws ArithmeticException {
        return numerator / denominator;
    }
}
