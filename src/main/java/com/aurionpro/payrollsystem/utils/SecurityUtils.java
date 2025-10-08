package com.aurionpro.payrollsystem.utils;

import com.aurionpro.payrollsystem.exception.AuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Utility class to securely extract the authenticated user's ID from the Spring Security context.
 * The ID is derived from the JWT's principal (name) field and used to enforce self-authorization.
 */
public class SecurityUtils {

    /**
     * Extracts the Employee ID (Long) from the Authentication object.
     * This ID is the primary key (PK) for the Employee entity.
     * * @param authentication The Spring Security Authentication object (derived from JWT).
     * @return The employee's primary key (Long).
     * @throws AuthenticationException if the principal is missing or parsing fails.
     */
    public static Long getEmployeeIdFromAuthentication(Authentication authentication) {
        if (authentication == null || authentication.getName() == null) {
            // This should trigger if the JWT is invalid or the security context is empty
            throw new AuthenticationException("Authentication context is missing. Please log in again.");
        }

        try {
            // The authentication.getName() method returns the principal (Subject) from the JWT.
            // We assume the JWT subject contains the employee's ID as a String.
            return Long.parseLong(authentication.getName());
        } catch (NumberFormatException e) {
            // Handles cases where the ID in the JWT exists but is not a valid Long format.
            System.err.println("Error parsing employee ID from JWT principal: " + authentication.getName());
            throw new AuthenticationException("Invalid user ID format in authentication token.", e);
        }
    }

    /**
     * Helper method to retrieve the current authenticated user's ID anywhere in the application 
     * where the Authentication object is not readily available (e.g., inside a non-controller method).
     * * @return The employee's primary key (Long).
     * @throws AuthenticationException if authentication context is not present.
     */
    public static Long getCurrentEmployeeId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return getEmployeeIdFromAuthentication(authentication);
    }
}
