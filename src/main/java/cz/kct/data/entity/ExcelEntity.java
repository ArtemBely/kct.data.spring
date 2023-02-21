package cz.kct.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name="ExcelEntity")
@Table(name="excel")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
@Data

public class ExcelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private int id;
    @Column(name = "value", nullable = false)
    private int value;
}
