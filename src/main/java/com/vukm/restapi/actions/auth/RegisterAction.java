package com.vukm.restapi.actions.auth;

import com.vukm.restapi.dtos.auth.RegisterRequestDTO;
import com.vukm.restapi.services.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kieuvu
 * Created on 25/06/2023.
 */
@RestController
public class RegisterAction {
    private final AuthService authService;

    @Autowired
    public RegisterAction(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("auth/register")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handle(@RequestBody RegisterRequestDTO request) {
        this.authService.register(request);
    }
}