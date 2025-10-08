package com.aurionpro.payrollsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.payrollsystem.entity.employee.Employee;
import com.aurionpro.payrollsystem.entity.leave.EmployeeLeaves;

public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeaves, Long>{
	
	 List<EmployeeLeaves> findByEmployee(Employee employee);
	 
	 Optional<EmployeeLeaves> findByEmployee_EmployeeIdAndLeaveType_LeaveTypeId(Long employeeId, Long leaveTypeId);

}
