package org.sa.auth.security.auth.jwt.verifier;

/**
 * 
 *
 * Aug 17, 2016
 */
public interface TokenVerifier {
    public boolean verify(String jti);
}
