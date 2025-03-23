package com.recruitcrm.employee_performance_management_system.mapper;

import com.recruitcrm.employee_performance_management_system.entity.EmployeeProject;
import com.recruitcrm.employee_performance_management_system.entity.Project;
import com.recruitcrm.employee_performance_management_system.model.ProjectResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toDto(Project project);

    @Mapping(target = "id", source = "project.id")
    @Mapping(target = "name", source = "project.name")
    @Mapping(target = "startDate", source = "project.startDate")
    @Mapping(target = "endDate", source = "project.endDate")
    @Mapping(target = "role", source = "role")
    @Mapping(target = "assignedDate", source = "assignedDate")
    ProjectResponse toProjectDTO(EmployeeProject employeeProject);

    List<ProjectResponse> toProjectDTOs(List<EmployeeProject> employeeProjects);
}
