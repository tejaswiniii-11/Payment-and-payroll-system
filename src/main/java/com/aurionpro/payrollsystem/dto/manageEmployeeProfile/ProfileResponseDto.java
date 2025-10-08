package com.aurionpro.payrollsystem.dto.manageEmployeeProfile;

import java.time.LocalDate;

import com.aurionpro.payrollsystem.entity.employee.Gender;
import com.aurionpro.payrollsystem.entity.employee.Salutation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileResponseDto {

	private String firstName;
	private String middleName;
	private String lastName;
	
	private String profilePhotoUrl;

	private Gender gender;
	private Salutation salutation;

	private String spouse;

	private LocalDate dateOfBirth;

	private String bloodGroup;

	private String nationality;

	private String panNumber;

	private String aadharNumber;

}
