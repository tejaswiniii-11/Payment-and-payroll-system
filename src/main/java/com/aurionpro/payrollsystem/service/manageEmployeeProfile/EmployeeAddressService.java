package com.aurionpro.payrollsystem.service.manageEmployeeProfile;

import com.aurionpro.payrollsystem.dto.manageEmployeeProfile.EmployeeAddressRequestDto;	
import com.aurionpro.payrollsystem.dto.manageEmployeeProfile.EmployeeAddressResponseDto;


public interface EmployeeAddressService {
	
	 EmployeeAddressResponseDto getEmployeeAddress();
	 
	 //EmployeeAddressResponseDto patchEmployeeAddress(Long employeeId, EmployeeAddressRequestDto patchDto);
	
	

}
