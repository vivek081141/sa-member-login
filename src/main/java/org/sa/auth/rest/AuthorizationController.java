package org.sa.auth.rest;

import org.sa.auth.model.UserModel;
import org.sa.auth.security.model.token.JwtToken;
import org.sa.auth.security.model.token.JwtTokenFactory;
import org.sa.auth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vivek on 12/20/2016.
 */
@RestController
@RequestMapping("/api")
public class AuthorizationController {

    private JwtTokenFactory tokenFactory;
    private UserService userService;

    @Autowired
    public  AuthorizationController(UserService userService,JwtTokenFactory tokenFactory ){
        this.userService=userService;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public UserModel authenticateUser() {
        String userName="vivek";
        String password="12345";
        UserModel model=userService.getByUsername(userName, password);
        if(model!=null){
            JwtToken accessToken = tokenFactory.createAccessJwtToken(model.getId());
            JwtToken refreshToken = tokenFactory.createRefreshToken(model.getId());

            Map<String, String> tokenMap = new HashMap<String, String>();
            tokenMap.put("token", accessToken.getToken());
            tokenMap.put("refreshToken", refreshToken.getToken());

           /* response.setStatus(HttpStatus.OK.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            mapper.writeValue(response.getWriter(), tokenMap);*/

        }
        return model;


    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public void getUserProfile(){
        System.out.println("My profile is getting called.");
    }
}
