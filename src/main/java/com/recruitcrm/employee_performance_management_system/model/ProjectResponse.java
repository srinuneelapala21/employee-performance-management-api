package com.recruitcrm.employee_performance_management_system.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectResponse {
    private Long id;
    private String name;
    private String role;
    private LocalDate assignedDate;
    private LocalDate startDate;
    private LocalDate endDate;
}
