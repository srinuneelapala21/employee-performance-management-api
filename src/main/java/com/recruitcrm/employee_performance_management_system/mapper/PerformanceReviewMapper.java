package com.recruitcrm.employee_performance_management_system.mapper;

import com.recruitcrm.employee_performance_management_system.entity.PerformanceReview;
import com.recruitcrm.employee_performance_management_system.model.PerformanceReviewResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PerformanceReviewMapper {

    PerformanceReviewResponse toDto(PerformanceReview performanceReview);
}
