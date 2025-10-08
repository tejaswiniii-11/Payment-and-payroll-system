package com.aurionpro.payrollsystem.dto.attendanceAndLeave;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class LeaveApplicationRequestDto {
	
	@NotNull(message = "Employee ID is required")
    private Long employeeId;
    
    @NotNull(message = "Leave type ID is required")
    private Long leaveTypeId;
    
    @NotNull(message = "Start date is required")
    private LocalDate startDate;
    
    @NotNull(message = "End date is required")
    private LocalDate endDate;
    
    private String reason;

}
