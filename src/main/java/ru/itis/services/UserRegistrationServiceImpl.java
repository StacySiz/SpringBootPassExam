package ru.itis.services;

import ru.itis.forms.RegistrationForm;
import ru.itis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.repository.UserRepository;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
    @Autowired
    private UserRepository userRepository;

    private  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void registration(RegistrationForm registrationForm) {
        User user = new User();
        user.setFirstName(registrationForm.getFirstName());
        user.setLastName(registrationForm.getLastName());
        user.setEmail(registrationForm.getEmail());
        user.setPassword(passwordEncoder.encode(registrationForm.getPassword()));
        userRepository.save(user);
    }
}
