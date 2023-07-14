package numbers;

import static java.lang.System.out;
import static numbers.NumberService.*;

public class PrintResultService {

    public static void printOneNumberResult(Long userNumber, String userStartNumber) {
        out.println("\nProperties of " + userNumber);
        out.println(Properties.EVEN.getText() + ": " + parityOfNumber(userNumber));
        out.println(Properties.ODD.getText() + ": " + !parityOfNumber(userNumber));
        out.println(Properties.BUZZ.getText() + ": " + isABuzzNumber(userNumber));
        out.println(Properties.DUCK.getText() + ": " + isADuckNumber(userStartNumber));
        out.println(Properties.PALINDROMIC.getText() + ": " + isAPalindromic(userStartNumber));
        out.println(Properties.GAPFUL.getText() + ": " + isAGapfulNumber(userStartNumber, userNumber));
    }

    public static void printMoreNumbersResult(Long number, String numberAsString) {
        String result = "";
        if (parityOfNumber(number)) {
            result += Properties.EVEN.getText();
        } else if (!parityOfNumber(number)) {
            result += Properties.ODD.getText();
        }
        if (isABuzzNumber(number)) {
            result += Properties.BUZZ.getText();
        }
        if (isADuckNumber(numberAsString)) {
            result += Properties.DUCK.getText();
        }
        if (isAPalindromic(numberAsString)) {
            result += Properties.PALINDROMIC.getText();
        }
        if (isAGapfulNumber(numberAsString, number)) {
            result += Properties.GAPFUL.getText();
        }
        out.println(number + " is " + result);
    }
}
