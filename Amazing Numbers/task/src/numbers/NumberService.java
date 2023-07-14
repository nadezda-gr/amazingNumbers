package numbers;

public class NumberService {
    public void processEvenAndOddProperty(Number number) {
        Long numberValue = number.getNumberValue();
        boolean isEven = numberValue % 2 == 0;
        NumberProperty evenProperty = createProperty("even", isEven);
        number.getNumberProperties().add(evenProperty);

        NumberProperty oddProperty = createProperty("odd", !isEven);
        number.getNumberProperties().add(oddProperty);
    }

    public void processBuzzProperty(Number number) {
        boolean isBuzz = isBuzz(number.getNumberValue());
        NumberProperty buzzProperty = createProperty("buzz", isBuzz);
        number.getNumberProperties().add(buzzProperty);
    }

    public void processDuckProperty(Number number) {
        boolean isDuck = isDuck(number.getStringValue());
        NumberProperty duckProperty = createProperty("duck", isDuck);
        number.getNumberProperties().add(duckProperty);
    }

    public void processPalindromicProperty(Number number) {
        boolean isPalindromic = isPalindromic(number.getStringValue());
        NumberProperty palindromicProperty = createProperty("palindromic", isPalindromic);
        number.getNumberProperties().add(palindromicProperty);
    }

    private static boolean isBuzz(Long numberValue) {
        boolean isDivisibleBySeven = numberValue % 7 == 0;
        boolean endsWithSeven = numberValue % 10 == 7;
        return isDivisibleBySeven || endsWithSeven;
    }

    private boolean isDuck(String stringValue) {
        return stringValue.substring(1).contains("0");
    }

    private boolean isPalindromic(String stringValue) {
        return stringValue.equals(new StringBuilder(stringValue).reverse().toString());
    }

    private NumberProperty createProperty(String name, boolean booleanValue) {
        NumberProperty numberProperty = new NumberProperty();
        numberProperty.setName(name);
        numberProperty.setBooleanValue(booleanValue);
        numberProperty.setResult(getResult(name, booleanValue));
        return numberProperty;
    }

    private String getResult(String name, boolean booleanValue) {
        return name + ": " + booleanValue;
    }



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
