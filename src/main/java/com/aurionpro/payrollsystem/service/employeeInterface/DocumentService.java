package com.aurionpro.payrollsystem.service.employeeInterface;

import java.util.List;

import com.aurionpro.payrollsystem.dto.employeeDocs.DocumentDto;
import com.aurionpro.payrollsystem.dto.employeeDocs.DocumentTypeDto;
import com.aurionpro.payrollsystem.dto.employeeDocs.DocumentUploadDto;

public interface DocumentService {

	DocumentDto saveDocument(DocumentUploadDto uploadDto);

	List<DocumentDto> getDocumentsByEmployeeId(Long employeeId);

	DocumentDto getDocumentById(Long documentId);

	List<DocumentDto> getDocumentsByEmployeeIdAndDocumentType(Long employeeId, Long documentTypeId);

	void deleteDocument(Long documentId);

	    List<DocumentTypeDto> getAllActiveDocumentTypes();
	    
	    
	    List<DocumentTypeDto> getDocumentTypesByRole(String role);

}
