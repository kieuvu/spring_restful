package com.vukm.restapi.services.auth;

import com.vukm.restapi.dtos.auth.LoginRequestDTO;
import com.vukm.restapi.dtos.auth.RegisterRequestDTO;
import com.vukm.restapi.dtos.user.CreateUserRequestDTO;
import com.vukm.restapi.exceptions.api.ApiException;
import com.vukm.restapi.exceptions.api.BadRequestException;
import com.vukm.restapi.services.jwt.JwtService;
import com.vukm.restapi.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kieuvu
 * Created on 25/06/2023.
 */
@Service
public class AuthService {
    private final UserService           userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService            jwtService;

    @Autowired
    public AuthService(UserService userService,
                       BCryptPasswordEncoder bCryptPasswordEncoder,
                       AuthenticationManager authenticationManager,
                       JwtService jwtService) {
        this.userService           = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService            = jwtService;
    }

    public void register(RegisterRequestDTO request) throws ApiException {
        String email    = request.getEmail();
        String username = request.getUsername();
        String password = request.getPassword();

        boolean isUserAlreadyExists = this.userService.isUserAlreadyExists(email);

        if (isUserAlreadyExists) throw new BadRequestException("User Already Exists");

        String hashedPassword = this.bCryptPasswordEncoder.encode(password);

        this.userService.createNewUser(new CreateUserRequestDTO().setEmail(email)
                                                                 .setPassword(hashedPassword)
                                                                 .setUsername(username));
    }

    public Map<String, String> authenticate(LoginRequestDTO request) {
        String email    = request.getEmail();
        String password = request.getPassword();

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));

        if (!authentication.isAuthenticated()) throw new UsernameNotFoundException("Unauthorized");

        String token = jwtService.generateToken(email);

        return new HashMap<String, String>() {{
            put("accessToken", token);
        }};
    }
}