package com.vukm.restapi.dtos.user;

/**
 * @author kieuvu
 * Created on 25/06/2023.
 */
public class CreateUserRequestDTO {
    private String username;
    private String email;
    private String password;

    public String getUsername() {
        return username;
    }

    public CreateUserRequestDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateUserRequestDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CreateUserRequestDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}