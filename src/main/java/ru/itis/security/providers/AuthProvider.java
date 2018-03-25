package ru.itis.security.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.models.Users;
import ru.itis.repository.UserRepository;

import java.util.Collection;
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
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String email = String.valueOf(auth.getPrincipal());
        String email = authentication.getName();

//        String email = String.valueOf(authentication.getPrincipal());
        System.out.println("THIS EMAIL IS FROM AUTHENTICATION "+ email);
        // получаем пароль
        String password = authentication.getCredentials()
                .toString();
        System.out.println("THIS PASSWORD IS FROM AUTHENTICATION "+ password);

        Optional<Users> usersList = usersRepository.findByEmail(email);
        if (usersList.isPresent()) {
            Users user = usersList.get();
            usersRepository.save(user);
        }
            UserDetails details = userDetailsService.loadUserByUsername(email);
        Collection<? extends GrantedAuthority> authorities = details.getAuthorities();

        System.out.println("PREPARING TO RETURN AUTH PARAMETERS");
            return new UsernamePasswordAuthenticationToken(details, password,authorities);
        }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
