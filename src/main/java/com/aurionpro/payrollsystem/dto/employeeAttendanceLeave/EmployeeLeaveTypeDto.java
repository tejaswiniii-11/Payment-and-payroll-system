package com.aurionpro.payrollsystem.dto.employeeAttendanceLeave;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor                 //no args should be used for json deserialization??
@RequiredArgsConstructor
public class EmployeeLeaveTypeDto {
	
	// The ID is crucial for linking the request to the specific LeaveType record.
		@NotNull(message = "Leave Type ID is mandatory.")
		@Min(value = 1, message = "Leave Type ID must be a positive number.")
		private Long leaveTypeId;

		// Leave Type Name: Mandatory for displaying to the user/for clarity.
		@NotBlank(message = "Leave Type Name is mandatory.")
		@Size(max = 50, message = "Leave Type Name cannot exceed 50 characters.")
		private String leaveTypeName;
		
		// Leave Count: Mandatory and must be non-negative.
		@NotNull(message = "Total leave count for this type is mandatory.")
		@Min(value = 0, message = "Leave count cannot be a negative value.")
		private Integer leaveCount;

}
