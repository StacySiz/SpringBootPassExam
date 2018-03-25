package ru.itis.services;

import org.springframework.security.core.Authentication;
import ru.itis.models.Users;


public interface AuthenticationService  {
    Users getUserByAuthentication(Authentication authentication);
}
