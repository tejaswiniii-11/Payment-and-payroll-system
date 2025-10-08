package com.aurionpro.payrollsystem.dto.attendanceAndLeave;

import java.time.LocalDate;

import com.aurionpro.payrollsystem.entity.attendance.AttendanceStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AttendanceResponseDto {
	
	private Long employeeId;
    private String employeeName;
    private LocalDate date;
    private AttendanceStatus attendanceStatus;
    private String message;

}
