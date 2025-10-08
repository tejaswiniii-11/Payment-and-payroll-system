package com.aurionpro.payrollsystem.dto.employeeDocs;

import org.hibernate.validator.constraints.URL;

import com.aurionpro.payrollsystem.entity.documents.DocumentType;
import com.aurionpro.payrollsystem.entity.documents.FileFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class DocumentUploadDto {

	@NotBlank(message = "Cloudinary URL is required")
	// @Pattern(regexp = "^https://res\\.cloudinary\\.com/.*", message = "Invalid
	// Cloudinary URL")
	@URL
	private String cloudinaryUrl;

//	@NotNull(message = "Employee ID is required")
//	private Long employeeId;
//
//	@NotNull(message = "Organization ID is required")
//	private Long organizationId;

	@NotNull(message = "Document Type ID is required")
	private Long documentTypeId;

	@NotNull(message = "Document size is required")
	private Integer documentSize; // Size in bytes

	@NotNull(message = "File format is required")
	private FileFormat fileFormat;

	// Max file size: 4 MB (4 * 1024 * 1024 bytes = 4194304 bytes)
	public static final long MAX_FILE_SIZE = 4 * 1024 * 1024; // 4 MB

	public void validateFileSize() {
		if (documentSize != null && documentSize > MAX_FILE_SIZE) {
			throw new IllegalArgumentException(
					String.format("File size exceeds maximum allowed size of 4 MB. Current size: %.2f MB",
							documentSize / (1024.0 * 1024.0)));
		}
	}

}
