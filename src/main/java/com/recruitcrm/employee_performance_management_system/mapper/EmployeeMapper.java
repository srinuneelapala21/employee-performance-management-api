package com.recruitcrm.employee_performance_management_system.mapper;

import com.recruitcrm.employee_performance_management_system.entity.Employee;
import com.recruitcrm.employee_performance_management_system.model.EmployeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {ProjectMapper.class, PerformanceReviewMapper.class})
public interface EmployeeMapper {

        @Mapping(source = "manager.name", target = "manager")
        @Mapping(target = "projects", source = "employeeProjects")
        EmployeeResponse toEmployeeResponse(Employee employee);


}
