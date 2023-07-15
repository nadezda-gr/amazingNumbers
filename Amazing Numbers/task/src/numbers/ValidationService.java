package numbers;

public class ValidationService {

    public static Long getValidFirstNaturalNumber(String input) throws Exception {
        try {
            long number = Long.parseLong(input);
            validateNaturalNumber(number);
            return number;
        } catch (NumberFormatException e) {
            throw new Exception("\nThe first parameter should be a natural number or zero.");
        }
    }

    public static Long getValidSecondNaturalNumber(String input) throws Exception {
        try {
            Long secondNaturalNumber = Long.parseLong(input);
            if (secondNaturalNumber < 1) {
                throw new Exception("\nThe second parameter should be a natural number.");
            }
            return secondNaturalNumber;
        } catch (NumberFormatException e) {
            throw new Exception("\nThe second parameter should be a natural number.");
        }
    }

    public static void validateNaturalNumber(Long numberValue) throws Exception {
        if (numberValue < 1) {
            throw new Exception("\nThe first parameter should be a natural number or zero.");
        }
    }
}
