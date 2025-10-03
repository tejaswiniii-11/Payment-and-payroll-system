package com.aurionpro.payrollsystem.dto.employeeApplication;

import java.sql.Timestamp;

import com.aurionpro.payrollsystem.entity.bankAccount.BankAccountDetails;
import com.aurionpro.payrollsystem.entity.employee.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeBankAccountInfoDto {

	private Long EmployeeBankInfoId;

	private Employee employeeId;

	private String pfNumber;

	private String uanNumber;

	private BankAccountDetails accountId;

	private Boolean isActive;

	private Timestamp createdAt;

	private Timestamp updatedAt;

}
