
package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        int userNumber = scanner.nextInt();
        if (userNumber <= 0) {
            System.out.println("This number is not natural!");
        } else {
            parityOfNumber(userNumber);
            isABuzzNumber(userNumber);
        }
    }

    private static void parityOfNumber(int userNumber) {
        if (userNumber % 2 == 0) {
            System.out.println("This number is Even.");
        } else {
            System.out.println("This number is Odd.");
        }
    }

    private static void isABuzzNumber(int userNumber) {
//        int theLastDigit = Integer.parseInt(String.valueOf(userInput.charAt(userInput.length() - 1)));
        if (userNumber % 7 == 0 && userNumber % 10 == 7) {
            System.out.println("It is a Buzz number.");
            System.out.println("Explanation:\n" +
                    userNumber + " is divisible by 7 and ends with 7.");
        } else if (userNumber % 7 == 0 && userNumber % 10 != 7) {
            System.out.println("It is a Buzz number.");
            System.out.println("Explanation:\n" +
                    userNumber + " is divisible by 7.");
        } else if (userNumber % 7 != 0 && userNumber % 10 == 7) {
            System.out.println("It is a Buzz number.");
            System.out.println("Explanation:\n" +
                    userNumber + " ends with 7.");
        } else {
            System.out.println("It is not a Buzz number.");
            System.out.println("Explanation:\n" +
                    userNumber + " is neither divisible by 7 nor does it end with 7.");
        }
    }
}
