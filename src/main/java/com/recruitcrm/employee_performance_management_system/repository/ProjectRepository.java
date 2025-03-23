package com.recruitcrm.employee_performance_management_system.repository;

import com.recruitcrm.employee_performance_management_system.entity.Department;
import com.recruitcrm.employee_performance_management_system.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByDepartment(Department department);
}
