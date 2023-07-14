package numbers;

import java.util.List;

public class PrintService {

    public void printNumber(Number number) {
        List<NumberProperty> numberProperties = number.getNumberProperties();
        for (NumberProperty numberProperty : numberProperties) {
            System.out.println(numberProperty.getResult());
            if (!numberProperty.getExplanation().isEmpty()) {
                System.out.println("Explanation:");
                System.out.println(numberProperty.getExplanation());
            }
        }
    }
}
