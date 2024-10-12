package org.example.lab3jpahibernate.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "people")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstname", nullable = false)
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    private String address;
    private LocalDate birthdate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
