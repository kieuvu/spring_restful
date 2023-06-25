package com.vukm.restapi.services.user;

import com.vukm.restapi.dtos.user.CreateUserRequestDTO;
import com.vukm.restapi.entities.UserEntity;
import com.vukm.restapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kieuvu
 * Created on 25/06/2023.
 */
@Service
public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isUserAlreadyExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public void createNewUser(CreateUserRequestDTO request) {
        String email    = request.getEmail();
        String username = request.getUsername();
        String password = request.getPassword();

        UserEntity user = new UserEntity();
        user.setEmail(email)
            .setPassword(password)
            .setUsername(username);

        this.userRepository.save(user);
    }
}