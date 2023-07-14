package numbers;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class NumberService {

    public static final int CORRECTION_DIGIT = 1;

    public static boolean parityOfNumber(Long userNumber) {
        boolean isEven = userNumber % 2 == 0;
        return isEven;
    }

    public static boolean isABuzzNumber(Long userNumber) {
        boolean isBuzz = userNumber % 7 == 0 || userNumber % 10 == 7;
        return isBuzz;
    }

    public static boolean isADuckNumber(String userStartNumber) {
        boolean isDuck = false;
        if (userStartNumber.length() > 1) {
            String withoutFirstNumber = userStartNumber.substring(1, userStartNumber.length());
            isDuck = withoutFirstNumber.contains("0");
        }
        return isDuck;
    }

    public static boolean isAPalindromic(String userStartNumber) {
        String reversed = getReversed(userStartNumber);
        boolean isPalindromic = reversed.equals(userStartNumber);
        return isPalindromic;
    }

    private static String getReversed(String userStartNumber) {
        int length = userStartNumber.length();
        StringBuilder reversed = new StringBuilder(length);
        for (int i = length - CORRECTION_DIGIT; i >= 0; i--) {
            reversed.append(userStartNumber.charAt(i));
        }
        return reversed.toString();
    }

    public static boolean isAGapfulNumber(String userStartNumber, Long userNumber) {
        boolean isGapful = false;
        if (userStartNumber.length() > 2) {
            String first = String.valueOf(userStartNumber.charAt(0));
            String last = String.valueOf(userStartNumber.charAt(userStartNumber.length() - 1));
            int firstLast = Integer.parseInt(first + last);
            isGapful = userNumber % firstLast == 0;
        }
        return isGapful;
    }

    public static boolean isASpyNumber(String userStartNumber) {
        boolean isSpy = false;
        int sumOfDigits = 0;
        int productOfDigits = 1;
        for (int i = 0; i < userStartNumber.length(); i++) {
            sumOfDigits += Integer.parseInt(String.valueOf(userStartNumber.charAt(i)));
            productOfDigits *= Integer.parseInt(String.valueOf(userStartNumber.charAt(i)));
        }
        if (sumOfDigits == productOfDigits) {
            isSpy = true;
        }
        return isSpy;
    }

    public static boolean isASquareNumber(String userStartNumber) {
        boolean isSquare = false;
        double rootOfUserNumber = sqrt(Double.parseDouble(userStartNumber));
        if (rootOfUserNumber == (int) rootOfUserNumber) {
            isSquare = true;
        }
        return isSquare;
    }

    public static boolean isASunnyNumber(String userStartNumber) {
        boolean isSunny = false;
        Long sunnyCandidate = Long.parseLong(userStartNumber) + CORRECTION_DIGIT;

        double rootOfSunnyCandidate = sqrt(sunnyCandidate);
        if (rootOfSunnyCandidate == (long) rootOfSunnyCandidate) {
            isSunny = true;
        }
        return isSunny;
    }

    public static boolean isAJumpingNumber(String userStartNumber) {
        boolean isJumping = true;
        for (int i = 0; i < userStartNumber.length() - CORRECTION_DIGIT; i++) {
            int firstNumber = Integer.parseInt(String.valueOf(userStartNumber.charAt(i)));
            int nextNumber = Integer.parseInt(String.valueOf(userStartNumber.charAt(i + CORRECTION_DIGIT)));
            if (Math.abs(firstNumber - nextNumber) != CORRECTION_DIGIT) {
                isJumping = false;
                break;
            }
        }

        return isJumping;
    }

    public static boolean isAHappyNumber(String userStartNumber) {
        boolean isHappy = true;
        long result = 0;
        while (result != 1 ) {
            result = 0;
            for (int i = 0; i < userStartNumber.length(); i++) {
                result += pow(Long.parseLong(String.valueOf(userStartNumber.charAt(i))), 2);
            }
            if (result == 4) {
                isHappy = false;
                break;
            }
            userStartNumber = Long.toString(result);
        }

        return isHappy;
    }
}

