package com.aurionpro.payrollsystem.dto.employeeRaiseTicket;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class TicketResponseDto {

	private Long responseId;
	private String response;
	private Timestamp createdAt;
	private Long employeeId;
	private String employeeName;
	private Long organizationId;
	private String organizationName;
	private Long ticketId;

}
