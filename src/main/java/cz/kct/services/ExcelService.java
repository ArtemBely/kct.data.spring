package cz.kct.services;
import cz.kct.data.entity.ExcelEntity;
import cz.kct.repository.ExcelRepository;
import cz.kct.utilities.ValueConvertUtility;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.io.File;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import java.io.FileOutputStream;

import java.io.*;

@Service
@Slf4j
@AllArgsConstructor

public class ExcelService {
    private final String filePath = "C:\\Users\\artem.belyshev\\IdeaProjects\\kct.data.spring\\src\\main\\java\\cz\\kct\\testApp.xlsx";
    private final ExcelRepository excelRepository;
    private ValueConvertUtility valueConvertUtility;

    public void writeToFile() throws IOException {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.createSheet("Values");
        Object[][] countryData = {
                {"id", "value"},
                {"1", "16"}
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
        log.info("testApp.xlsx written successfully");
    }

    public String readFromFile() {
        String vOutput=this.ReadFromExcel(1, 1);
        log.info(vOutput);
        return vOutput;
    }
    public String ReadFromExcel(int vRow, int vColumn) {
        String value;
        Workbook wb=null;
        try {
            FileInputStream fis=new FileInputStream(filePath);
            wb=new XSSFWorkbook(fis);
        } catch(IOException e) {
            e.printStackTrace();
        }
        Sheet sheet=wb.getSheet("Values");
        Row row=sheet.getRow(vRow);
        Cell cell=row.getCell(vColumn);
        value=cell.getStringCellValue();
        return value;
    }

    public void insert() {
        log.info("start process insert value in services");
        excelRepository.save(new ExcelEntity(valueConvertUtility.getHexString(this.readFromFile())));
        log.info("end process insert value in services");
    }
}

