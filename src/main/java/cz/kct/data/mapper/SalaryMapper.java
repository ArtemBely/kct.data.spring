package cz.kct.data.mapper;

import cz.kct.data.dto.PersonDto;
import cz.kct.data.dto.SalaryDto;
import cz.kct.data.entity.PersonEntity;
import cz.kct.data.entity.SalaryEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class SalaryMapper {
    private final ModelMapper modelMapper;
    public SalaryEntity mapToEntity(SalaryDto dto){
        return modelMapper.map(dto, SalaryEntity.class).toBuilder().build();
    }
    public SalaryDto mapToDto(SalaryEntity entity){
        return modelMapper.map(entity, SalaryDto.class).toBuilder().build();
    }
}
