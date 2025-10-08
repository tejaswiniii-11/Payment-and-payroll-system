package com.aurionpro.payrollsystem.dto.attendanceAndLeave;

import java.time.LocalDate;
import java.util.List;

import com.aurionpro.payrollsystem.entity.attendance.AttendanceStatus;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class MarkAttendanceRequestDto {
	
	@NotNull(message = "Employee ID is required")
    private Long employeeId;
    
    @NotNull(message = "Dates are required")
    private List<LocalDate> dates;
    
    @NotNull(message = "Attendance status is required")
    private AttendanceStatus attendanceStatus;

}
