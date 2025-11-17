/*****************************************************************************************
 * Name: Your Name
 * Date: 11/17/2025
 * Assignment: SDC230 Project Week 1 - Console Calculator
 *
 * Description:
 * Main application class for the Week 1 console calculator. This program:
 *  - Prints an informative project header and welcome instructions.
 *  - Prompts the user for two integers and displays their sum.
 *  - Prompts the user for two floating point values and displays the result
 *    of subtracting the first from the second.
 *  - Formats results using a "formula = result" style and four decimal places
 *    for floating point values.
 *  - Prints a closing message thanking the user.
 *****************************************************************************************/

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Create a Scanner for user input
        Scanner input = new Scanner(System.in);

        // Project header
        System.out.println("Your Name - Project Week 1: Console Calculator");
        System.out.println("------------------------------------------------");
        System.out.println();

        // Welcome and basic instructions
        System.out.println("Welcome to the console calculator.");
        System.out.println("You will first enter two integers to be added,");
        System.out.println("then two decimal values where the second minus");
        System.out.println("the first will be calculated.");
        System.out.println();

        /***********************
         * Integer operations *
         ***********************/
        System.out.println("Integer Addition");
        System.out.println("----------------");

        int intVal1 = readInt(input, "Enter the first integer: ");
        int intVal2 = readInt(input, "Enter the second integer: ");

        int intSum = SimpleCalculator.addIntegers(intVal1, intVal2);

        // Format like: "a + b = result"
        System.out.printf("%d + %d = %d%n", intVal1, intVal2, intSum);
        System.out.println();

        /*******************************
         * Floating point operations   *
         *******************************/
        System.out.println("Floating Point Subtraction");
        System.out.println("--------------------------");

        double dblVal1 = readDouble(input, "Enter the first decimal value: ");
        double dblVal2 = readDouble(input, "Enter the second decimal value: ");

        double dblResult = SimpleCalculator.subtractDoubles(dblVal1, dblVal2);

        // Display using four decimal places: "second - first = result"
        System.out.printf("%.4f - %.4f = %.4f%n", dblVal2, dblVal1, dblResult);
        System.out.println();

        // Closing message
        System.out.println("Thank you for using the console calculator.");
        System.out.println("Goodbye.");

        // Close the Scanner
        input.close();
    }

    /**
     * Reads a valid integer from the user, re-prompting if the input is invalid.
     *
     * @param input Scanner to read from
     * @param prompt message to display before reading input
     * @return a valid integer value
     */
    private static int readInt(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return input.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a whole number (integer).");
                input.nextLine(); // clear invalid input
            }
        }
    }

    /**
     * Reads a valid double from the user, re-prompting if the input is invalid.
     *
     * @param input Scanner to read from
     * @param prompt message to display before reading input
     * @return a valid double value
     */
    private static double readDouble(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return input.nextDouble();
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a numeric decimal value.");
                input.nextLine(); // clear invalid input
            }
        }
    }
}