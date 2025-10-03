package com.aurionpro.payrollsystem.dto.employeeApplication;

import java.sql.Timestamp;

import com.aurionpro.payrollsystem.entity.bankAccount.AccountType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeAccountResponseDto {
	private Long accountId;

	
	private String accountNumber;
	
	
	private String bankName;
	
	
	private String ifscCode;
	
	
	private AccountType accountType;
	
	
	private String accountHolderName;
	
	private Boolean isActive;
	
	
	private Timestamp createdAt;
	
	
	private Timestamp updatedAt;
	
	//employee bank info 
	private EmployeeBankAccountInfoDto bankaccountinfo;
}
