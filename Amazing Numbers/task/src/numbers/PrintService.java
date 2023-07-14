package numbers;

import java.util.List;

public class PrintService {

    public void printNumber(Number number) {
        System.out.println("Properties of " + number.getStringValue());
        for (NumberProperty numberProperty : number.getNumberProperties()) {
            System.out.println(numberProperty.getResult());
        }
    }
}
