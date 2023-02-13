package cz.kct.services;

import cz.kct.data.dto.PersonDto;
import cz.kct.data.entity.PersonEntity;
import cz.kct.data.mapper.PersonMapper;
import cz.kct.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
//@NoArgsConstructor

public class PersonService {
    private PersonMapper personMapper;
    private final PersonRepository personRepository;
    //private final PersonRepositoryToDto personRepository2;

    public void insert(PersonDto dto) {
        log.info("start process insert person in services");
        PersonEntity personEntity = personMapper.mapToEntity(dto);
        log.info("start process into db {}", personEntity);
        personRepository.save(personEntity);
        log.info("end process insert person in services");
    }

    public void changeOne(PersonDto dto, int id) {
        log.info("start process of changing person in services");
        PersonEntity personEntity = personMapper.mapToEntity(dto);
        Optional<PersonEntity> personOptionalEntity = personRepository.findById(id); // see
        PersonEntity changedPerson = personOptionalEntity.get();
        if (personEntity.getFirstName() != null && !Objects.equals(personEntity.getFirstName(), changedPerson.getFirstName())) {
            changedPerson.setFirstName(personEntity.getFirstName());
            log.info("start process into db {}", personEntity);
            personRepository.save(changedPerson);
            log.info("end process of changing person in services");
        }
    }

    public PersonDto findOne(int id) {
        log.info("Find certain person");
        Optional<PersonEntity> personOptionalEntity = personRepository.findById(id); // see
        PersonDto personDto = personMapper.mapToDto(personOptionalEntity.get());
        return personDto;
    }

    public PersonDto findOneByName(String firstName, String lastName) {
        log.info("Find certain person");
       // PersonEntity personOptionalEntity = personRepository.findByFirstNameAndLastName(firstName, lastName);
        List<PersonEntity> personOptionalEntity = personRepository.findByAlternative(firstName, lastName);
        PersonDto personDto = personMapper.mapToDto(personOptionalEntity.get(0));
        return personDto;
    }

    public void deleteOne(int id) {
        log.info("start process delete person from services");
        personRepository.deleteById(id);
    }
}
