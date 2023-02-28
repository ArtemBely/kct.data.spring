package cz.kct.controllers;
import cz.kct.exceptions.ExcelException;
import cz.kct.services.ExcelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/excel")

public class ExcelController {
    private final ExcelService excelService;
    @GetMapping("/v1/get")
    public void showData() throws ExcelException {
        log.info("start process of getting data from excel");
        excelService.readFromFile();
        log.info("data from excel was received");
    }
    @GetMapping("/v1/insert")
    public void saveData() {
        log.info("start process of creation table and writing into excel");
        excelService.writeToFile();
        log.info("end process of creation table and writing into excel");
    }
    @GetMapping("/v1/save")
    public void saveValue() {
        log.info("start process insert value in controller");
        excelService.insert();
        log.info("end process insert value in controller");
    }
}
