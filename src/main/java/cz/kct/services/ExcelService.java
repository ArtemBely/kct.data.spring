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
import org.springframework.stereotype.Service;

import java.io.*;

@Service
@Slf4j
@AllArgsConstructor

public class ExcelService {
    public static final int ROW = 1;
    public static final int COLUMN = 1;
    public static final String FILE_PATH = "C:\\Users\\artem.belyshev\\IdeaProjects\\kct.data.spring\\src\\main\\java\\cz\\kct\\testApp.xlsx";
    private final String tableName = "Values";
    private final ExcelRepository excelRepository;
    private WriteToFile writeToFile;

    public void writeToFile() throws IOException {
        writeToFile.writeToFile(FILE_PATH, tableName);
    }

    public String readFromFile() throws ExcelException {
        Workbook vOutput = ExcelUtility.getWorkBook(FILE_PATH);
        String vOutputString = ExcelUtility.getValue(ROW, COLUMN, vOutput, tableName);
        log.info("Data from file: {}", vOutputString);
        return vOutputString;
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

