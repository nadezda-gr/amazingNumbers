package numbers;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

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

    public void processGapfulProperty(Number number) {
        boolean isGapful = isGapful(number.getStringValue(), number.getNumberValue());
        NumberProperty gapfulProperty = createProperty("gapful", isGapful);
        number.getNumberProperties().add(gapfulProperty);
    }

    public void processSpyProperty(Number number) {
        boolean isSpy = isSpy(number.getStringValue());
        NumberProperty spyProperty = createProperty("spy", isSpy);
        number.getNumberProperties().add(spyProperty);
    }

    public void processSquareProperty(Number number) {
        boolean isSquare = isSquare(number.getNumberValue());
        NumberProperty squareProperty = createProperty("square", isSquare);
        number.getNumberProperties().add(squareProperty);
    }

    public void processSunnyProperty(Number number) {
        boolean isSunny = isSunny(number.getNumberValue());
        NumberProperty sunnyProperty = createProperty("sunny", isSunny);
        number.getNumberProperties().add(sunnyProperty);
    }

    public void createAndSetAllTrueProperties(Number number) {
        List<String> allTrueProperties = new ArrayList<>();
        for (NumberProperty numberProperty : number.getNumberProperties()) {
            if (numberProperty.isBooleanValue()) {
                allTrueProperties.add(numberProperty.getName());
            }
        }
        number.setAllTrueProperties(allTrueProperties);
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

    private boolean isGapful(String stringValue, Long numberValue) {
        if (stringValue.length() < 3) {
            return false;
        }
        String firstNumber = stringValue.substring(0, 1);
        String lastNumber = stringValue.substring(stringValue.length() - 1);
        Long divider = Long.valueOf(firstNumber + lastNumber);
        return numberValue % divider == 0;
    }

    private boolean isSpy(String numberValue) {
        int sum = 0;
        int product = 1;

        for (char digit : numberValue.toCharArray()) {
            int num = Character.getNumericValue(digit);
            sum += num;
            product *= num;
        }
        return sum == product;
    }

    private boolean isSquare(Long numberValue) {
        return sqrt(numberValue) == (int) sqrt(numberValue);
    }

    private boolean isSunny(Long numberValue) {
        return isSquare(numberValue + 1);
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
}
