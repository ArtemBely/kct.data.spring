package cz.kct.services.streams;

import cz.kct.exceptions.ExcelException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;
@Slf4j
@UtilityClass

public class ExcelUtility {

    public Workbook getWorkBook(String filePath) throws ExcelException {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            return new XSSFWorkbook(fis); // +Optional
        } catch(IOException e) {
            log.error(e.toString());
            throw new ExcelException(e.getMessage());
        }
    }
    public String getValue(int vRow, int vColumn, Workbook wb, String tableName) {
        Sheet sheet = wb.getSheet(tableName);
        Row row = sheet.getRow(vRow);
        Cell cell = row.getCell(vColumn);
        return cell.getStringCellValue();
    }
}
