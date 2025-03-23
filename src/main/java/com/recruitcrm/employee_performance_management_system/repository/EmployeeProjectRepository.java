package com.recruitcrm.employee_performance_management_system.repository;

import com.recruitcrm.employee_performance_management_system.entity.Employee;
import com.recruitcrm.employee_performance_management_system.entity.EmployeeProject;
import com.recruitcrm.employee_performance_management_system.entity.EmployeeProjectId;
import com.recruitcrm.employee_performance_management_system.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, EmployeeProjectId> {
    List<EmployeeProject> findByEmployee(Employee employee);
    List<EmployeeProject> findByProject(Project project);
}
