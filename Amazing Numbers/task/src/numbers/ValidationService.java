package numbers;

public class ValidationService {

    public static void validateNaturalNumber(Long numberValue) throws Exception {
        if (numberValue < 1) {
            throw new Exception("The first parameter should be a natural number or zero.");
        }
    }
}
