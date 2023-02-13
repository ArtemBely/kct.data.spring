package cz.kct.services;

import cz.kct.data.dto.PersonDto;
import cz.kct.data.dto.SalaryDto;
import cz.kct.data.entity.PersonEntity;
import cz.kct.data.entity.SalaryEntity;
import cz.kct.data.mapper.PersonMapper;
import cz.kct.data.mapper.SalaryMapper;
import cz.kct.repository.SalaryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

    public String joinSalaryWithEmployees() {
        return salaryRepository.getJoinInformation();
    }

}
