package numbers;

public class ValidationService {

    public static void validateNaturalNumber(Long numberValue) throws Exception {
        if (numberValue < 1) {
            throw new Exception("This number is not natural!");
        }
    }
}
