package cz.kct.services;
import cz.kct.data.entity.ExcelEntity;
import cz.kct.repository.ExcelRepository;
import cz.kct.services.streams.ReadFromExcel;
import cz.kct.services.streams.WriteToFile;
import cz.kct.utilities.ValueConvertUtility;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
@Slf4j
@AllArgsConstructor

public class ExcelService {
    private final String filePath = "C:\\Users\\artem.belyshev\\IdeaProjects\\kct.data.spring\\src\\main\\java\\cz\\kct\\testApp.xlsx";
    private final ExcelRepository excelRepository;
    private ValueConvertUtility valueConvertUtility;
    private ReadFromExcel readFromExcel;
    private WriteToFile writeToFile;
    private final String tableName = "Values";

    public void writeToFile() throws IOException {
        writeToFile.writeToFile(filePath, tableName);
    }

    public String readFromFile() {
        String vOutput = readFromExcel.ReadFromExcel(1, 1, filePath, tableName);
        log.info("Data from file: {}", vOutput);
        return vOutput;
    }

    public void insert() {
        log.info("start process insert value in services");
        excelRepository.save(new ExcelEntity(valueConvertUtility.getHexString(this.readFromFile())));
        log.info("end process insert value in services");
    }
}

