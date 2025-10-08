package com.aurionpro.payrollsystem.dto.employeeAttendanceLeave;

import java.time.LocalDate;

import com.aurionpro.payrollsystem.entity.employee.Employee;
import com.aurionpro.payrollsystem.entity.leave.LeaveStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class EmployeeLeaveResponseDto {

	private Long leaveRequestId;

	private Employee employeeId;

	private String reason;

	private LocalDate startDate;

	private LocalDate endDate;

	private LeaveStatus leaveStatus;

	private EmployeeLeaveTypeDto leavetypedto;

}
