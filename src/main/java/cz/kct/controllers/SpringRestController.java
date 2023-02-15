package cz.kct.controllers;

import cz.kct.data.dto.PersonDto;
import cz.kct.data.entity.PersonEntity;
import cz.kct.repository.PersonRepository;
import cz.kct.services.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/person")

public class SpringRestController {
    //private static final Logger LOGGER = LoggerFactory.getLogger(Logback.class);
    private final PersonService personService;
    @GetMapping("/v1/connect")
    public void connect(){
        log.info("This is an INFO level log message!");
    }

    @GetMapping("/v1/error")
    public void err(){
        log.error("This is an ERROR level log message!");
    }

    @GetMapping("/v1/debug")
    public void deb(){
        log.debug("This is an DEBUG level log message!");
    }


    @GetMapping("/v1/get")
    @ResponseBody
    public PersonDto findPerson(@RequestParam int id) {
        log.info("start to find id: {} ",  id);
        PersonDto person = personService.findOne(id);
        log.info("person found id: {} ",  id);
        return person;
    }

    @GetMapping("/v1/get/byname")
    @ResponseBody
    public PersonDto findPerson(@RequestParam String firstName, @RequestParam String lastName) {
        log.info("start to find name: {}, lastname: {} ",  firstName, lastName);
        PersonDto person = personService.findOneByName(firstName, lastName);
        log.info("end to find name: {}, lastname: {} ",  firstName, lastName);
        return person;
    }

    @DeleteMapping("/v1/delete")
    @ResponseBody
    public String deletePerson(@RequestParam int id) {
        log.info("start process of deleting controller id: {}", id);
        personService.deleteOne(id);
        return "Deleted successfully";
    }

    @PutMapping("/v1/change")
    public void changePerson(@Valid @RequestBody PersonDto personDto, @RequestParam int id) {
        log.info("Start of processing of finding person with id = {}", id);
        PersonDto person = personService.findOne(id);
        personService.changeOne(personDto, id);
        log.info("Person with id = {}, is = {}", id, person);
    }

    @Operation(summary="about")
    @PostMapping("/v1/insert")
    public void createPerson(@Valid @RequestBody PersonDto personDto) {
        log.info("start process insert person in controller: {}",  personDto);
        personService.insert(personDto);
        log.info("end process insert person in controller: {}",  personDto);
    }
}
