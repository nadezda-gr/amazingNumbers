package numbers;

public enum Properties {
    EVEN("even: "),
    ODD("odd: "),
    BUZZ("buzz: "),
    DUCK("duck: ");

    private final String text;

    Properties(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
