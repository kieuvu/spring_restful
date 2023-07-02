package com.vukm.restapi.actions.auth;

import com.vukm.restapi.dtos.auth.LoginRequestDTO;
import com.vukm.restapi.services.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author kieuvu
 * Created on 02/07/2023.
 */
@RestController
public class LoginAction {
    private final AuthService authService;

    @Autowired
    public LoginAction(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("auth/login")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> handle(@Valid @RequestBody LoginRequestDTO request) {
        return this.authService.authenticate(request);
    }
}