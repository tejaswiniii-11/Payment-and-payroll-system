package com.aurionpro.payrollsystem.service.employeeInterface;

import java.util.List;

import com.aurionpro.payrollsystem.dto.attendanceAndLeave.AttendanceResponseDto;
import com.aurionpro.payrollsystem.dto.attendanceAndLeave.LeaveApplicationRequestDto;
import com.aurionpro.payrollsystem.dto.attendanceAndLeave.LeaveApprovalRequestDto;
import com.aurionpro.payrollsystem.dto.attendanceAndLeave.LeaveRequestResponseDto;
import com.aurionpro.payrollsystem.dto.attendanceAndLeave.MarkAttendanceRequestDto;
import com.aurionpro.payrollsystem.entity.leave.EmployeeLeaves;

public interface EmployeeAttendanceService {

	List<AttendanceResponseDto> markAttendance(MarkAttendanceRequestDto requestDto);

	List<AttendanceResponseDto> showAttendance();

	long calculatePayableDays(Long employeeId);

	List<LeaveRequestResponseDto> getEmployeeLeaveHistory(Long employeeId);

	LeaveRequestResponseDto applyForLeave(LeaveApplicationRequestDto requestDto);

	List<LeaveRequestResponseDto> getPendingLeavesForManager(Long managerId);

	LeaveRequestResponseDto approveLeaveByManager(LeaveApprovalRequestDto requestDto);

	List<EmployeeLeaves> getRemainingLeaves(Long employeeId);

}
