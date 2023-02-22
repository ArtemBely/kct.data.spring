package cz.kct.services.streams;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFromExcel {
    public String ReadFromExcel(int vRow, int vColumn, String filePath, String tableName) {
        String value;
        Workbook wb = null;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            wb = new XSSFWorkbook(fis);
        } catch(IOException e) {
            e.printStackTrace();
        }
        Sheet sheet = wb.getSheet(tableName);
        Row row = sheet.getRow(vRow);
        Cell cell = row.getCell(vColumn);
        value = cell.getStringCellValue();
        return value;
    }
}
