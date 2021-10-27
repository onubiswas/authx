package com.authsupp.api.authx.modules.models.req;

public class RegisterRequestBody {
    private String name;

//    private String username;

    private String email;

    private String password;


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setEmail() {
        this.email = email;
    }

    public void setPassword() {
        this.password = password;
    }
}
