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
}
