package numbers;

import java.util.List;

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

    public static void validateAllowedPropertySearch(List<String> searchList) throws Exception {
        List<String> notAllowedProperties = AllowedProperty.getNotAllowedPropertiesFromSearcList(searchList);
        if (notAllowedProperties.size() == 1) {
            String notAllowedPropertiesString = getNotAllowedPropertiesAsString(notAllowedProperties);
            throw new Exception("\nThe property [" + notAllowedPropertiesString + "] is wrong.\nAvailable properties: [" + AllowedProperty.getAllowedPropertiesString() + "]");
        }
        if (notAllowedProperties.size() > 1) {
            String notAllowedPropertiesString = getNotAllowedPropertiesAsString(notAllowedProperties);
            throw new Exception("\nThe properties [" + notAllowedPropertiesString + "] are wrong.\nAvailable properties: [" + AllowedProperty.getAllowedPropertiesString() + "]");
        }
    }

    private static String getNotAllowedPropertiesAsString(List<String> notAllowedProperties) {
        StringBuilder sb = new StringBuilder();
        for (String notAllowedProperty : notAllowedProperties) {
            sb.append(notAllowedProperty + ", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString().toUpperCase();
    }

    public static void validateMutuallyExclusiveProperties(List<String> searchList) throws Exception {
        String mutuallyExclusiveProperties = AllowedProperty.getMutuallyExclusivePropertiesStringIfExists(searchList);
        if (!mutuallyExclusiveProperties.isEmpty()) {
            throw new Exception("\nThe request contains mutually exclusive properties: [" + mutuallyExclusiveProperties + "]\nThere are no numbers with these properties.");
        }
    }
}
