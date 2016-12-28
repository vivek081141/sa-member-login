package org.sa.auth.entity;

/**
 * Enumerated {@link User} roles.
 *  The USER PREDEFINED ROLES
 *
 *
 * Aug 16, 2016
 */
public enum Role {
    ADMIN, PREMIUM_MEMBER, MEMBER;
    
    public String authority() {
        return "ROLE_" + this.name();
    }
}
