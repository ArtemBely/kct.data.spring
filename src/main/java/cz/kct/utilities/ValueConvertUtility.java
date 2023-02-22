package cz.kct.utilities;

public class ValueConvertUtility {
    public String getHexString(String value) {
        int binaryValue = Integer.parseInt(value);
        return Integer.toHexString(binaryValue);
    }
}
