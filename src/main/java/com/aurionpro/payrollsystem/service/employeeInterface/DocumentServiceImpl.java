package com.aurionpro.payrollsystem.service.employeeInterface;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aurionpro.payrollsystem.dto.employeeDocs.DocumentDto;
import com.aurionpro.payrollsystem.dto.employeeDocs.DocumentTypeDto;
import com.aurionpro.payrollsystem.dto.employeeDocs.DocumentUploadDto;
import com.aurionpro.payrollsystem.entity.documents.DocumentRole;
import com.aurionpro.payrollsystem.entity.documents.DocumentType;
import com.aurionpro.payrollsystem.entity.documents.Documents;
import com.aurionpro.payrollsystem.repository.DocumentRepository;
import com.aurionpro.payrollsystem.repository.DocumentTypeRepository;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private DocumentTypeRepository documentTypeRepository;

	@Override
	@Transactional
	public DocumentDto saveDocument(DocumentUploadDto uploadDto) {
	    // Validate file size
	    uploadDto.validateFileSize();
	    
	    // Get document type for validation
	    DocumentType documentType = documentTypeRepository.findById(uploadDto.getDocumentTypeId())
	            .orElseThrow(() -> new RuntimeException("Document type not found with id: " + uploadDto.getDocumentTypeId()));
	    
	    // Validate file format matches document type
	    if (!documentType.getFileFormat().equals(uploadDto.getFileFormat())) {
	        throw new IllegalArgumentException(
	            String.format("File format mismatch. Expected: %s, Got: %s", 
	                documentType.getFileFormat(), uploadDto.getFileFormat())
	        );
	    }
	    
	    // Create NEW document entity
	    Documents document = new Documents();
	    document.setCloudinaryUrl(uploadDto.getCloudinaryUrl());
	    document.setDocumentSize(uploadDto.getDocumentSize());
	    document.setFileFormat(uploadDto.getFileFormat());
	   // document.setCreatedAt(new Timestamp(System.currentTimeMillis()));
	    
	    // Set employee
//	    Employee employee = new Employee();
//	    employee.setEmployeeId(uploadDto.getEmployeeId());
//	    document.setEmployeeId(employee);
//	    
//	    // Set organization
//	    Organization organization = new Organization();
//	    organization.setOrganizationId(uploadDto.getOrganizationId());
//	    document.setOrganziation(organization);
	    
	    // Set document type
	    document.setDocumentType(documentType);
	    
	    // Save document
	    Documents savedDocument = documentRepository.save(document);
	    
	    return convertToDto(savedDocument);
	}
	
	
	@Override
	public List<DocumentDto> getDocumentsByEmployeeId(Long employeeId) {
		List<Documents> documents = documentRepository.findByEmployeeIdWithDetails(employeeId);
		return documents.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@Override
	public DocumentDto getDocumentById(Long documentId) {
		Documents document = documentRepository.findByIdWithDetails(documentId)
				.orElseThrow(() -> new RuntimeException("Document not found with id: " + documentId));
		return convertToDto(document);
	}

	@Override
	public List<DocumentDto> getDocumentsByEmployeeIdAndDocumentType(Long employeeId, Long documentTypeId) {
		List<Documents> documents = documentRepository
				.findByEmployeeId_EmployeeIdAndDocumentType_DocumentTypeId(employeeId, documentTypeId);
		return documents.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@Override
//	    @Transactional
	public void deleteDocument(Long documentId) {
		Documents document = documentRepository.findById(documentId)
				.orElseThrow(() -> new RuntimeException("Document not found with id: " + documentId));
		documentRepository.delete(document);
	}

	@Override
	public List<DocumentTypeDto> getAllActiveDocumentTypes() {
		List<DocumentType> documentTypes = documentTypeRepository.findByIsActive(true);
		return documentTypes.stream().map(this::convertTypeToDto).collect(Collectors.toList());
	}

	@Override
	public List<DocumentTypeDto> getDocumentTypesByRole(String role) {
		DocumentRole documentRole = DocumentRole.valueOf(role.toUpperCase());
		List<DocumentType> documentTypes = documentTypeRepository.findByRoleAndIsActive(documentRole, true);
		return documentTypes.stream().map(this::convertTypeToDto).collect(Collectors.toList());
	}

	private DocumentDto convertToDto(Documents document) {
		DocumentDto dto = new DocumentDto();
		dto.setDocumentId(document.getDocumentId());
		dto.setCloudinaryUrl(document.getCloudinaryUrl());
		dto.setDocumentSize(document.getDocumentSize());
		dto.setFileFormat(document.getFileFormat());
		//dto.setCreatedAt(document.getCreatedAt());
		//dto.setUpdatedAt(document.getUpdatedAt());

//		if (document.getEmployeeId() != null) {
//			dto.setEmployeeId(document.getEmployeeId().getEmployeeId());
//			dto.setEmployeeName(document.getEmployeeId().getFirstName() + " " + document.getEmployeeId().getLastName());
//		}
//
//		if (document.getOrganziation() != null) {
//			dto.setOrganizationId(document.getOrganziation().getOrganizationId());
//			dto.setOrganizationName(document.getOrganziation().getOrganizationName());
//		}
		DocumentTypeDto typedto = new DocumentTypeDto();
		if (document.getDocumentType() != null) {
			typedto.setDocumentTypeId(document.getDocumentType().getDocumentTypeId());
			typedto.setDocumentTypeName(document.getDocumentType().getDocumentTypeName());
		}

		return dto;
	}

	private DocumentTypeDto convertTypeToDto(DocumentType documentType) {
		DocumentTypeDto dto = new DocumentTypeDto();
		dto.setDocumentTypeId(documentType.getDocumentTypeId());
		dto.setDocumentTypeName(documentType.getDocumentTypeName());
		dto.setFileFormat(documentType.getFileFormat());
		dto.setMaxSize(documentType.getMaxSize());
		dto.setRole(documentType.getRole());
		dto.setCompulsory(documentType.getCompulsory());
		return dto;
	}

//	private String formatFileSize(Integer sizeInBytes) {
//		if (sizeInBytes == null) {
//			return "Unknown";
//		}
//
//		double sizeInMB = sizeInBytes / (1024.0 * 1024.0);
//		if (sizeInMB >= 1.0) {
//			return String.format("%.2f MB", sizeInMB);
//		}
//
//		double sizeInKB = sizeInBytes / 1024.0;
//		return String.format("%.2f KB", sizeInKB);
//	}

}
