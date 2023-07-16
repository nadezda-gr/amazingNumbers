package numbers;

import java.util.ArrayList;
import java.util.List;

public enum AllowedProperty {
    EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD;

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
            allowedProperties.add("-" + property);
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
        List<String> allMutuallyExclusiveProperties = createAllMutuallyExclusiveProperties();
        String result = "";
        for (String exclusivePropertyPair : allMutuallyExclusiveProperties) {
            if (result.isEmpty()) {
                result = getExclusivePropertyPairString(searchList, exclusivePropertyPair);
                if (!result.isEmpty()) {
                    return result;
                }
            }
        }
        return "";
    }

    private static String getExclusivePropertyPairString(List<String> searchList, String exclusivePropertyPair) {
        String[] exclusivePairSplit = exclusivePropertyPair.split(",");
        String property1 = exclusivePairSplit[0];
        String property2 = exclusivePairSplit[1];
        List<String> criterias = new ArrayList<>();
        for (String searchCriteria : searchList) {
            if (searchCriteria.toUpperCase().equals(property1) || searchCriteria.toUpperCase().equals(property2)) {
                criterias.add(searchCriteria.toUpperCase());
            }
            if (criterias.size() == 2) {
                return criterias.get(0) + ", " + criterias.get(1);
            }
        }
        return "";
    }

    private static List<String> createAllMutuallyExclusiveProperties() {
        List<String> allMutuallyExclusiveProperties = new ArrayList<>();
        allMutuallyExclusiveProperties.addAll(createMutuallyExclusiveProperties(ODD.name(), EVEN.name()));
        allMutuallyExclusiveProperties.addAll(createMutuallyExclusiveProperties(SQUARE.name(), SUNNY.name()));
        allMutuallyExclusiveProperties.addAll(createMutuallyExclusiveProperties(DUCK.name(), SPY.name()));
        allMutuallyExclusiveProperties.addAll(createMutuallyExclusiveProperties(HAPPY.name(), SAD.name()));
        return allMutuallyExclusiveProperties;
    }

    private static List<String> createMutuallyExclusiveProperties(String property1, String property2) {
        List<String> mutuallyExclusive = new ArrayList<>();
        mutuallyExclusive.add(property1 + "," + property2);
        mutuallyExclusive.add("-" + property1 + ",-" + property2);
        mutuallyExclusive.add("-" + property1 + "," + property1);
        mutuallyExclusive.add("-" + property2 + "," + property2);
        return mutuallyExclusive;
    }

}
