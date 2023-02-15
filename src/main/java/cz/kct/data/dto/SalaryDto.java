package cz.kct.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import cz.kct.data.enums.PositionEnum;
import cz.kct.data.enums.SalaryEnum;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
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

public class SalaryDto {

    private int id;

    @Valid
    @PositiveOrZero
    @Max(999999)
    private String quantity;

    @NonNull
    private PositionEnum position;
    @NonNull
    private SalaryEnum regularity;
    @NonNull
    @DateTimeFormat
    private String date;
    private int userId;

}
