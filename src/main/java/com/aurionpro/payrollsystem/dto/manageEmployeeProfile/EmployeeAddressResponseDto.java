package com.aurionpro.payrollsystem.dto.manageEmployeeProfile;

import java.sql.Timestamp;

import com.aurionpro.payrollsystem.entity.employee.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeAddressResponseDto {

	private Long addressId;

	private String currentAddress;

	private String permanentAddress;

	private String state;

	private String city;

	private String pincode;

	private String country;

	private Timestamp createdAt;

	private Timestamp updatedAt;

	private Employee employeeId;

}
