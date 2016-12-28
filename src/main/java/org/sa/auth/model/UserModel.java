package org.sa.auth.model;

import io.swagger.annotations.ApiModelProperty;

public class UserModel {
    private String id;

    @ApiModelProperty(name = "Account UserName", required = true)
    public String username;

    @ApiModelProperty(name = "Account Password", required = true)
    public String password;

    public UserModel() {
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
