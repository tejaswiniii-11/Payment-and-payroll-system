package com.aurionpro.payrollsystem.dto.employeeApplication;

import com.aurionpro.payrollsystem.entity.bankAccount.AccountType;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeAccountRequestDto {
	
	
	// Account Number: Must be present and usually between 9 to 18 digits.
		@NotBlank(message = "Account number is mandatory.")
	    @Pattern(regexp = "^[0-9]{9,18}$", message = "Account number must be between 9 and 18 digits.")
		private String accountNumber;
		
		// Bank Name: Must be present.
		@NotBlank(message = "Bank name is mandatory.")
	    @Size(max = 100, message = "Bank name cannot exceed 100 characters.")
		private String bankName;
		
		// IFSC Code: Must be present and follow the 11-character alphanumeric format.
		@NotBlank(message = "IFSC code is mandatory.")
	    @Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}$", message = "Invalid IFSC code format (e.g., ABCD0123456).")
		private String ifscCode;
		
		// Account Type (Enum): Must be present.
		@NotNull(message = "Account type is mandatory.")
		private AccountType accountType; // Assuming AccountType enum is defined
		
		// Account Holder Name: Must be present.
		@NotBlank(message = "Account holder name is mandatory.")
	    @Size(max = 100, message = "Account holder name cannot exceed 100 characters.")
		private String accountHolderName;
		
		
		// Nested DTO: If this contains additional bank details related to the request, validate it.
		@Valid // Ensures that validation inside the nested DTO is processed
		@NotNull(message = "Bank account information is mandatory.")
		private EmployeeBankAccountInfoDto bankAccountInfo;
	
	

}
