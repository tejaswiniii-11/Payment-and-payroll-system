package com.aurionpro.payrollsystem.dto.employeeApplication;

import com.aurionpro.payrollsystem.entity.employee.Employee;
import com.aurionpro.payrollsystem.entity.leave.LeaveStatus;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
//To approve or reject the leave of employee
public class ManagerLeaveRequestDto {
	
	// Manager ID is needed for approval workflow, so it must be present for the request processing.
			// NOTE: This field should be set by the system when a manager views or processes the request.
			private Employee managerId; 
			
			// Employee ID is mandatory and should ideally be derived from the JWT for self-service requests.
			// Keeping it @NotNull for admin/HR initiated requests.
			@NotNull(message = "Employee ID is mandatory for the leave request.")
			private Employee employeeId;
			
			// Leave status is mandatory and should be set by the system (e.g., PENDING) on creation.
			@NotNull(message = "Leave status must be provided or derived by the system.")
			private LeaveStatus leaveStatus;

}
