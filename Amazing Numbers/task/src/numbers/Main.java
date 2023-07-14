
package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a natural number:");
        Scanner scanner = new Scanner(System.in);
        Long input = scanner.nextLong();
        try {
            Number number = new Number(input);
            ValidationService.validateNaturalNumber(number.getNumberValue());
            NumberService numberService = new NumberService(); //et saada ligi Number klassi objektidele
            numberService.processOddOrEvenProperty(number);
            numberService.processBuzzProperty(number);
            PrintService printService = new PrintService();
            printService.printNumber(number);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
