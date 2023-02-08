package cz.kct.services;

import cz.kct.data.dto.PersonDto;
import cz.kct.data.entity.PersonEntity;
import cz.kct.data.mapper.PersonMapper;
import cz.kct.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service

@AllArgsConstructor
//@NoArgsConstructor
public class SpringService<privat> {
    private PersonMapper personMapper;
    private final PersonRepository personRepository;

    public SpringService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void process(PersonDto dto) {
        dto.setFirstName("Filipp");
        PersonEntity personEntity = personMapper.mapToEntity(dto);
    }
}
