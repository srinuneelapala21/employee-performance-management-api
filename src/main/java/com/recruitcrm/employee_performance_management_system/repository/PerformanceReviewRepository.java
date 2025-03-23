package com.recruitcrm.employee_performance_management_system.repository;

import com.recruitcrm.employee_performance_management_system.entity.Employee;
import com.recruitcrm.employee_performance_management_system.entity.PerformanceReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformanceReviewRepository extends JpaRepository<PerformanceReview, Long> {
    List<PerformanceReview> findByEmployee(Employee employee);
}
