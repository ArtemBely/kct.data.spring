package cz.kct.controllers;
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
    public void showData() {
        excelService.readFromFile();
    }

    @GetMapping("/v1/insert")
    public void saveData() throws IOException {
        excelService.writeToFile();
    }

    @GetMapping("/v1/save")
    public void saveValue() {
        log.info("start process insert value in controller");
        excelService.insert();
        log.info("end process insert value in controller");
    }
}
