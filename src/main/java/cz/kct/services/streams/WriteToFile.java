package cz.kct.services.streams;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {
    public static final String ID = "id";
    public static final String VALUE = "value";
    public static final String FIRST_VALUE = "1";
    public static final String SECOND_VALUE = "72";
    public void writeToFile(String filePath, String tableName) throws IOException {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.createSheet(tableName);
        Object[][] countryData = {
                {ID, VALUE},
                {FIRST_VALUE, SECOND_VALUE}
        };
        int rowCount = 0;
        for (Object[] arrayData : countryData)
        {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            for (Object obj : arrayData)
            {
                Cell cell = row.createCell(columnCount++);
                if (obj instanceof String)
                {
                    cell.setCellValue((String)obj);
                }
                else if (obj instanceof Integer)
                {
                    cell.setCellValue((Integer)obj);
                }
            }
        }
        FileOutputStream fos = new FileOutputStream(filePath);
        wb.write(fos);
        fos.close();
    }
}
