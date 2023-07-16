package numbers;

import java.util.ArrayList;
import java.util.List;

public enum AllowedProperty {
    EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING;

    public static String getAllowedPropertiesString() {
        StringBuilder sb = new StringBuilder();
        for (AllowedProperty notAllowedProperty : values()) {
            sb.append(notAllowedProperty + ", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public static List<String> getNotAllowedPropertiesFromSearcList(List<String> searchList) {
        List<String> allowedProperties = new ArrayList<>();
        for (AllowedProperty property : AllowedProperty.values()) {
            allowedProperties.add(property.toString());
        }

        List<String> notAllowedProperties = new ArrayList<>();
        for (String property : searchList) {
            if (!allowedProperties.contains(property.toUpperCase())) {
                notAllowedProperties.add(property);
            }
        }
        return notAllowedProperties;
    }

    public static String getMutuallyExclusivePropertiesStringIfExists(List<String> searchList) {
        if (searchListContainsProperties(searchList, ODD, EVEN)) {
            return getMutuallyExclusivePropertiesString(searchList, ODD, EVEN);
        } else if (searchListContainsProperties(searchList, SQUARE, SUNNY)) {
            return getMutuallyExclusivePropertiesString(searchList, SQUARE, SUNNY);
        } else if (searchListContainsProperties(searchList, DUCK, SPY)) {
            return getMutuallyExclusivePropertiesString(searchList, DUCK, SPY);
        }
        return "";
    }
    private static boolean searchListContainsProperties(List<String> searchList, AllowedProperty property1, AllowedProperty property2) {
        return searchList.contains(property1.name().toLowerCase()) && searchList.contains(property2.name().toLowerCase());
    }

    private static String getMutuallyExclusivePropertiesString(List<String> searchList, AllowedProperty property1, AllowedProperty property2) {
        List<String> criterias = new ArrayList<>();
        for (String searchCriteria : searchList) {
            if (searchCriteria.toUpperCase().equals(property1.name()) || searchCriteria.toUpperCase().equals(property2.name())) {
                criterias.add(searchCriteria.toUpperCase());
            }
        }
        return criterias.get(0) + ", " + criterias.get(1);
    }
}
