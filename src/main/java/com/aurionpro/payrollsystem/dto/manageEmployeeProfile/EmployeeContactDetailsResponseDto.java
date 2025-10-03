package com.aurionpro.payrollsystem.dto.manageEmployeeProfile;

import java.sql.Timestamp;

import com.aurionpro.payrollsystem.entity.employee.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeContactDetailsResponseDto {

	private Long contactId;

	private String email;

	private String officeEmail;

	private String phoneNumber;

	private String emergencyContact;

	private String emergencyContactRelation;

	private String alternateMobileNumber;

	private Timestamp createdAt;

	private Timestamp updatedAt;

	private Employee employeeId;

}
