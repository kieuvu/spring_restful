package com.vukm.restapi.services.auth;

import com.vukm.restapi.dtos.auth.RegisterRequestDTO;
import com.vukm.restapi.dtos.user.CreateUserRequestDTO;
import com.vukm.restapi.exceptions.api.ApiException;
import com.vukm.restapi.exceptions.api.BadRequestException;
import com.vukm.restapi.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author kieuvu
 * Created on 25/06/2023.
 */
@Service
public class AuthService implements AuthServiceInterface {
    private final UserService           userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AuthService(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService           = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void register(RegisterRequestDTO request) throws ApiException {
        String email    = request.getEmail();
        String username = request.getUsername();
        String password = request.getPassword();

        if (this.userService.isUserAlreadyExists(email)) {
            throw new BadRequestException("User Already Exists");
        }

        String hashedPassword = this.bCryptPasswordEncoder.encode(password);

        this.userService.createNewUser(new CreateUserRequestDTO().setEmail(email)
                                                                 .setPassword(hashedPassword)
                                                                 .setUsername(username));
    }
}