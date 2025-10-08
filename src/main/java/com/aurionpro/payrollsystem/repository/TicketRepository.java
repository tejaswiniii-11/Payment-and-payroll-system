package com.aurionpro.payrollsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aurionpro.payrollsystem.entity.ticket.Ticket;
import com.aurionpro.payrollsystem.entity.ticket.TicketStatus;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	List<Ticket> findByEmployee_EmployeeId(Long employeeId);

	List<Ticket> findByEmployee_EmployeeIdOrderByCreatedAtDesc(Long employeeId);

	List<Ticket> findByEmployee_EmployeeIdAndStatus(Long employeeId, TicketStatus status);

	List<Ticket> findByOrganization_OrganizationId(Long organizationId);

	List<Ticket> findByStatus(TicketStatus status);

	@Query("SELECT t FROM Ticket t " + "LEFT JOIN FETCH t.employee " + "LEFT JOIN FETCH t.organization "
			+ "WHERE t.ticketId = :ticketId")
	Optional<Ticket> findByIdWithDetails(@Param("ticketId") Long ticketId);

	Long countByEmployee_EmployeeId(Long employeeId);

	Long countByEmployee_EmployeeIdAndStatus(Long employeeId, TicketStatus status);

}
