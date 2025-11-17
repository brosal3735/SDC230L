/*****************************************************************************************
 * Name: Broc Salvati
 * Date: 11/17/2025
 * Assignment: SDC230 Project Week 1 - Console Calculator
 *
 * Description:
 * SimpleCalculator is a utility class that groups together basic calculator
 * operations for use in the console calculator project. For Week 1 it provides
 * methods for adding integer values and subtracting floating point values.
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
}