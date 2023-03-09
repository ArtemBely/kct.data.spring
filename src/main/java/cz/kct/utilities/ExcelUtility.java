package cz.kct.utilities;

import cz.kct.exceptions.ExcelException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;

@Slf4j
@UtilityClass

public class ExcelUtility {

    public Optional<XSSFWorkbook>getWorkBook(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Optional<XSSFWorkbook> wb = Optional.of(new XSSFWorkbook(fis));
            return wb;
        } catch(IOException e) {
            log.error("Wrong file name. {}", e.getMessage());
            return Optional.ofNullable(null);
        }
    }
    public String getValue(int vRow, int vColumn, Workbook wb, String tableName) {
        Sheet sheet = wb.getSheet(tableName);
        Row row = sheet.getRow(vRow);
        Cell cell = row.getCell(vColumn);
        log.info("Data is: {}:", cell.getStringCellValue());
        return cell.getStringCellValue();
    }
}
