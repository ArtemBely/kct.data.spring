package cz.kct.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
@Slf4j
@AllArgsConstructor

public class ExcelService {
    private final String fileName = "C:\\Users\\artem.belyshev\\IdeaProjects\\kct.data.spring\\src\\main\\java\\cz\\kct\\psql.xlsx";
    public void catchDataFromExcel() {
        try {
            FileInputStream file = new FileInputStream(new File(fileName));
            int content = file.read();
//            while ((content = file.read()) != -1) {
//                System.out.println((char)content);
//            }
            System.out.println((char)content);
            file.close();
        }
        catch (IOException e) { e.printStackTrace(); }
    }
}
