package cz.kct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Tutorial {
    public static void main(String[] args) {
        SpringApplication.run(Tutorial.class, args);
    }
}


