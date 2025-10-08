package com.aurionpro.payrollsystem.service.employeeInterface;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aurionpro.payrollsystem.dto.employeeRaiseTicket.TicketCreateDto;
import com.aurionpro.payrollsystem.dto.employeeRaiseTicket.TicketDto;
import com.aurionpro.payrollsystem.dto.employeeRaiseTicket.TicketResponseDto;
import com.aurionpro.payrollsystem.dto.employeeRaiseTicket.TicketSummaryDto;
import com.aurionpro.payrollsystem.entity.employee.Employee;
import com.aurionpro.payrollsystem.entity.organization.Organization;
import com.aurionpro.payrollsystem.entity.ticket.Ticket;
import com.aurionpro.payrollsystem.entity.ticket.TicketResponse;
import com.aurionpro.payrollsystem.entity.ticket.TicketStatus;
import com.aurionpro.payrollsystem.repository.TicketRepository;
import com.aurionpro.payrollsystem.repository.TicketResponseRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private TicketResponseRepository ticketResponseRepository;

	@Override
	@Transactional
	public TicketDto createTicket(TicketCreateDto createDto) {
		Ticket ticket = new Ticket();
		ticket.setQuery(createDto.getQuery());
		ticket.setStatus(TicketStatus.OPEN);
		//ticket.setCreatedAt(new Timestamp(System.currentTimeMillis()));

		// Set employee (you may need to fetch from repository)
		Employee employee = new Employee();
		employee.setEmployeeId(createDto.getEmployeeId());
		ticket.setEmployee(employee);

		// Set organization (you may need to fetch from repository)
		Organization organization = new Organization();
		organization.setOrganizationId(createDto.getOrganizationId());
		ticket.setOrganization(organization);

		Ticket savedTicket = ticketRepository.save(ticket);
		return convertToDto(savedTicket);
	}

	@Override
	public List<TicketSummaryDto> getAllTicketsByEmployeeId(Long employeeId) {
		List<Ticket> tickets = ticketRepository.findByEmployee_EmployeeIdOrderByCreatedAtDesc(employeeId);
		return tickets.stream().map(this::convertToSummaryDto).collect(Collectors.toList());
	}

	@Override
	public TicketDto getTicketWithResponses(Long ticketId) {
		Ticket ticket = ticketRepository.findByIdWithDetails(ticketId)
				.orElseThrow(() -> new RuntimeException("Ticket not found with id: " + ticketId));

		List<TicketResponse> responses = ticketResponseRepository.findByTicketIdWithDetails(ticketId);

		TicketDto ticketDto = convertToDto(ticket);
		ticketDto.setResponses(responses.stream().map(this::convertResponseToDto).collect(Collectors.toList()));

		return ticketDto;
	}

	@Override
	public TicketDto getTicketById(Long ticketId) {
		Ticket ticket = ticketRepository.findById(ticketId)
				.orElseThrow(() -> new RuntimeException("Ticket not found with id: " + ticketId));
		return convertToDto(ticket);
	}

	@Override
	public List<TicketSummaryDto> getOpenTicketsByEmployeeId(Long employeeId) {
		List<Ticket> tickets = ticketRepository.findByEmployee_EmployeeIdAndStatus(employeeId, TicketStatus.OPEN);
		return tickets.stream().map(this::convertToSummaryDto).collect(Collectors.toList());
	}

	@Override
	public List<TicketSummaryDto> getClosedTicketsByEmployeeId(Long employeeId) {
		List<Ticket> tickets = ticketRepository.findByEmployee_EmployeeIdAndStatus(employeeId, TicketStatus.CLOSE);
		return tickets.stream().map(this::convertToSummaryDto).collect(Collectors.toList());
	}

	private TicketDto convertToDto(Ticket ticket) {
		TicketDto dto = new TicketDto();
		dto.setTicketId(ticket.getTicketId());
		dto.setQuery(ticket.getQuery());
		dto.setCreatedAt(ticket.getCreatedAt());
		dto.setUpdatedAt(ticket.getUpdatedAt());
		dto.setStatus(ticket.getStatus());

		if (ticket.getEmployee() != null) {
			dto.setEmployeeId(ticket.getEmployee().getEmployeeId());
			dto.setEmployeeName(ticket.getEmployee().getFirstName() + " " + ticket.getEmployee().getLastName());
		}

		if (ticket.getOrganization() != null) {
			dto.setOrganizationId(ticket.getOrganization().getOrganizationId());
			dto.setOrganizationName(ticket.getOrganization().getOrganizationName());
		}

		return dto;
	}

	private TicketSummaryDto convertToSummaryDto(Ticket ticket) {
		TicketSummaryDto dto = new TicketSummaryDto();
		dto.setTicketId(ticket.getTicketId());
		dto.setQuery(ticket.getQuery());
		dto.setCreatedAt(ticket.getCreatedAt());
		dto.setUpdatedAt(ticket.getUpdatedAt());
		dto.setStatus(ticket.getStatus());

		if (ticket.getEmployee() != null) {
			dto.setEmployeeId(ticket.getEmployee().getEmployeeId());
			dto.setEmployeeName(ticket.getEmployee().getFirstName() + " " + ticket.getEmployee().getLastName());
		}

		if (ticket.getOrganization() != null) {
			dto.setOrganizationId(ticket.getOrganization().getOrganizationId());
			dto.setOrganizationName(ticket.getOrganization().getOrganizationName());
		}

		// Get response count
		Long responseCount = ticketResponseRepository.countByTicketId_TicketId(ticket.getTicketId());
		dto.setResponseCount(responseCount != null ? responseCount.intValue() : 0);

		return dto;
	}

	private TicketResponseDto convertResponseToDto(TicketResponse response) {
		TicketResponseDto dto = new TicketResponseDto();
		dto.setResponseId(response.getResponseId());
		dto.setResponse(response.getResponse());
		dto.setCreatedAt(response.getCreatedAt());

		if (response.getEmployeeId() != null) {
			dto.setEmployeeId(response.getEmployeeId().getEmployeeId());
			dto.setEmployeeName(response.getEmployeeId().getFirstName() + " " + response.getEmployeeId().getLastName());
		}

		if (response.getOrganizationId() != null) {
			dto.setOrganizationId(response.getOrganizationId().getOrganizationId());
			dto.setOrganizationName(response.getOrganizationId().getOrganizationName());
		}

		if (response.getTicketId() != null) {
			dto.setTicketId(response.getTicketId().getTicketId());
		}

		return dto;
	}

}
