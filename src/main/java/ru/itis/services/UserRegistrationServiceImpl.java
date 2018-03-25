package ru.itis.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.itis.forms.RegistrationForm;
import ru.itis.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.repository.UserRepository;
import ru.itis.security.enums.Role;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void registration(RegistrationForm registrationForm) {
//        Users newUser = Users.builder()
//                .firstName(registrationForm.getFirstName())
//                .password(passwordEncoder.encode(registrationForm.getPassword()))
//                .lastName(registrationForm.getLastName())
//                .email(registrationForm.getEmail())
//                .role(Role.USER)
//                .build();
        Users newUser = new Users();
        newUser.setFirstName(registrationForm.getFirstName());
        newUser.setLastName(registrationForm.getLastName());
        newUser.setEmail(registrationForm.getEmail());
        newUser.setPassword(passwordEncoder.encode(registrationForm.getPassword()));
        newUser.setRole(Role.USER);
//        users.setPassword(passwordEncoder.encode(registrationForm.getPassword()));
        userRepository.save(newUser);
        System.out.println(userRepository.findByEmail(newUser.getEmail()).isPresent());
    }
}
