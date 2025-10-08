package com.aurionpro.payrollsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aurionpro.payrollsystem.entity.employee.Employee;
import com.aurionpro.payrollsystem.entity.employee.Payslip;

@Repository
public interface PayslipRepository extends JpaRepository<Payslip, Long> {
	
	 Optional<Payslip> findByEmployeeIdAndMonthAndYear(Employee employeeId, Integer month, Integer year);
	 
	 //

	List<Payslip> findByEmployeeId_EmployeeIdOrderByYearDescMonthDesc(Long employeeId);

	Optional<Payslip> findByEmployeeId_EmployeeIdAndMonthAndYear(Long employeeId, Integer month, Integer year);

	
	List<Payslip> findByEmployeeId_EmployeeIdAndYearOrderByMonthDesc(Long employeeId, Integer year);

	
	@Query("SELECT p FROM Payslip p " + "LEFT JOIN FETCH p.employeeId " + "WHERE p.employeeId.employeeId = :employeeId "
			+ "ORDER BY p.year DESC, p.month DESC")
	List<Payslip> findByEmployeeIdWithDetails(@Param("employeeId") Long employeeId);

	@Query("SELECT p FROM Payslip p " + "LEFT JOIN FETCH p.employeeId " + "WHERE p.payslipId = :payslipId")
	Optional<Payslip> findByIdWithDetails(@Param("payslipId") Long payslipId);

	
	@Query("SELECT p FROM Payslip p " + "WHERE p.employeeId.employeeId = :employeeId "
			+ "ORDER BY p.year DESC, p.month DESC " + "LIMIT 1")
	Optional<Payslip> findLatestPayslipByEmployeeId(@Param("employeeId") Long employeeId);

	
	Long countByEmployeeId_EmployeeId(Long employeeId);

	
	boolean existsByEmployeeId_EmployeeIdAndMonthAndYear(Long employeeId, Integer month, Integer year);
}
