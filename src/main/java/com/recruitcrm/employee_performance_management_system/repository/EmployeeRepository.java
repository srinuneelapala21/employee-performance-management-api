package com.recruitcrm.employee_performance_management_system.repository;

import com.recruitcrm.employee_performance_management_system.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    @Query("SELECT DISTINCT e FROM Employee e " +
//            "LEFT JOIN e.performanceReviews pr " +
//            "LEFT JOIN e.department d " +
//            "LEFT JOIN e.projects p " +
//            "WHERE (:performanceScore IS NULL OR pr.score = :performanceScore) " +
//            "AND (:reviewDate IS NULL OR pr.reviewDate = :reviewDate) " +
//            "AND (:departmentIds IS NULL OR d.id IN :departmentIds) " +
//            "AND (:projectIds IS NULL OR p.id IN :projectIds)")
//    List<Employee> findEmployeesByFilters(
//            @Param("performanceScore") Double performanceScore,
//            @Param("reviewDate") LocalDate reviewDate,
//            @Param("departmentIds") List<Long> departmentIds,
//            @Param("projectIds") List<Long> projectIds
//    );

    //working filter query
//    @Query("SELECT DISTINCT e FROM Employee e " +
//            "LEFT JOIN FETCH e.department d " +
//            "LEFT JOIN FETCH e.performanceReviews pr " +
//            "LEFT JOIN FETCH e.projects p " +
//            "WHERE (:performanceScore IS NULL OR pr.score = :performanceScore) " +
//            "AND (:reviewDate IS NULL OR pr.reviewDate = :reviewDate) " +
//            "AND (:departmentIds IS NULL OR d.id IN :departmentIds) " +
//            "AND (:projectIds IS NULL OR p.id IN :projectIds)")
//    List<Employee> findEmployeesByFilters(
//            @Param("performanceScore") Double performanceScore,
//            @Param("reviewDate") LocalDate reviewDate,
//            @Param("departmentIds") List<Long> departmentIds,
//            @Param("projectIds") List<Long> projectIds
//    );

    @Query("""
                SELECT DISTINCT e FROM Employee e
                LEFT JOIN FETCH e.department d
                LEFT JOIN FETCH e.performanceReviews pr
                LEFT JOIN FETCH e.employeeProjects ep
                LEFT JOIN FETCH ep.project p
                WHERE (:performanceScore IS NULL OR pr.score = :performanceScore)
                AND (:reviewDate IS NULL OR pr.reviewDate = :reviewDate)
                AND (:departmentIds IS NULL OR d.id IN :departmentIds)
                AND (:projectIds IS NULL OR p.id IN :projectIds)
            """)
    List<Employee> findEmployeesByFilters(
            @Param("performanceScore") Double performanceScore,
            @Param("reviewDate") LocalDate reviewDate,
            @Param("departmentIds") List<Long> departmentIds,
            @Param("projectIds") List<Long> projectIds
    );




//    @Query("SELECT e FROM Employee e " +
//            "LEFT JOIN FETCH e.department d " +
//            "LEFT JOIN FETCH e.employeeProjects ep " +
//            "LEFT JOIN FETCH ep.project p " +
//            "WHERE e.id = :employeeId")
//    Optional<Employee> findEmployeeDetails(@Param("employeeId") Long employeeId);

//    @Query("""
//    SELECT e FROM Employee e
//    LEFT JOIN FETCH e.department d
//    LEFT JOIN FETCH e.projects p
//    LEFT JOIN FETCH e.performanceReviews pr
//    WHERE e.id = :employeeId
//""")
//    Optional<Employee> findEmployeeWithDetails(@Param("employeeId") Long employeeId);

    @Query("""
                SELECT e FROM Employee e
                LEFT JOIN FETCH e.department d
                LEFT JOIN FETCH e.employeeProjects ep
                LEFT JOIN FETCH ep.project p
                LEFT JOIN FETCH e.performanceReviews pr
                WHERE e.id = :employeeId
            """)
    Optional<Employee> findEmployeeWithDetails(@Param("employeeId") Long employeeId);

}
