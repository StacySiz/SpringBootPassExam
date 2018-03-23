package ru.itis.services;

import ru.itis.forms.RegistrationForm;
import ru.itis.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.repository.UserRepository;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
    @Autowired
    private UserRepository userRepository;

//    private  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void registration(RegistrationForm registrationForm) {
        Users newUser = Users.builder()
                .firstName(registrationForm.getFirstName())
                .password((registrationForm.getPassword()))
                .lastName(registrationForm.getLastName())
                .email(registrationForm.getEmail())
                .build();
//        users.setPassword(passwordEncoder.encode(registrationForm.getPassword()));
        userRepository.save(newUser);
    }
}
