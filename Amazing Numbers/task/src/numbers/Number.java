package numbers;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private String stringValue;
    private Long numberValue;
    private List<NumberProperty> numberProperties = new ArrayList<>();

    public Number(String input) {
        stringValue = input;
        numberValue = Long.parseLong(stringValue);
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
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
