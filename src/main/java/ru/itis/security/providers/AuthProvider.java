package ru.itis.security.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.models.Users;
import ru.itis.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    UserRepository usersRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        System.out.println(email);
        // получаем пароль
        String password = authentication.getCredentials()
                .toString();
        Optional<Users> usersList = usersRepository.findByEmail(email);
        if (usersList.isPresent()) {
            Users user = usersList.get();
        }
            UserDetails details = userDetailsService.loadUserByUsername(email);
            return new UsernamePasswordAuthenticationToken(details, password);
        }


    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
