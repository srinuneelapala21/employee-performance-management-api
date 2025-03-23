package com.recruitcrm.employee_performance_management_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"employees","projects"})
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private Double budget;

    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY)
    private Set<Employee> employees;

    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY)
    private Set<Project> projects;
}
