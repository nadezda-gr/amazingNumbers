
package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a natural number:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
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

    private static void processNumberProperties(Number number) {
        NumberService numberService = new NumberService(); //et saada ligi Number klassi objektidele
        numberService.processEvenAndOddProperty(number);
        numberService.processBuzzProperty(number);
        numberService.processDuckProperty(number);
    }
}
