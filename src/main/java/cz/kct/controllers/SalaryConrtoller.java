package cz.kct.controllers;

import cz.kct.data.dto.SalaryDto;
import cz.kct.repository.SalaryRepository;
import cz.kct.services.SalaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/salary")

public class SalaryConrtoller {

    private final SalaryService salaryService;

    @GetMapping("/v1/connect")
    public void connect(){
        log.info("This is an INFO level log message!");
    }
    @ResponseBody
    @GetMapping("/v1/getOne")
    public SalaryDto findRelatedSalary(@RequestParam int id) {
        SalaryDto salary = salaryService.findOne(id);
        return salary;
    }

    @GetMapping("/v1/join")
    public String joinSalaryAndPerson() {
       return salaryService.joinSalaryWithEmployees();
    }

}