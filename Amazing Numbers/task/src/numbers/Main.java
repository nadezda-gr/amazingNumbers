
package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final String EXIT_REQUEST = "0";
    public static final String INSTRUCTIONS_REQUEST = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!\n");
        printInstructions();

        while (true) {
            System.out.println("\nEnter a request:");
            String input = scanner.nextLine();
            String[] inputSplit = input.split(" ");
            if (input.equals(EXIT_REQUEST)) {
                break;
            }
            if (input.equals(INSTRUCTIONS_REQUEST)) {
                printInstructions();
                continue;
            }
            if (inputSplit.length == 1) {
                processSingleNumber(input);
            } else {
                processNumbersInBetween(inputSplit[0], inputSplit[1]);
            }
        }
        System.out.println("Goodbye!");
    }

    private static void processSingleNumber(String input) {
        try {
            Long naturalNumber = ValidationService.getValidFirstNaturalNumber(input);
            Number number = new Number(naturalNumber);
            processNumberProperties(number);
            PrintService printService = new PrintService();
            printService.printNumber(number);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void processNumbersInBetween(String firstNumberInput, String secondNumberInput) {
        List<Number> numbers = getNumbersInBetween(firstNumberInput, secondNumberInput);
        PrintService printService = new PrintService();
        printService.printNumbers(numbers);
    }

    private static List<Number> getNumbersInBetween(String firstNumberInput, String secondNumberInput) {
        List<Number> numbers = new ArrayList<>();
        try {
            Long fromNumber = ValidationService.getValidFirstNaturalNumber(firstNumberInput);
            Long counter = ValidationService.getValidSecondNaturalNumber(secondNumberInput);
            Long toNumber = fromNumber + counter;
            for (Long i = fromNumber; i < toNumber; i++) {
                Number number = new Number(i);
                processNumberProperties(number);
                numbers.add(number);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return numbers;
    }

    private static void processNumberProperties(Number number) {
        NumberService numberService = new NumberService(); //et saada ligi Number klassi objektidele
        numberService.processBuzzProperty(number);
        numberService.processDuckProperty(number);
        numberService.processPalindromicProperty(number);
        numberService.processGapfulProperty(number);
        numberService.processEvenAndOddProperty(number);
        numberService.createAndSetAllTrueProperties(number);
    }

    private static void printInstructions() {
        System.out.println("\nSupported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be processed;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");
    }
}
