package cz.kct.services;

import cz.kct.data.dto.ExcelDto;
import cz.kct.data.entity.ExcelEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor

public class ExcelService {
    private final String fileName = "C:\\Users\\artem.belyshev\\IdeaProjects\\kct.data.spring\\src\\main\\java\\cz\\kct\\testApp.csv";
    List<ExcelEntity> lines = new ArrayList<>();
    public void readFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objIn = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            if (fileIn == null) {
                throw new IOException("Can't find file.");
            }
            objIn= new ObjectInputStream(fileIn);
            while (true) {
                ExcelEntity unit = (ExcelEntity) objIn.readObject();
                lines.add(unit);
                System.out.println(unit);
            }
        }
        catch (EOFException e) {
            try {
                if (objIn != null) {
                    objIn.close();
                }
            }
            catch (IOException closeException) {
                System.out.println("printStackTrace");
            }
        }
    }

    public void writeToFile() throws IOException {
        FileOutputStream outputStream = new FileOutputStream(fileName);
        try (ObjectOutputStream objOutStream = new ObjectOutputStream(outputStream)) {
                ExcelDto dto = new ExcelDto(1, 5);
                objOutStream.writeObject(dto);
                System.out.println(dto);
            }
       // objOutStream.close();
        }

}
