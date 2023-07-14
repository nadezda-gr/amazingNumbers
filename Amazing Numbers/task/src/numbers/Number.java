package numbers;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private Long numberValue;
    private List<NumberProperty> numberProperties = new ArrayList<>();

    public Number(Long input) {
        numberValue = input;
    }

    public Long getNumberValue() {
        return numberValue;
    }

    public void setNumberValue(Long numberValue) {
        this.numberValue = numberValue;
    }

    public List<NumberProperty> getNumberProperties() {
        return numberProperties;
    }

    public void setNumberProperties(List<NumberProperty> numberProperties) {
        this.numberProperties = numberProperties;
    }
}
