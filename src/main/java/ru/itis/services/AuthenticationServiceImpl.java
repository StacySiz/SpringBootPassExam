package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itis.models.Users;
import ru.itis.repository.UserRepository;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.security.providers.AuthProvider;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    public Users getUserByAuthentication(Authentication authentication) {
        UserDetailsImpl currentUserDetails = (UserDetailsImpl)authentication.getPrincipal();
        Users currentUserModel = currentUserDetails.getUser();
        Long currentUserId = currentUserModel.getId();
        System.out.println("CURRENT USER ID IS " + currentUserId);
        return userRepository.findOne(currentUserId);
    }


}
