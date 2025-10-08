package com.aurionpro.payrollsystem.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aurionpro.payrollsystem.entity.leave.LeaveRequest;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

	List<LeaveRequest> findByEmployeeId_EmployeeId(Long employeeId);

	@Query("SELECT lr FROM LeaveRequest lr WHERE lr.employeeId.employeeId = :employeeId "
			+ "AND lr.leaveStatus = 'Approved' AND lr.startDate <= :endDate AND lr.endDate >= :startDate")
	List<LeaveRequest> findApprovedLeavesInDateRange(Long employeeId, LocalDate startDate, LocalDate endDate);

}
