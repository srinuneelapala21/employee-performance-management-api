package com.recruitcrm.employee_performance_management_system.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {
    private Long id;
    private String name;
    private String email;
    private LocalDate dateOfJoining;
    private Double salary;
    private String manager;
    private DepartmentResponse department;
    private List<ProjectResponse> projects;
    private List<PerformanceReviewResponse> performanceReviews;
}
