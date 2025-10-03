package com.aurionpro.payrollsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.aurionpro.payrollsystem.entity.employee.EmployeeContactDetails;

public interface EmployeeContactDetailsRepository extends JpaRepository<EmployeeContactDetails, Long>{
	
	Optional<EmployeeContactDetails> findById(Long contactId);


}
