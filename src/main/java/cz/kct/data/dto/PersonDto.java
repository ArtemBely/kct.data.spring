package cz.kct.data.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class PersonDto {

    private int id;

    @JsonProperty("name")
    private String firstName;

    private String lastName;

    @JsonProperty("vek")
    private int age;

    @NonNull
    private String position;
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