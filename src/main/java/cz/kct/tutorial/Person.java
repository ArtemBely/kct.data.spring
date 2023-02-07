package cz.kct.tutorial;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.ToString;
import lombok.NonNull;

@Setter
@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PROTECTED)

public class Person {
    @JsonProperty("name")
    private String firstName;
    private String lastName;
    @JsonProperty("kavabanga")
    private int age;
    @NonNull private String position;
}
