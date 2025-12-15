/*****************************************************************************************
 * Name: Broc Salvati
 * Date: December 15th, 2025
 * Assignment: SDC230L Project Week 5 - Final Console Calculator
 *
 * Description:
 * Final integrated console calculator that supports:
 * 1) Basic calculations (add, subtract, divide)
 * 2) Memory functions (single numeric value and integer collection up to 10 values)
 * 3) Exception handling for invalid input and divide-by-zero
 *
 * Notes:
 * - App.java owns all user interaction (menus and prompts).
 * - SimpleCalculator.java owns calculation methods only (no console I/O).
 *****************************************************************************************/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    // Single memory value. Null means nothing stored.
    private static Double singleMemory = null;

    // Integer collection memory (up to 10 values).
    private static final ArrayList<Integer> intMemory = new ArrayList<Integer>();

    public static void main(String[] args) {

        System.out.println("Broc Salvati - Project Week 5 - Final Console Calculator");
        System.out.println();
        System.out.println("Welcome. Use the menus to perform calculations and manage memory.");
        System.out.println("Enter the number of the option you want. Choose Quit when finished.");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            printMainMenu();
            int choice = readMenuInt(scanner, "Select an option: ");

            switch (choice) {
                case 1:
                    handleCalculatorMenu(scanner);
                    break;
                case 2:
                    handleSingleMemoryMenu(scanner);
                    break;
                case 3:
                    handleCollectionMemoryMenu(scanner);
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    System.out.println();
                    break;
            }
        }

        System.out.println();
        System.out.println("Thank you for using the console calculator. Goodbye!");
        scanner.close();
    }

    // ---------------------- Menus ----------------------

    private static void printMainMenu() {
        System.out.println("Main Menu");
        System.out.println("1) Calculator operations");
        System.out.println("2) Single-value memory functions");
        System.out.println("3) Integer collection memory functions");
        System.out.println("4) Quit");
    }

    private static void handleCalculatorMenu(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println();
            System.out.println("Calculator Operations Menu");
            System.out.println("1) Add (integers)");
            System.out.println("2) Subtract (doubles)");
            System.out.println("3) Divide (integers)");
            System.out.println("4) Return to main menu");

            int choice = readMenuInt(scanner, "Select an option: ");

            switch (choice) {
                case 1:
                    doAdd(scanner);
                    break;
                case 2:
                    doSubtract(scanner);
                    break;
                case 3:
                    doDivide(scanner);
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }
        System.out.println();
    }

    // ---------------------- Calculator Ops ----------------------

    private static void doAdd(Scanner scanner) {
        int a = readInt(scanner, "Enter first integer: ");
        int b = readInt(scanner, "Enter second integer: ");
        int result = SimpleCalculator.addIntegers(a, b);
        System.out.println("Result: " + a + " + " + b + " = " + result);
    }

    private static void doSubtract(Scanner scanner) {
        double first = readDouble(scanner, "Enter the value to subtract (double): ");
        double second = readDouble(scanner, "Enter the value to subtract from (double): ");
        double result = SimpleCalculator.subtractDoubles(first, second);
        System.out.printf("Result: %.4f - %.4f = %.4f%n", second, first, result);
    }

    private static void doDivide(Scanner scanner) {
        int numerator = readInt(scanner, "Enter integer numerator: ");

        boolean valid = false;
        while (!valid) {
            int denominator = readInt(scanner, "Enter integer denominator: ");
            try {
                int result = SimpleCalculator.divideIntegers(numerator, denominator);
                System.out.println("Result: " + numerator + " / " + denominator + " = " + result);
                valid = true;
            } catch (ArithmeticException e) {
                System.out.println("Exception: " + e);
                System.out.println("Division by zero is not allowed. Please enter a non-zero denominator.");
            }
        }
    }

    // ----------------- Single-value Memory Menu -----------------

    private static void handleSingleMemoryMenu(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println();
            System.out.println("Single-value Memory Menu");
            System.out.println("1) Store a value in memory");
            System.out.println("2) Retrieve the value from memory");
            System.out.println("3) Clear the value in memory");
            System.out.println("4) Replace the value in memory");
            System.out.println("5) Return to main menu");

            int choice = readMenuInt(scanner, "Select an option: ");

            switch (choice) {
                case 1:
                    storeSingleValue(scanner);
                    break;
                case 2:
                    retrieveSingleValue();
                    break;
                case 3:
                    clearSingleValue();
                    break;
                case 4:
                    replaceSingleValue(scanner);
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }
        System.out.println();
    }

    private static void storeSingleValue(Scanner scanner) {
        if (singleMemory != null) {
            System.out.println("A value is already stored in memory: " + singleMemory);
            System.out.println("Use Replace to change it.");
            return;
        }
        double value = readDouble(scanner, "Enter a numeric value to store in memory: ");
        singleMemory = value;
        System.out.println("Value stored in memory: " + singleMemory);
    }

    private static void retrieveSingleValue() {
        if (singleMemory == null) {
            System.out.println("No value is currently stored in memory.");
        } else {
            System.out.println("The value stored in memory is: " + singleMemory);
        }
    }

    private static void clearSingleValue() {
        singleMemory = null;
        System.out.println("Memory value cleared.");
    }

    private static void replaceSingleValue(Scanner scanner) {
        if (singleMemory == null) {
            System.out.println("No value is currently stored. This will act as a store.");
        }
        double value = readDouble(scanner, "Enter a new numeric value to store in memory: ");
        singleMemory = value;
        System.out.println("Memory value updated to: " + singleMemory);
    }

    // --------------- Integer Collection Memory Menu -------------

    private static void handleCollectionMemoryMenu(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println();
            System.out.println("Integer Collection Memory Menu");
            System.out.println("1) Add values to memory (up to 10 total)");
            System.out.println("2) Display all values stored");
            System.out.println("3) Display count of values stored");
            System.out.println("4) Remove an individual value by index");
            System.out.println("5) Get sum of all values");
            System.out.println("6) Get average of all values");
            System.out.println("7) Get difference of first and last values");
            System.out.println("8) Return to main menu");

            int choice = readMenuInt(scanner, "Select an option: ");

            switch (choice) {
                case 1:
                    addValuesToCollection(scanner);
                    break;
                case 2:
                    displayCollectionValues();
                    break;
                case 3:
                    displayCollectionCount();
                    break;
                case 4:
                    removeValueFromCollection(scanner);
                    break;
                case 5:
                    displayCollectionSum();
                    break;
                case 6:
                    displayCollectionAverage();
                    break;
                case 7:
                    displayFirstLastDifference();
                    break;
                case 8:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }
        System.out.println();
    }

    private static void addValuesToCollection(Scanner scanner) {
        int remaining = 10 - intMemory.size();
        if (remaining <= 0) {
            System.out.println("Memory already contains 10 values. Remove some values before adding more.");
            return;
        }

        System.out.println("You can add up to " + remaining + " more integer value(s).");
        int toAdd = readInt(scanner, "How many values would you like to add? ");

        if (toAdd <= 0) {
            System.out.println("No values will be added.");
            return;
        }

        if (toAdd > remaining) {
            System.out.println("You requested more values than available space.");
            System.out.println("Only " + remaining + " values will be added.");
            toAdd = remaining;
        }

        for (int i = 0; i < toAdd; i++) {
            int value = readInt(scanner, "Enter integer value " + (i + 1) + ": ");
            intMemory.add(value);
        }

        System.out.println("Values added. Current count: " + intMemory.size());
    }

    private static void displayCollectionValues() {
        if (intMemory.isEmpty()) {
            System.out.println("No values stored in memory.");
            return;
        }

        System.out.println("Values stored in memory:");
        System.out.printf("%-6s %-6s%n", "Index", "Value");
        for (int i = 0; i < intMemory.size(); i++) {
            System.out.printf("%-6d %-6d%n", i, intMemory.get(i));
        }
    }

    private static void displayCollectionCount() {
        System.out.println("The count of values in memory is: " + intMemory.size());
    }

    private static void removeValueFromCollection(Scanner scanner) {
        if (intMemory.isEmpty()) {
            System.out.println("No values stored in memory to remove.");
            return;
        }

        displayCollectionValues();
        System.out.println();

        int index = readInt(scanner,
                "Enter the index of the value to remove (0 to " + (intMemory.size() - 1) + "): ");

        if (index < 0 || index >= intMemory.size()) {
            System.out.println("Invalid index. No value removed.");
            return;
        }

        int removed = intMemory.remove(index);
        System.out.println("Removed value: " + removed);
        System.out.println("Current count: " + intMemory.size());
    }

    private static void displayCollectionSum() {
        if (intMemory.isEmpty()) {
            System.out.println("No values stored in memory. Sum is 0.");
            return;
        }

        int sum = 0;
        for (int value : intMemory) {
            sum += value;
        }

        System.out.println("The sum of values in memory is: " + sum);
    }

    private static void displayCollectionAverage() {
        if (intMemory.isEmpty()) {
            System.out.println("No values stored in memory. Average is undefined.");
            return;
        }

        int sum = 0;
        for (int value : intMemory) {
            sum += value;
        }

        double avg = (double) sum / intMemory.size();
        System.out.printf("The average of values in memory is: %.2f%n", avg);
    }

    private static void displayFirstLastDifference() {
        if (intMemory.isEmpty()) {
            System.out.println("No values stored in memory. Difference is undefined.");
            return;
        }

        if (intMemory.size() == 1) {
            System.out.println("Only one value stored. Difference between first and last is 0.");
            return;
        }

        int first = intMemory.get(0);
        int last = intMemory.get(intMemory.size() - 1);
        int diff = first - last;

        System.out.println("First value: " + first);
        System.out.println("Last value: " + last);
        System.out.println("Difference (first - last): " + diff);
    }

    // ---------------------- Input Helpers -----------------------

    private static int readMenuInt(Scanner scanner, String prompt) {
        // Menu input: requires an integer, but not necessarily within a range.
        return readInt(scanner, prompt);
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = scanner.nextInt();
                scanner.nextLine(); // consume newline
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Exception: " + e);
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // discard invalid token
            }
        }
    }

    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Exception: " + e);
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.nextLine(); // discard invalid token
            }
        }
    }
}
