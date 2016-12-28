package org.sa.auth.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.sa.auth.security.auth.JwtAuthenticationToken;
import org.sa.auth.security.model.UserContext;

/**
 * End-point for retrieving logged-in user details.
 * 
 */
@RestController
public class ProfileEndpoint {
    @RequestMapping(value="/api/me", method=RequestMethod.GET)
    public @ResponseBody UserContext get(JwtAuthenticationToken token) {
        return (UserContext) token.getPrincipal();
    }

    @RequestMapping(value="/api/profile", method=RequestMethod.GET)
    public @ResponseBody UserContext getProfile(JwtAuthenticationToken token) {
        return (UserContext) token.getPrincipal();
    }
}
