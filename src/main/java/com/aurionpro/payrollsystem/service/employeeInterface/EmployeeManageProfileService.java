package com.aurionpro.payrollsystem.service.employeeInterface;

import com.aurionpro.payrollsystem.dto.manageEmployeeProfile.EmployeeAddressRequestDto;	
import com.aurionpro.payrollsystem.dto.manageEmployeeProfile.EmployeeAddressResponseDto;
import com.aurionpro.payrollsystem.dto.manageEmployeeProfile.EmployeeContactDetailsRequestDto;
import com.aurionpro.payrollsystem.dto.manageEmployeeProfile.EmployeeContactDetailsResponseDto;
import com.aurionpro.payrollsystem.dto.manageEmployeeProfile.ProfileRequestDto;
import com.aurionpro.payrollsystem.dto.manageEmployeeProfile.ProfileResponseDto;


public interface EmployeeManageProfileService {
	
	 EmployeeAddressResponseDto getEmployeeAddress(Long employeeId);
	 
	 EmployeeAddressResponseDto updateEmployeeAddress(Long employeeId, EmployeeAddressRequestDto patchDto);
	
	 EmployeeContactDetailsResponseDto getEmployeeContactDetails(Long employeeId);
	 
	 EmployeeContactDetailsResponseDto updateEmployeeContactDetails(Long employeeId, EmployeeContactDetailsRequestDto patchDto);
	 
	 ProfileResponseDto getProfileDetails(Long employeeId);
	 
	 ProfileResponseDto updateProfileDetails(Long employeeId, ProfileRequestDto patchDto);

}
