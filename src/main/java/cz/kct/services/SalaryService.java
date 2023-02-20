package cz.kct.services;

import cz.kct.data.dto.PersonDto;
import cz.kct.data.dto.SalaryDto;
import cz.kct.data.entity.PersonEntity;
import cz.kct.data.entity.SalaryEntity;
import cz.kct.data.mapper.PersonMapper;
import cz.kct.data.mapper.SalaryMapper;
import cz.kct.repository.PersonRepository;
import cz.kct.repository.SalaryRepository;
import feign.Param;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class SalaryService {

    private SalaryRepository salaryRepository;
    private SalaryMapper salaryMapper;
    public SalaryDto findOne(int id) {
        Optional<SalaryEntity> salaryEntityOptional = salaryRepository.findById(id); // see
        SalaryDto salaryDto = salaryMapper.mapToDto(salaryEntityOptional.get());
        return salaryDto;
    }

    public List<PersonEntity> joinSalaryWithEmployees() {
        log.info("DATA IS = {}", salaryRepository.getJoinInformation());
        return salaryRepository.getJoinInformation();
    }

    public List<PersonEntity> joinSalaryWithEmployeesOlderThanThirty(int age) {
        log.info("Older than = {}: = {}", age, salaryRepository.getJoinedPeopleOlderThanThirty(age));
        return salaryRepository.getJoinedPeopleOlderThanThirty(age);
    }

    public SalaryDto findOneSalary(Double quantity, int id) {
        log.info("Find certain salary");
        List<SalaryEntity> salaryEntities = salaryRepository.findByQty(quantity, id);
        SalaryDto salaryDto = salaryMapper.mapToDto(salaryEntities.get(0));
        return salaryDto;
    }
    @Scheduled(cron = "*/5 * * * * *")
    public void invokeCron() {
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);
    }
}
