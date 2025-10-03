package com.aurionpro.payrollsystem.dto.employeeApplication;

import java.sql.Timestamp;

import com.aurionpro.payrollsystem.entity.employee.Employee;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PayslipDto {

	 private Long payslipId;

	    @NotNull(message = "Month is mandatory.")
	    @Min(value = 1, message = "Month must be between 1 and 12.")
	    private Integer month;

	    @NotNull(message = "Year is mandatory.")
	    @Min(value = 2000, message = "Year must be a valid year.")
	    private Integer year;

	    @NotBlank(message = "Payslip URL is mandatory.")
	    @Size(max = 255, message = "Payslip URL is too long.")
	    private String payslipUrl;

	    private Timestamp createdAt;

	    private Timestamp updatedAt;

	    @NotNull(message = "Employee ID is mandatory.")
	    private Employee employeeId;

}
