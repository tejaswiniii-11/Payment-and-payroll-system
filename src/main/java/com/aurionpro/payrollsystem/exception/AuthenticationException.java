package com.aurionpro.payrollsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception to be thrown when authentication details (like the JWT principal/ID) are invalid or missing.
 * This is used by SecurityUtils to signal a failure in self-authorization.
 */
@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.UNAUTHORIZED) // Signals a 401 response status
public class AuthenticationException extends RuntimeException {

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
