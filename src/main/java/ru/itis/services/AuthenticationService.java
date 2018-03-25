package ru.itis.services;

import org.springframework.security.core.Authentication;
import ru.itis.models.Users;
import ru.itis.security.providers.AuthProvider;

import java.util.Optional;


public interface AuthenticationService  {
    Users getUserByAuthentication(Authentication authentication);
}
