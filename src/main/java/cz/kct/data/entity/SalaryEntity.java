package cz.kct.data.entity;

import cz.kct.data.enums.PositionEnum;
import cz.kct.data.enums.SalaryEnum;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @OneToMany(targetEntity = PersonEntity.class, mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PersonEntity> personEntities;
}

