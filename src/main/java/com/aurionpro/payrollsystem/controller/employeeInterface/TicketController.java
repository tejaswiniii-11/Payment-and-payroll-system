package com.aurionpro.payrollsystem.controller.employeeInterface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.payrollsystem.dto.employeeRaiseTicket.TicketCreateDto;
import com.aurionpro.payrollsystem.dto.employeeRaiseTicket.TicketDto;
import com.aurionpro.payrollsystem.dto.employeeRaiseTicket.TicketSummaryDto;
import com.aurionpro.payrollsystem.service.employeeInterface.TicketService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	 @PostMapping("/ticket")
	 @PreAuthorize("hasRole('EMPLOYEE')")
	    public ResponseEntity<TicketDto> createTicket(@Valid @RequestBody TicketCreateDto createDto) {
	        TicketDto createdTicket = ticketService.createTicket(createDto);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdTicket);
	    }
	    
	   
	    @GetMapping("/{employeeId}/ticket")
	    @PreAuthorize("hasRole('EMPLOYEE')")
	    public ResponseEntity<List<TicketSummaryDto>> getAllTicketsByEmployeeId(@PathVariable Long employeeId) {
	        List<TicketSummaryDto> tickets = ticketService.getAllTicketsByEmployeeId(employeeId);
	        return ResponseEntity.ok(tickets);
	    }
	  
	    @GetMapping("/{ticketId}")
	    @PreAuthorize("hasRole('EMPLOYEE')")
	    public ResponseEntity<TicketDto> getTicketWithResponses(@PathVariable Long ticketId) {
	        TicketDto ticket = ticketService.getTicketWithResponses(ticketId);
	        return ResponseEntity.ok(ticket);
	    }
	    
	   
	    @GetMapping("/{employeeId}/ticket/open")
	    @PreAuthorize("hasRole('EMPLOYEE')")
	    public ResponseEntity<List<TicketSummaryDto>> getOpenTicketsByEmployeeId(@PathVariable Long employeeId) {
	        List<TicketSummaryDto> tickets = ticketService.getOpenTicketsByEmployeeId(employeeId);
	        return ResponseEntity.ok(tickets);
	    }
	    
	  
	    @GetMapping("/{employeeId}/ticket/close")
	    @PreAuthorize("hasRole('EMPLOYEE')")
	    public ResponseEntity<List<TicketSummaryDto>> getClosedTicketsByEmployeeId(@PathVariable Long employeeId) {
	        List<TicketSummaryDto> tickets = ticketService.getClosedTicketsByEmployeeId(employeeId);
	        return ResponseEntity.ok(tickets);
	    }
	    
	    //Add post request of employee giving reply to org admin response
	    
	    /**
	     * Exception handler for this controller
	     */
	    @ExceptionHandler(RuntimeException.class)
	    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {
	        ErrorResponse error = new ErrorResponse(
	            HttpStatus.BAD_REQUEST.value(),
	            ex.getMessage(),
	            System.currentTimeMillis()
	        );
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	    }
	    
	    /**
	     * Inner class for error response
	     */
	    @lombok.Data
	    @lombok.AllArgsConstructor
	    static class ErrorResponse {
	        private int status;
	        private String message;
	        private long timestamp;
	    }
	
}
