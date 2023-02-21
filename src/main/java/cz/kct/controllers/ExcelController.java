package cz.kct.controllers;

import cz.kct.services.ExcelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/excel")

public class ExcelController {
    private final ExcelService excelService;
    @GetMapping("/v1/save")
    public void showData() throws IOException, ClassNotFoundException {
        excelService.readFromFile();
    }

    @GetMapping("/v1/insert")
    public void saveData() throws IOException {
        excelService.writeToFile();
    }
}
