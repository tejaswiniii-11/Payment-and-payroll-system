package com.aurionpro.payrollsystem.dto.employeeApplication;

import java.sql.Timestamp;	

import com.aurionpro.payrollsystem.entity.employee.Employee;

import com.aurionpro.payrollsystem.entity.organization.Organization;
import com.aurionpro.payrollsystem.entity.ticket.Ticket;

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

	private Employee employeeId;

	private Organization organizationId;

	private Ticket ticketId;

}
