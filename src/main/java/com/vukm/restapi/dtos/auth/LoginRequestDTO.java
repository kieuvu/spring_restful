package com.vukm.restapi.dtos.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @author kieuvu
 * Created on 02/07/2023.
 */
public class LoginRequestDTO {
    @NotEmpty(message = "The email field is required.")
    private String email;

    @NotEmpty(message = "The password field is required")
    private String password;

    public String getEmail() {
        return email;
    }

    public LoginRequestDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginRequestDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}