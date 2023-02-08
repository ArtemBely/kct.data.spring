package cz.kct.controllers;

import cz.kct.data.dto.PersonDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@Slf4j
@RestController
public class SpringRestController {
    //private static final Logger LOGGER = LoggerFactory.getLogger(Logback.class);

    @GetMapping("/connect")
    public void connect(){
        log.info("This is an INFO level log message!");
    }

    @GetMapping("/error")
    public void err(){
        log.error("This is an ERROR level log message!");
    }

    @GetMapping("/debug")
    public void deb(){
        log.debug("This is an DEBUG level log message!");
    }

    @GetMapping("/person")
    public void person(){
        log.info("Saved");
    }

    @Operation(summary="about")
    @PostMapping("/person")
    public void createPerson(@RequestBody PersonDto personDto) {
        log.info(personDto.toString() + " Is new customer");
        //return null;
    }
}
