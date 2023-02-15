package cz.kct.data.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import cz.kct.data.enums.PositionEnum;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PersonDto {
    private int id;

    //@JsonProperty("name") //attributes received from JSON
    @Valid
    @Size(max=20)
    private String firstName;
    @Size(max=20)
    private String lastName;
    @PositiveOrZero
    @Max(130)
    private int age;
    private PositionEnum position;
    @Email
    private String email;

    @Pattern(regexp = "^[0-9+]{6,15}$", message = "Wrong number")
    private String phone;
}
/*
const pool = new Pool({
    host: process.env.HOST,
    user: 'postgres',
    password: process.env.PASSWORD,
    port: 5432,
    database: 'rare',
    max: 20,
    connectionTimeoutMillis: 100,
    idleTimeoutMillis: 100
});
PASSWORD=postgres
HOST=localhost

#--------------------- DB Connection ------------------
spring.datasource.url=jdbc:postgresql://localhost:5432/artembelysev
spring.datasource.username=postgres
spring.datasource.password=postgres

#--------------------JPA-ORM Properties-----------------
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
 */