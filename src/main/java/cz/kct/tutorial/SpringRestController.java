package cz.kct.tutorial;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
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

    @Operation(summary="about")
    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        log.info(person.toString() + " Is new customer");
        return person;
    }
}
