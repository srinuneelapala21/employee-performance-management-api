package com.recruitcrm.employee_performance_management_system.service;

import com.recruitcrm.employee_performance_management_system.entity.Employee;
import com.recruitcrm.employee_performance_management_system.entity.PerformanceReview;
import com.recruitcrm.employee_performance_management_system.exception.ResourceNotFoundException;
import com.recruitcrm.employee_performance_management_system.mapper.EmployeeMapper;
import com.recruitcrm.employee_performance_management_system.mapper.PerformanceReviewMapper;
import com.recruitcrm.employee_performance_management_system.model.EmployeeResponse;
import com.recruitcrm.employee_performance_management_system.model.PerformanceReviewResponse;
import com.recruitcrm.employee_performance_management_system.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    private final PerformanceReviewMapper performanceReviewMapper;

    public List<EmployeeResponse> getFilteredEmployee(Double performanceScore, LocalDate reviewDate, List<Long> departmentIds, List<Long> projectIds) {
        List<Employee> employeeList = employeeRepository.findEmployeesByFilters(performanceScore, reviewDate, departmentIds, projectIds);
        if(employeeList.isEmpty()){
            log.info("No Employee Found for given Params - performanceScore:{},reviewDate:{},departments:{},projects:{}"
                    ,performanceScore,reviewDate,departmentIds,projectIds);
            throw new ResourceNotFoundException("No Employee Found with given Data");
        }
        return employeeMapper.toEmployeeItems(employeeList);
    }

    public EmployeeResponse getEmployeeDetailsById(Long employeeId) {

        Employee employee = employeeRepository.findEmployeeWithDetails(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with given Id is not found"));

        log.info("Fetched Employee details successfully for Employee Id:{}",employeeId);
        // Sort and limit last 3 performance reviews
        List<PerformanceReviewResponse> lastThreeReviews = employee.getPerformanceReviews().stream()
                .sorted(Comparator.comparing(PerformanceReview::getReviewDate).reversed())
                .limit(3)
                .map(performanceReviewMapper::toDto)
                .toList();
        EmployeeResponse employeeResponse = employeeMapper.toEmployeeResponse(employee);
        employeeResponse.setPerformanceReviews(lastThreeReviews);
        return employeeResponse;
    }

}