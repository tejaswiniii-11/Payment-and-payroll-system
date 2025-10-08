package com.aurionpro.payrollsystem.controller.employeeInterface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.payrollsystem.dto.employeeDocs.DocumentDto;
import com.aurionpro.payrollsystem.dto.employeeDocs.DocumentTypeDto;
import com.aurionpro.payrollsystem.dto.employeeDocs.DocumentUploadDto;
import com.aurionpro.payrollsystem.service.employeeInterface.DocumentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
//@CrossOrigin()
public class DocumentController {
	
	
	@Autowired
	private DocumentService documentService;
	
	@PostMapping("/documents")
    public ResponseEntity<DocumentDto> saveDocument(@Valid @RequestBody DocumentUploadDto uploadDto) {
        DocumentDto savedDocument = documentService.saveDocument(uploadDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDocument);
    }
    
    
    @GetMapping("/{employeeId}/documents")
    public ResponseEntity<List<DocumentDto>> getDocumentsByEmployeeId(@PathVariable Long employeeId) {
        List<DocumentDto> documents = documentService.getDocumentsByEmployeeId(employeeId);
        return ResponseEntity.ok(documents);
    }
    
    
    @GetMapping("/documents/{documentId}")
    public ResponseEntity<DocumentDto> getDocumentById(@PathVariable Long documentId) {
        DocumentDto document = documentService.getDocumentById(documentId);
        return ResponseEntity.ok(document);
    }
    
   
    @GetMapping("/{employeeId}/documents/type/{documentTypeId}")
    public ResponseEntity<List<DocumentDto>> getDocumentsByEmployeeIdAndDocumentType(
            @PathVariable Long employeeId,
            @PathVariable Long documentTypeId) {
        List<DocumentDto> documents = documentService.getDocumentsByEmployeeIdAndDocumentType(employeeId, documentTypeId);
        return ResponseEntity.ok(documents);
    }
    
   
    @DeleteMapping("/documents/{documentId}")
    public ResponseEntity<String> deleteDocument(@PathVariable Long documentId) {
        documentService.deleteDocument(documentId);
        return ResponseEntity.ok("Document deleted successfully");
    }
    
  
    @GetMapping("/documents/types")
    public ResponseEntity<List<DocumentTypeDto>> getAllActiveDocumentTypes() {
        List<DocumentTypeDto> documentTypes = documentService.getAllActiveDocumentTypes();
        return ResponseEntity.ok(documentTypes);
    }
    
   
    @GetMapping("/documents/types/role/{role}")
    public ResponseEntity<List<DocumentTypeDto>> getDocumentTypesByRole(@PathVariable String role) {
        List<DocumentTypeDto> documentTypes = documentService.getDocumentTypesByRole(role);
        return ResponseEntity.ok(documentTypes);
    }
    
  
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {
        ErrorResponse error = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.getMessage(),
            System.currentTimeMillis()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    
   
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorResponse error = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.getMessage(),
            System.currentTimeMillis()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    
    /**
     * Inner class for error response
     */
    @lombok.Data
    @lombok.AllArgsConstructor
    static class ErrorResponse {
        private int status;
        private String message;
        private long timestamp;
    }
}
