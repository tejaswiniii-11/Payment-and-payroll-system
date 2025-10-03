package com.aurionpro.payrollsystem.controller.manageEmployeeProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.payrollsystem.dto.manageEmployeeProfile.EmployeeAddressResponseDto;
import com.aurionpro.payrollsystem.service.manageEmployeeProfile.EmployeeAddressService;

@RestController
@RequestMapping("/employees")
public class EmployeeAddressController {

	@Autowired
    private  EmployeeAddressService employeeAddressService;

//	@GetMapping
//    public ResponseEntity<EmployeeAddressResponseDto> getAddress(Authentication authentication) {
//        Long employeeId = SecurityUtils.getEmployeeIdFromAuthentication(authentication);
//
//        EmployeeAddressResponseDto responseDto = employeeAddressService.getEmployeeAddress(employeeId);
//
//        return ResponseEntity.ok(responseDto);
//    }
	
	@GetMapping("/{employeeId}/addresses/")
    public ResponseEntity<EmployeeAddressResponseDto> getEmployeeAddress(
            @PathVariable Long employeeId) {

        EmployeeAddressResponseDto addressDto = employeeAddressService.getEmployeeAddress(employeeId);

        return ResponseEntity.ok(addressDto);
    }
    
	
//	 @PatchMapping
//	    public ResponseEntity<EmployeeAddressResponseDto> patchAddress(
//	            @Valid @RequestBody EmployeeAddressRequestDto patchDto,
//	            Authentication authentication) {
//	        
//	        Long employeeId = SecurityUtils.getEmployeeIdFromAuthentication(authentication);
//
//	        EmployeeAddressResponseDto responseDto = employeeAddressService.patchEmployeeAddress(employeeId, patchDto);
//
//	        return ResponseEntity.ok(responseDto);
//	    }
}
