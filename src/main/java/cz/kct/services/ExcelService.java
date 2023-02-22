package cz.kct.services;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.io.File;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import java.io.FileOutputStream;

import java.util.Map;

import java.util.Set;

import java.util.TreeMap;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor

public class ExcelService {

    private final String filePath = "C:\\Users\\artem.belyshev\\IdeaProjects\\kct.data.spring\\src\\main\\java\\cz\\kct\\testApp.xlsx";
    public void writeToFile() throws IOException {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.createSheet("Test table");
        Object[][] countryData = {
                {"id", "value"},
                {"1", "10"}
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

    public void readFromFile() throws IOException {
        ExcelService rc = new ExcelService();
        String vOutput=rc.ReadFromExcel(2, 2);
        System.out.println(vOutput);
    }
    public String ReadFromExcel(int vRow, int vColumn) throws IOException {
        String value=null;
        Workbook wb=null;
        try {
            FileInputStream fis=new FileInputStream(filePath);
            wb=new XSSFWorkbook(fis);
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e1) {
            e1.printStackTrace();
        }
        Sheet sheet=wb.getSheetAt(0);
        Row row=sheet.getRow(vRow);
        Cell cell=row.getCell(vColumn);
        value=cell.getStringCellValue();
        return value;
    }
}

