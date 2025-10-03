package com.aurionpro.payrollsystem.dto.employeeApplication;

import java.sql.Timestamp;

import com.aurionpro.payrollsystem.entity.employee.Employee;

import com.aurionpro.payrollsystem.entity.leave.LeaveType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class EmployeeAttendanceResponseDto {

	private Long leaveId;

	private Employee employeeId;

	private LeaveType leaveTypeId;

	private Integer remainingCount;

	private Timestamp createdAt;

	private Timestamp updatedAt;

}
