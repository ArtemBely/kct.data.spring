package cz.kct.data.mapper;

import cz.kct.data.entity.PersonEntity;
import cz.kct.data.dto.PersonDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component

public class PersonMapper {
    private final ModelMapper modelMapper;
    public PersonEntity mapToEntity(PersonDto dto){
        return modelMapper.map(dto, PersonEntity.class).toBuilder().build();
    }
    public PersonDto mapToDto(PersonEntity entity){
        return modelMapper.map(entity, PersonDto.class).toBuilder().build();
    }
}
