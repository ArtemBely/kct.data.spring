package cz.kct.controllers;

import cz.kct.data.dto.PersonDto;
import cz.kct.data.dto.SalaryDto;
import cz.kct.data.entity.PersonEntity;
import cz.kct.data.entity.SalaryEntity;
import cz.kct.repository.PersonRepository;
import cz.kct.repository.SalaryRepository;
import cz.kct.services.SalaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public List<PersonEntity> joinSalaryAndPerson() {
       return salaryService.joinSalaryWithEmployees();
    }

    @GetMapping("/v1/get/byname")
    @ResponseBody
    public SalaryDto findSalary(@RequestParam Double quantity, @RequestParam int id) {
        log.info("start to find quantity: {}, ID: {} ",  quantity, id);
        SalaryDto salary = salaryService.findOneSalary(quantity, id);
        log.info("end to find quantity: {}, ID: {} ",  quantity, id);
        return salary;
    }

}