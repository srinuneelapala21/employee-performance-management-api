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
public class PerformanceReviewResponse {
    private Long id;
    private Double score;
    private LocalDate reviewDate;
    private String reviewComments;
}
