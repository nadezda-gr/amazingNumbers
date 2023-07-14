package numbers;

public class NumberService {

    public static void parityOfNumber(Long userNumber) {
        boolean isEven = userNumber % 2 == 0;
        System.out.println("        even: " + isEven);
        System.out.println("         odd: " + !isEven);
    }


    public static void isABuzzNumber(Long userNumber) {
        boolean isBuzz = userNumber % 7 == 0 || userNumber % 10 == 7;
        System.out.println("        buzz: " + isBuzz);
    }

    public static void isADuckNumber(String userInput) {
        boolean isDuck = false;
        if (userInput.length() > 1) {
            String withoutFirstNumber = userInput.substring(1, userInput.length());
            isDuck = withoutFirstNumber.contains("0");
            System.out.println("        duck: " + isDuck);
        } else {
            System.out.println("        duck: " + isDuck);
        }
    }

    public static void isAPalindromic(String userInput, Long userNumber) {
        StringBuilder reversed = getReversed(userInput);
        boolean isPalindromic = reversed.equals(userInput);
        System.out.println(" palindromic: " + isPalindromic);
    }

    private static StringBuilder getReversed(String userInput) {
        int length = userInput.length();
        StringBuilder reversed = new StringBuilder(length);
        for (int i = length - 1; i >= 0; i--) {
            reversed.append(userInput.charAt(i));
        }
        return reversed.toString();
    }
}
