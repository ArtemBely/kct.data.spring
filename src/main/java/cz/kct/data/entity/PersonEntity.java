package cz.kct.data.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import cz.kct.data.enums.PositionEnum;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Entity(name="PersonEntity")
@Builder(toBuilder = true)
@Table(name="person")
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Data
@Setter
@Getter

public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="FIRST_NAME", nullable = false) //from db's
    private String firstName;

    @Column(name="LAST_NAME", nullable = false)
    private String lastName;

    @Column(name="age", nullable = false)
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name="position")
    private PositionEnum position;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="phone", nullable = false)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SALARY", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private SalaryEntity salaryEntity;
}
