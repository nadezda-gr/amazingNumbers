package numbers;

public enum Properties {
    EVEN(" even"),
    ODD(" odd"),
    BUZZ(" buzz"),
    DUCK(" duck"),
    PALINDROMIC(" palindromic"),
    GAPFUL(" gapful"),
    SPY(" spy"),
    SQUARE (" square"),
    SUNNY (" sunny"),
    JUMPING (" jumping"),
    HAPPY (" happy"),
    SAD(" sad");

    private final String text;

    Properties(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static boolean exists(String name) {
        for (Properties p: values()) {
            if (p.name().equals(name)) {
                return true;
            }
        }

        return false;
    }
}
