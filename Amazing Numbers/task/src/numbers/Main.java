
package numbers;

import java.util.Scanner;

public class Main {

    public static final String  EXIT = "0";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!\n" +
                "\n" +
                "Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter 0 to exit.");

        while (true) {
            System.out.println("\nEnter a request:");
            String input = scanner.nextLine();
            if (input.equals(EXIT)) {
                break;
            }
            try {
                Number number = new Number(input);
                ValidationService.validateNaturalNumber(number.getNumberValue());
                processNumberProperties(number);
                PrintService printService = new PrintService();
                printService.printNumber(number);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Goodbye!");
    }

    private static void processNumberProperties(Number number) {
        NumberService numberService = new NumberService(); //et saada ligi Number klassi objektidele
        numberService.processEvenAndOddProperty(number);
        numberService.processBuzzProperty(number);
        numberService.processDuckProperty(number);
        numberService.processPalindromicProperty(number);
    }
}
