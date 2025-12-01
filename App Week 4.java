/*****************************************************************************************
 * Name: Broc Salvati
 * Date: December 1st, 2025
 * Assignment: SDC230L Project Week 4 - Exception Handling Calculator
 *
 * Description:
 * This console application demonstrates basic input, output, and exception
 * handling as part of the calculator project. The user is repeatedly prompted
 * to enter two integer values. The first value is divided by the second value.
 * The program:
 *   - Catches division by zero (ArithmeticException) and prompts the user
 *     to try again with a different denominator.
 *   - Catches non-numeric input (InputMismatchException) and prompts the
 *     user to re-enter numeric values.
 * The application continues performing division operations until the user
 * chooses to quit, then prints a closing message.
 *****************************************************************************************/

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Header line for Week 4 project step
        System.out.println("Broc Salvati - Project Week 4 - Exception Handling Calculator");
        System.out.println();

        // Welcome / instructions
        System.out.println("Welcome to the console calculator division module.");
        System.out.println("You will be asked to enter two integer values.");
        System.out.println("The first value will be divided by the second value.");
        System.out.println("If you enter a non-numeric value or try to divide by zero,");
        System.out.println("the program will display an error and let you try again.");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        boolean keepGoing = true;

        while (keepGoing) {

            int numerator = 0;
            int denominator = 0;
            boolean validInput = false;

            // Loop until we get two valid integers and a non-zero denominator
            while (!validInput) {
                try {
                    System.out.print("Please enter the first integer (numerator): ");
                    numerator = scanner.nextInt();

                    System.out.print("Please enter the second integer (denominator): ");
                    denominator = scanner.nextInt();

                    // This call may throw ArithmeticException if denominator is zero
                    int result = SimpleCalculator.divideIntegers(numerator, denominator);

                    System.out.printf("%nResult: %d / %d = %d%n%n", numerator, denominator, result);
                    validInput = true;

                } catch (InputMismatchException e) {
                    System.out.println();
                    System.out.println("Exception: " + e);
                    System.out.println("Invalid input. Please enter whole-number (integer) values.");
                    System.out.println();

                    // Clear the invalid token from the input buffer
                    scanner.nextLine();

                } catch (ArithmeticException e) {
                    System.out.println();
                    System.out.println("Exception: " + e);
                    System.out.println("Division by zero is not allowed. Please enter a non-zero denominator.");
                    System.out.println();

                    // No need to clear the buffer here, both values were already read
                    // The loop will simply start over and prompt again
                }
            }

            // Ask user if they want to perform another calculation
            System.out.print("Would you like to perform another division? (y/n): ");
            String choice = scanner.next();

            System.out.println();

            if (!choice.equalsIgnoreCase("y")) {
                keepGoing = false;
            } else {
                // Clear the rest of the line (if any) before the next iteration
                scanner.nextLine();
            }
        }

        System.out.println("Thank you for using the console calculator. Goodbye!");

        scanner.close();
    }
}