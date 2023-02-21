package cz.kct.controllers;

import cz.kct.data.dto.SalaryDto;
import cz.kct.data.entity.PersonEntity;
import cz.kct.services.SalaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/salary")

public class SalaryConrtoller {

    private final SalaryService salaryService;

    @GetMapping("/v1/connect")
    @Scheduled(cron = "*/10 * * * * *")
    public void connect(){
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);
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

    @GetMapping("/v1/older")
    public List<PersonEntity> joinSalaryAndPersonOlderThanThirty(@RequestParam int age) {
        return salaryService.joinSalaryWithEmployeesOlderThanThirty(age);
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