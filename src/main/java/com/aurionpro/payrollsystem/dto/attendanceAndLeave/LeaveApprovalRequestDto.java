package com.aurionpro.payrollsystem.dto.attendanceAndLeave;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import com.aurionpro.payrollsystem.entity.employee.Status;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class LeaveApprovalRequestDto {
	
	@NotNull(message = "Leave request ID is required")
    private Long leaveRequestId;
    
    @NotNull(message = "Manager ID is required")
    private Long managerId;
    
    @NotNull(message = "Status is required")
    private Status status; // APPROVED or REJECTED
    
//    private String remarks;

}
