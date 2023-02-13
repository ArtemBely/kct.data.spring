package cz.kct.data.entity;

import cz.kct.data.enums.PositionEnum;
import cz.kct.data.enums.SalaryEnum;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name="SalaryEntity")
@Builder(toBuilder = true)
@Table(name="salaries")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter

public class SalaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="quantity", nullable = false)
    private Double quantity;

    @Enumerated(EnumType.STRING)
    @Column(name="position")
    private PositionEnum position;

    @Enumerated(EnumType.STRING)
    @Column(name="regularity", nullable = false)
    private SalaryEnum regularity;

    @Column(name="date", nullable = false)
    private String date;

    @Column(name="USER_ID")
    @OneToMany(targetEntity = PersonEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name="USER_ID", referencedColumnName = "id")
    private List<PersonEntity> personEntities;
}

