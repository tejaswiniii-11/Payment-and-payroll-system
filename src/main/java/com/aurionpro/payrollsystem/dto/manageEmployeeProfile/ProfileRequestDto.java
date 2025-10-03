package com.aurionpro.payrollsystem.dto.manageEmployeeProfile;

import java.time.LocalDate;

import com.aurionpro.payrollsystem.entity.employee.Gender;
import com.aurionpro.payrollsystem.entity.employee.Salutation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ProfileRequestDto {
	
	//@NotBlank(message = "First name is mandatory.")
	@Size(max = 50, message = "First name cannot exceed 50 characters.")
	private String firstName;
	
	@Size(max = 50, message = "Middle name cannot exceed 50 characters.")
	private String middleName;
	
	//@NotBlank(message = "Last name is mandatory.")
	@Size(max = 50, message = "Last name cannot exceed 50 characters.")
	private String lastName;
	
	//@NotNull(message = "Gender must be selected.")
	private Gender gender; 
	
	//@NotNull(message = "Salutation must be selected.")
	private Salutation salutation; 
	
	@Size(max = 100, message = "Spouse name is too long.")
	private String spouse;
	
	//@NotNull(message = "Date of Birth is mandatory.")
	@Past(message = "Date of Birth must be in the past.")
	private LocalDate dateOfBirth;
	
	//@NotNull(message = "Blood Group is mandatory.")
	private String bloodGroup;
	
	//@NotBlank(message = "Nationality is mandatory.")
	private String nationality;
	
	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Invalid PAN number format.")
	private String panNumber;
	
	@Pattern(regexp = "^[0-9]{12}$", message = "Aadhar number must be 12 digits.")
	private String aadharNumber;
	
	//@NotNull(message = "Address information cannot be null.")
	@Valid
	private EmployeeAddressRequestDto employeeAddress; 

	@Valid
	private EmployeeContactDetailsRequestDto contactDetails;
	  

}
