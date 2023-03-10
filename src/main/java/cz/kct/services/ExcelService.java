package cz.kct.services;
import cz.kct.data.entity.ExcelEntity;
import cz.kct.exceptions.ExcelException;
import cz.kct.repository.ExcelRepository;
import cz.kct.utilities.ExcelUtility;
import cz.kct.services.streams.WriteToFile;
import cz.kct.utilities.ValueConvertUtility;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor

public class ExcelService {
    public static final int ROW = 1;
    public static final int COLUMN = 1;
    public static final String FILE_PATH = "C:\\Users\\belysheva\\Desktop\\gradle\\src\\main\\java\\cz\\kct\\testApp.xlsx";
    private final String tableName = "Values";
    private final ExcelRepository excelRepository;
    private WriteToFile writeToFile;

    public void writeToFile() {
        try {
            log.info("start process of writing data into excel");
            writeToFile.writeToFile(FILE_PATH, tableName);
            log.info("end process of writing data into excel");
        }
        catch (Exception e) {
            log.error(e.toString());
        }
    }

    public String readFromFile() throws ExcelException {
        Optional<XSSFWorkbook> vOutput = ExcelUtility.getWorkBook(FILE_PATH);
        if(vOutput.isPresent()) {
            return ExcelUtility.getValue(ROW, COLUMN, vOutput.get(), tableName);
        }
        else {
            throw new ExcelException("File path is not valid");
        }
    }

    public void insert() {
        try {
            log.info("start process insert value in services");
            String value = ValueConvertUtility.getHexString(readFromFile());
            excelRepository.save(new ExcelEntity(value));
            log.info("end process insert value in services");
        }
        catch (ExcelException e) {
            log.error(e.toString());
        }
    }
}

