package cz.kct.data.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)

public class ExcelDto {
    private int id;
    private int value;
}
