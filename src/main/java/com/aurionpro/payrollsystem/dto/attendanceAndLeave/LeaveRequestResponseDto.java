package com.aurionpro.payrollsystem.dto.attendanceAndLeave;

import java.time.LocalDate;

import com.aurionpro.payrollsystem.entity.leave.LeaveStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class LeaveRequestResponseDto {

	private Long leaveRequestId;
	private Long employeeId;
	private Long leaveTypeId;
	//private LeaveType leaveTypeName;
	private LocalDate startDate;
	private LocalDate endDate;
	private String reason;
	private LeaveStatus leaveStatus;
	private Integer remainingCount;
	private Long managerId;

}
