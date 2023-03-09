package cz.kct.utilities;

import cz.kct.exceptions.ExcelException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class ValueConvertUtility {
    public String getHexString(String value) throws ExcelException {
        if(value != null) {
            int binaryValue = Integer.parseInt(value);
            return Integer.toHexString(binaryValue);
        }
        else throw new ExcelException("Value is null");
    }
}
