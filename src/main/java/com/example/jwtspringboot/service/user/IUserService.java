package com.example.jwtspringboot.service.user;

import com.example.jwtspringboot.model.User;
import com.example.jwtspringboot.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);
}
