package com.recruitcrm.employee_performance_management_system.controller;

import com.recruitcrm.employee_performance_management_system.model.EmployeeResponse;
import com.recruitcrm.employee_performance_management_system.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    // Get employees with filters
    @GetMapping("/filter")
    public ResponseEntity<List<EmployeeResponse>> getFilteredEmployees(
            @RequestParam(required = false) Double performanceScore,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reviewDate,
            @RequestParam(required = false) List<Long> departmentIds,
            @RequestParam(required = false) List<Long> projectIds) {

        List<EmployeeResponse> employees = employeeService.getFilteredEmployee(performanceScore, reviewDate, departmentIds, projectIds);
        return ResponseEntity.ok(employees);
    }

    // Get detailed employee information
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeDetailsById(@PathVariable Long id) {
        EmployeeResponse employee = employeeService.getEmployeeDetailsById(id);
        return ResponseEntity.ok(employee);
    }
}
