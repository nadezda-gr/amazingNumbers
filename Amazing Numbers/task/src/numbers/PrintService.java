package numbers;

import java.util.List;
import java.util.Locale;

public class PrintService {

    public void printNumber(Number number) {
        List<NumberProperty> numberProperties = number.getNumberProperties();
        String formattedNumber = String.format(Locale.US, "%,d", number.getNumberValue());
        System.out.println("\nProperties of " + formattedNumber);
        for (NumberProperty numberProperty : numberProperties) {
            System.out.println(numberProperty.getResult());
        }
    }

    public void printNumbers(List<Number> numbers) {
        System.out.println();
        for (Number number : numbers) {
            System.out.println(number.getStringValue() + " is " + getPropertiesString(number));
        }
    }

    private String getPropertiesString(Number number) {
        StringBuilder sb = new StringBuilder();
        for (String propertyName : number.getAllTrueProperties()) {
            sb.append(propertyName + ", ");
        }
        String propertiesString = sb.toString();
        if (propertiesString.isEmpty()) {
            return "";
        }
        return propertiesString.substring(0, propertiesString.length() - 2);
    }
}
