package numbers;

import java.util.ArrayList;
import java.util.List;

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
        out.println(Properties.SPY.getText() + ": " + isASpyNumber(userStartNumber));
        out.println(Properties.SQUARE.getText() + ": " + isASquareNumber(userStartNumber));
        out.println(Properties.SUNNY.getText() + ": " + isASunnyNumber(userStartNumber));
        out.println(Properties.JUMPING.getText() + ": " + isAJumpingNumber(userStartNumber));
        out.println(Properties.HAPPY.getText() + ": " + isAHappyNumber(userStartNumber));
        out.println(Properties.SAD.getText() + ": " + !isAHappyNumber(userStartNumber));
    }

    public static void printMoreNumbersResult(Long number, String numberAsString) {
        String result = "";
        if (parityOfNumber(number)) {
            result += Properties.EVEN.getText();
        } else {
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
        if (isASpyNumber(numberAsString)) {
            result += Properties.SPY.getText();
        }
        if (isASquareNumber(numberAsString)) {
            result += Properties.SQUARE.getText();
        }
        if (isASunnyNumber(numberAsString)) {
            result += Properties.SUNNY.getText();
        }
        if (isAJumpingNumber(numberAsString)) {
            result += Properties.JUMPING.getText();
        }
        if (isAHappyNumber(numberAsString)) {
            result += Properties.HAPPY.getText();
        } else {
            result += Properties.SAD.getText();
        }
        out.println(number + " is " + result);
    }

    public static void printNumbersWithPropertyResult(Long userIndex, Long userNumber, String property, boolean startsWithMinus) {

        int numberCount = 0;
        while (numberCount < userIndex) {
            String result = "";
            String numberAsString = userNumber.toString();
            if (parityOfNumber(userNumber)) {
                result += Properties.EVEN.getText();
            } else {
                result += Properties.ODD.getText();
            }
            if (isABuzzNumber(userNumber)) {
                result += Properties.BUZZ.getText();
            }
            if (isADuckNumber(numberAsString)) {
                result += Properties.DUCK.getText();
            }
            if (isAPalindromic(numberAsString)) {
                result += Properties.PALINDROMIC.getText();
            }
            if (isAGapfulNumber(numberAsString, userNumber)) {
                result += Properties.GAPFUL.getText();
            }
            if (isASpyNumber(numberAsString)) {
                result += Properties.SPY.getText();
            }
            if (isASquareNumber(numberAsString)) {
                result += Properties.SQUARE.getText();
            }
            if (isASunnyNumber(numberAsString)) {
                result += Properties.SUNNY.getText();
            }
            if (isAJumpingNumber(numberAsString)) {
                result += Properties.JUMPING.getText();
            }
            if (isAHappyNumber(numberAsString)) {
                result += Properties.HAPPY.getText();
            } else {
                result += Properties.SAD.getText();
            }

            if (!startsWithMinus && result.contains(property.toLowerCase())) {
                out.println(userNumber + " is " + result);
                numberCount++;
            }
            StringBuilder propertyMinus = new StringBuilder(property);
            propertyMinus.deleteCharAt(0);
            if (startsWithMinus && !result.contains(String.valueOf(propertyMinus).toLowerCase())) {
                out.println(userNumber + " is " + result);
                numberCount++;
            }
            userNumber++;

        }
    }

    public static void printNumbersWithMorePropertiesResult(Long userIndex, Long userNumber, List<String> correctProperties, List<String> minusProperties) {

        int numberCount = 0;
        while (numberCount < userIndex) {
            List<String> result = new ArrayList<>();
            String numberAsString = userNumber.toString();
            if (parityOfNumber(userNumber)) {
                result.add(Properties.EVEN.name());
            } else {
                result.add(Properties.ODD.name());
            }
            if (isABuzzNumber(userNumber)) {
                result.add(Properties.BUZZ.name());
            }
            if (isADuckNumber(numberAsString)) {
                result.add(Properties.DUCK.name());
            }
            if (isAPalindromic(numberAsString)) {
                result.add(Properties.PALINDROMIC.name());
            }
            if (isAGapfulNumber(numberAsString, userNumber)) {
                result.add(Properties.GAPFUL.name());
            }
            if (isASpyNumber(numberAsString)) {
                result.add(Properties.SPY.name());
            }
            if (isASquareNumber(numberAsString)) {
                result.add(Properties.SQUARE.name());
            }
            if (isASunnyNumber(numberAsString)) {
                result.add(Properties.SUNNY.name());
            }
            if (isAJumpingNumber(numberAsString)) {
                result.add(Properties.JUMPING.name());
            }
            if (isAHappyNumber(numberAsString)) {
                result.add(Properties.HAPPY.name());
            } else {
                result.add(Properties.SAD.name());
            }

            if (result.containsAll(correctProperties)) {
                numberCount += minusValidation(userNumber, minusProperties, result);

            }

            userNumber++;

        }
    }

    private static int minusValidation(Long userNumber, List<String> minusProperties, List<String> result) {
        if (!minusProperties.isEmpty()) {
            for (String element : minusProperties) {
                if (result.contains(element.replace("-", ""))) {
                    return 0;
                }
            }
        }
        out.println(userNumber + " is " + result);
        return 1;
    }
}
