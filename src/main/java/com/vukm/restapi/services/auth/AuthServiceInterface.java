package com.vukm.restapi.services.auth;

import com.vukm.restapi.dtos.auth.RegisterRequestDTO;

public interface AuthServiceInterface {
    public void register(RegisterRequestDTO request);
}
