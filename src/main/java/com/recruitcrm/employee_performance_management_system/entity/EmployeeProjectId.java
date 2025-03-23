package com.recruitcrm.employee_performance_management_system.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EmployeeProjectId implements Serializable {

    private Long employeeId;
    private Long projectId;
}
