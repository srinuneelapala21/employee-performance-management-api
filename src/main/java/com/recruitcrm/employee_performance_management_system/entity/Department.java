package com.recruitcrm.employee_performance_management_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private Double budget;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;

    @OneToMany(mappedBy = "department")
    private Set<Project> projects;
}
