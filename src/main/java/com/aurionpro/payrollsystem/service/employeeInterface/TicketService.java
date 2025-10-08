package com.aurionpro.payrollsystem.service.employeeInterface;

import java.util.List;

import com.aurionpro.payrollsystem.dto.employeeRaiseTicket.TicketCreateDto;
import com.aurionpro.payrollsystem.dto.employeeRaiseTicket.TicketDto;
import com.aurionpro.payrollsystem.dto.employeeRaiseTicket.TicketSummaryDto;

public interface TicketService {

	TicketDto createTicket(TicketCreateDto createDto);


	List<TicketSummaryDto> getAllTicketsByEmployeeId(Long employeeId);

	
	TicketDto getTicketWithResponses(Long ticketId);

	
	TicketDto getTicketById(Long ticketId);

	
	List<TicketSummaryDto> getOpenTicketsByEmployeeId(Long employeeId);

	
	List<TicketSummaryDto> getClosedTicketsByEmployeeId(Long employeeId);

}
