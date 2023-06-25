package com.vukm.restapi.dtos.auth;

/**
 * @author kieuvu
 * Created on 25/06/2023.
 */
public class RegisterRequestDTO {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}