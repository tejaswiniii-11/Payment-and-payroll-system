package com.aurionpro.payrollsystem.dto.employeeApplication;

import com.aurionpro.payrollsystem.entity.ticket.TicketStatus;


import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TicketRequestDto {

	@NotBlank(message="Query cannot be blank")
	private String query;

	@NotBlank
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private TicketStatus status;
	
	//not taking employee id since will be using jwt token of that employee

//	@NotNull(message="Organization Id cannot be null")
//	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
//	@JoinColumn(name = "organization_id", nullable = false)
//	private Organization organization;

}
