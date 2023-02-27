package cz.kct.utilities;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class ValueConvertUtility {
    public String getHexString(String value) {
        int binaryValue = Integer.parseInt(value);
        return Integer.toHexString(binaryValue);
    }
}
