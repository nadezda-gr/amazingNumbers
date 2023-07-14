package numbers;

public class NumberService {
    public void processOddOrEvenProperty(Number number) {
        Long numberValue = number.getNumberValue();
        boolean isEven = numberValue % 2 == 0;
        NumberProperty numberProperty = new NumberProperty();
        numberProperty.setBooleanValue(true);
        numberProperty.setExplanation("");
        numberProperty.setResult(getOddOrEvenResult(isEven));
        number.getNumberProperties().add(numberProperty);
    }

    public void processBuzzProperty(Number number) {
        Long numberValue = number.getNumberValue();
        boolean isDivisibleBySeven = numberValue % 7 == 0;
        boolean endsWithSeven = numberValue % 10 == 7;
        boolean isBuzz = isDivisibleBySeven || endsWithSeven;
        NumberProperty numberProperty = new NumberProperty();
        numberProperty.setBooleanValue(isBuzz);
        numberProperty.setResult(getBuzzResult(isBuzz));
        numberProperty.setExplanation(getBuzzExplanation(numberValue, isDivisibleBySeven, endsWithSeven));
        number.getNumberProperties().add(numberProperty);
    }

    private static String getOddOrEvenResult(boolean isEven) {
        return isEven ? "This number is Even." : "This number is Odd.";
    }

    private static String getBuzzResult(boolean isBuzz) {
        return isBuzz ? "It is a Buzz number." : "It is not a Buzz number.";
    }

    private static String getBuzzExplanation(Long numberValue, boolean isDivisibleBySeven, boolean endsWithSeven) {
        if (isDivisibleBySeven && endsWithSeven) {
            return numberValue + " is divisible by 7 and ends with 7.";
        } else if (!isDivisibleBySeven && !endsWithSeven) {
            return numberValue + " is neither divisible by 7 nor does it end with 7.";
        } else if (isDivisibleBySeven && !endsWithSeven) {
            return numberValue + " is divisible by 7.";
        } else {
            return numberValue + " ends with 7.";
        }
    }



//
//    public static void isADuckNumber(String userInput) {
//        boolean isDuck = false;
//        if (userInput.length() > 1) {
//            String withoutFirstNumber = userInput.substring(1, userInput.length());
//            isDuck = withoutFirstNumber.contains("0");
//            System.out.println("        duck: " + isDuck);
//        } else {
//            System.out.println("        duck: " + isDuck);
//        }
//    }
//
//    public static void isAPalindromic(String userInput, Long userNumber) {
//        StringBuilder reversed = getReversed(userInput);
//        boolean isPalindromic = reversed.equals(userInput);
//        System.out.println(" palindromic: " + isPalindromic);
//    }
//
//    private static StringBuilder getReversed(String userInput) {
//        int length = userInput.length();
//        StringBuilder reversed = new StringBuilder(length);
//        for (int i = length - 1; i >= 0; i--) {
//            reversed.append(userInput.charAt(i));
//        }
//        return reversed.toString();

//    }
}
