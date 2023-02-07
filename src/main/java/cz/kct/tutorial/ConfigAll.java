package cz.kct.tutorial;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;


@Configuration
public class ConfigAll {

    @Bean
    public JacksonEncoder feignEncoder() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new JacksonEncoder(objectMapper);
    }
}
