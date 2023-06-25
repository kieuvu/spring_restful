package com.vukm.restapi.dtos.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @author kieuvu
 * Created on 25/06/2023.
 */
public class RegisterRequestDTO {
    @NotEmpty(message = "The email field is required.")
    @Email(message = "The email must be a valid email address.")
    private String email;

    @NotEmpty(message = "The username field is required.")
    @Min(value = 4, message = "The username must have at least 4 characters.")
    private String username;

    @NotEmpty(message = "The password field is required")
    @Min(value = 8, message = "Password must be at least 8 characters long")
    private String password;

    public String getUsername() {
        return username;
    }

    public RegisterRequestDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterRequestDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterRequestDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}