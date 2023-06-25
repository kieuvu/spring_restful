package com.vukm.restapi.repositories;

import com.vukm.restapi.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kieuvu
 * Created on 25/06/2023.
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);    
}