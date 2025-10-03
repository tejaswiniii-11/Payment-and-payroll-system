package com.aurionpro.payrollsystem.dto.employeeApplication;

import java.time.LocalDate;

import com.aurionpro.payrollsystem.entity.employee.Employee;
import com.aurionpro.payrollsystem.entity.leave.LeaveStatus;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeLeaveRequestDto {

	

		// Employee ID is mandatory and should ideally be derived from the JWT for self-service requests.
		// Keeping it @NotNull for admin/HR initiated requests.
		@NotNull(message = "Employee ID is mandatory for the leave request.")
		private Employee employeeId;

		// The reason for the leave is crucial for approval.
		@NotBlank(message = "Reason for leave must be provided.")
		@Size(min = 10, max = 500, message = "Reason must be between 10 and 500 characters.")
		private String reason;

		// Start date must be present and must be today or a future date.
		@NotNull(message = "Start date is mandatory.")
		@FutureOrPresent(message = "Start date must be today or a future date.")
		private LocalDate startDate;

		// End date must be present. Additional service logic should ensure endDate >= startDate.
		@NotNull(message = "End date is mandatory.")
		@FutureOrPresent(message = "End date must be today or a future date.")
		private LocalDate endDate;

		// Leave status is mandatory and should be set by the system (e.g., PENDING) on creation.
		@NotNull(message = "Leave status must be provided or derived by the system.")
		private LeaveStatus leaveStatus;

		// This is the entity reference, which should not be used in a DTO for input/output.
		// The LeaveType DTO (leavetypedto) is preferred for carrying necessary data.
		// private LeaveType leaveTypeId; 
		
		// Nested DTO to carry details about the type of leave being requested.
		@NotNull(message = "Leave type details are mandatory.")
		@Valid // This ensures validation runs on the nested DTO
		private EmployeeLeaveTypeDto leavetypedto;

}
