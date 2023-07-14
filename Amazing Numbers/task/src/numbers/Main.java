
package numbers;

import java.util.EnumSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Properties> availableProperties = EnumSet.allOf(Properties.class);
        MenuService.printWelcome();
        MenuService.printSupportedRequests();
        boolean runProgram = true;

        while (runProgram) {
            System.out.print("\nEnter a request: ");
            String userInput = scanner.nextLine();
            if (userInput == "") {
                MenuService.printSupportedRequests();
                continue;
            }
            String[] splitedInput = userInput.split(" ");
            int inputLength = splitedInput.length;
            String userStartNumber = splitedInput[0];
            Long userNumber = Long.parseLong(userStartNumber);
            if (userNumber < 0) {
                System.out.println("\nThe first parameter should be a natural number or zero.");
                continue;
            }
            if (userNumber == 0) {
                runProgram = false;
                System.out.println("\nGoodbye!");
                break;
            }
            switch (inputLength) {
                case 1:
                    PrintResultService.printOneNumberResult(userNumber, userStartNumber);
                    break;
                case 2:
                    MenuService.resultsForTwoInputs(splitedInput, userNumber);
                    break;
                case 3:
                    MenuService.resultsForThreeInputs(availableProperties, splitedInput, userNumber);
                    break;
                default:
                    MenuService.resultsForMoreInputs(splitedInput, userNumber, availableProperties);
                    break;
            }
        }
    }
}
