package cz.kct.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder(toBuilder = true)
@Table(name="person")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="firstName", nullable = false)
    private String firstName;

    @Column(name="lastName", nullable = false)
    private String lastName;

    @Column(name="age", nullable = false)
    private int age;

    @Column(name="position")
    private String position;
}
