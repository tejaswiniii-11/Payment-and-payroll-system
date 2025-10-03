package com.aurionpro.payrollsystem.service.manageEmployeeProfile;

import com.aurionpro.payrollsystem.dto.manageEmployeeProfile.EmployeeAddressRequestDto;
import com.aurionpro.payrollsystem.dto.manageEmployeeProfile.EmployeeAddressResponseDto;
import com.aurionpro.payrollsystem.entity.employee.Employee;
import com.aurionpro.payrollsystem.entity.employee.EmployeeAddress;
import com.aurionpro.payrollsystem.exception.ResourceNotFoundException;
import com.aurionpro.payrollsystem.repository.EmployeeRepository;
import com.aurionpro.payrollsystem.service.authentication.AuthServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aurionpro.payrollsystem.repository.EmployeeAddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class EmployeeAddressServiceImpl implements EmployeeAddressService {

	@Autowired
	private EmployeeAddressRepository addressRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ModelMapper mapper;
	
	private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

	@Override
	public EmployeeAddressResponseDto getEmployeeAddress(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
	            .orElseThrow(() -> new ResourceNotFoundException("No employee found with this employee ID: " + employeeId));
	    if (!employee.getIsActive()) {
	        throw new ResourceNotFoundException("Employee with ID " + employeeId + " is no longer active.");
	    }
	    EmployeeAddress address = addressRepository.findByEmployeeId(employee)
	            .orElseThrow(() -> new ResourceNotFoundException("No address found for employee with ID: " + employeeId));
	    logger.info("Viewing address details of employee with ID: {}", employeeId);
	    return EmployeeAddressToEmployeeAddressResponseDto(address);
	}

	private EmployeeAddressResponseDto EmployeeAddressToEmployeeAddressResponseDto(EmployeeAddress address) {
	    if (address == null) {
	        return null;
	    }

	    EmployeeAddressResponseDto dto = new EmployeeAddressResponseDto();
	    
	    dto.setAddressId(address.getAddressId());
	    dto.setCity(address.getCity());
	    dto.setCountry(address.getCountry());
	    dto.setCreatedAt(address.getCreatedAt());
	    dto.setCurrentAddress(address.getCurrentAddress());
	    dto.setEmployeeId(address.getEmployeeId());
	    dto.setPermanentAddress(address.getPermanentAddress());
	    dto.setPincode(address.getPincode());
	    dto.setState(address.getState());
	    dto.setUpdatedAt(address.getUpdatedAt());
	    
	    return dto;
	}

//	@Override
//	public EmployeeAddressResponseDto patchEmployeeAddress(Long employeeId, EmployeeAddressRequestDto patchDto)
//			throws ResourceNotFoundException {
//		EmployeeAddress address = findAddress(employeeId);
//
//		if (patchDto.getCurrentAddress() != null) {
//			address.setCurrentAddress(patchDto.getCurrentAddress());
//		}
//		if (patchDto.getPermanentAddress() != null) {
//			address.setPermanentAddress(patchDto.getPermanentAddress());
//		}
//		if (patchDto.getState() != null) {
//			address.setState(patchDto.getState());
//		}
//		if (patchDto.getCity() != null) {
//			address.setCity(patchDto.getCity());
//		}
//		if (patchDto.getPincode() != null) {
//			address.setPincode(patchDto.getPincode());
//		}
//		if (patchDto.getCountry() != null) {
//			address.setCountry(patchDto.getCountry());
//		}
//
//		EmployeeAddress savedAddress = addressRepository.save(address);
//		return mapper.map(savedAddress, EmployeeAddressResponseDto.class);
//	}

}
