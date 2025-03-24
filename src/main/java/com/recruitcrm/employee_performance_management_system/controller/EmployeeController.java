package com.recruitcrm.employee_performance_management_system.controller;

import com.recruitcrm.employee_performance_management_system.model.EmployeeResponse;
import com.recruitcrm.employee_performance_management_system.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(
            summary = "Get employees with filters",
            description = "Retrieve a list of employees based on performance score, review date, department, and project filters.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful retrieval of employees",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = EmployeeResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @GetMapping("/filter")
    public ResponseEntity<List<EmployeeResponse>> getFilteredEmployees(
            @RequestParam(required = false) Double performanceScore,
            @Parameter(description = "Review date filter (YYYY-MM-DD)")
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reviewDate,
            @RequestParam(required = false) List<Long> departmentIds,
            @RequestParam(required = false) List<Long> projectIds) {

        List<EmployeeResponse> employees = employeeService.getFilteredEmployee(performanceScore, reviewDate, departmentIds, projectIds);
        return ResponseEntity.ok(employees);
    }


    @Operation(
            summary = "Get employee details by ID",
            description = "Fetches detailed information about an employee using their unique ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved employee details",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = EmployeeResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")  
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeDetailsById(@PathVariable Long id) {
        EmployeeResponse employee = employeeService.getEmployeeDetailsById(id);
        return ResponseEntity.ok(employee);
    }
}
