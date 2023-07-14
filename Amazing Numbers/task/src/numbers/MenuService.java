package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MenuService {

    public static final String[][] MUTUALLY_EXCLUSIVE_PROPERTIES = {
            {Properties.EVEN.name(), Properties.ODD.name()},
            {Properties.DUCK.name(), Properties.SPY.name()},
            {Properties.SUNNY.name(), Properties.SQUARE.name()},
            {Properties.HAPPY.name(), Properties.SAD.name()},

    };

    static void printWelcome() {
        System.out.print("Welcome to Amazing Numbers!\n");
    }

    static void printSupportedRequests() {
        System.out.println("\nSupported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be processed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- a property preceded by minus must not be present in numbers;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");
    }

    static boolean resultsForTwoInputs(String[] splitedInput, Long userNumber) {
        Long userIndex = Long.parseLong(splitedInput[1]);
        if (userIndex <= 0) {
            System.out.println("\nThe second parameter should be a natural number.");
            return true;
        }
        for (int i = 0; i < userIndex; i++) {
            Long number = userNumber + i;
            String numberAsString = number.toString();
            PrintResultService.printMoreNumbersResult(number, numberAsString);
        }
        return false;
    }

    static boolean resultsForThreeInputs(Set<Properties> availableProperties, String[] splitedInput, Long userNumber) {
        Long userIndex = Long.parseLong(splitedInput[1]);
        String property = splitedInput[2].toUpperCase();
        if (userIndex <= 0) {
            System.out.println("\nThe second parameter should be a natural number.");
            return true;
        }
        boolean contains = false;
        boolean startsWithMinus = property.startsWith("-");
        if (startsWithMinus) {
            StringBuilder propertyMinus = new StringBuilder(property);
            propertyMinus.deleteCharAt(0);
            for (Properties enumValue : availableProperties) {
                if (enumValue.name().equals(String.valueOf(propertyMinus))) {
                    contains = true;
                    break;
                }
            }
        } else {
            for (Properties enumValue : availableProperties) {
                if (enumValue.name().equals(property)) {
                    contains = true;
                    break;
                }
            }
        }

        if (!contains) {
            System.out.println("\nThe property [" + property + "] is wrong.");
            System.out.println("Available properties: " + availableProperties);
        } else {
            PrintResultService.printNumbersWithPropertyResult(userIndex, userNumber, property, startsWithMinus);
        }
        return false;
    }

    static boolean resultsForMoreInputs(String[] splitedInput, Long userNumber, Set<Properties> availableProperties) {
        Long userIndex = Long.parseLong(splitedInput[1]);
        List<String> correctProperties = new ArrayList<>();
        List<String> wrongProperties = new ArrayList<>();
        List<String> minusProperties = new ArrayList<>();
        List<String> minusWithoutMinusProperties = new ArrayList<>();

        if (userIndex <= 0) {
            System.out.println("\nThe second parameter should be a natural number.");
            return true;
        }

        for (int i = 2; i < splitedInput.length; i++) {
            boolean startsWithMinus = splitedInput[i].startsWith("-");
            if (!startsWithMinus && Properties.exists(splitedInput[i].toUpperCase())) {
                correctProperties.add(splitedInput[i].toUpperCase());
            }
            else {
                String propertyWithoutMinus = splitedInput[i].replace("-", "").toUpperCase();
                if (startsWithMinus && Properties.exists(propertyWithoutMinus)) {
                    minusProperties.add(splitedInput[i].toUpperCase());
                    minusWithoutMinusProperties.add(propertyWithoutMinus);
                } else {
                    wrongProperties.add(splitedInput[i].toUpperCase());
                }
            }
        }

        if (!wrongProperties.isEmpty()) {
            System.out.println("The " + (wrongProperties.size() > 1 ? "properties" : "property")
                    + " [" + String.join(", ", wrongProperties) + "] "
                    + (wrongProperties.size() > 1 ? "are" : "is") + " wrong.\n" + "Available properties: "
                    + availableProperties);
            return true;
        }
        List<String> mutExclProperties = new ArrayList<>();

        for (String element : minusProperties) {
            if (correctProperties.contains(element.replace("-", ""))) {
                mutExclProperties.add(element);
                mutExclProperties.add(element.replace("-", ""));
            }
        }

        for (String[] muExProperties : MUTUALLY_EXCLUSIVE_PROPERTIES) {
            List<String> listMuExProperties = List.of(muExProperties);
            if (correctProperties.containsAll(listMuExProperties)) {
                mutExclProperties.addAll(listMuExProperties);
            }
            if (minusWithoutMinusProperties.containsAll(listMuExProperties)) {
                mutExclProperties.addAll(listMuExProperties.stream().map(p -> "-" + p).toList());
            }
        }
        if (!mutExclProperties.isEmpty()) {
            System.out.println("The request contains mutually exclusive properties: [" + String.join(",", mutExclProperties) + "]\n" +
                    "There are no numbers with these properties.");
            return true;
        }
        if (mutExclProperties.isEmpty()) {
            PrintResultService.printNumbersWithMorePropertiesResult(userIndex, userNumber, correctProperties, minusProperties);
        }

        return false;
    }

}
