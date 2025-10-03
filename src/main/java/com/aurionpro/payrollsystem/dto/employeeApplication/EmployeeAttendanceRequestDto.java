package com.aurionpro.payrollsystem.dto.employeeApplication;

import com.aurionpro.payrollsystem.entity.employee.Employee;
import com.aurionpro.payrollsystem.entity.leave.LeaveType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class EmployeeAttendanceRequestDto {
	

	@NotNull(message = "Employee ID is mandatory for the request.")
	private Employee employeeId;

	
	@NotNull(message = "Leave Type is mandatory for the request.")
	private LeaveType leaveTypeId; 

	// Remaining Count: Must be present and cannot be negative.
	@NotNull(message = "Remaining leave count must be provided.")
	@Min(value = 0, message = "Remaining count cannot be a negative value.")
	private Integer remainingCount;



}
