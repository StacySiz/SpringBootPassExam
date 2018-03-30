package ru.itis.security.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
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
        System.out.println("THIS EMAIL IS FROM AUTHENTICATION " + email);
        String password = authentication.getCredentials()
                .toString();
        System.out.println("THIS PASSWORD IS FROM AUTHENTICATION " + password);

        Optional<Users> usersList = usersRepository.findByEmail(email);
        Users user = null;
        if (usersList.isPresent()) {
             user = usersList.get();
            System.out.println("THIS PASSWORD IS WRITTEN NOW" + password);
            System.out.println("THIS PASSWORD IS WRITTEN IN DATABASE" + user.getPassword());

        }
        UserDetails details = null;
        Collection<? extends GrantedAuthority> authorities = null;
        if (passwordEncoder.matches(password, user.getPassword())) {
             details = userDetailsService.loadUserByUsername(email);
             authorities = details.getAuthorities();

            System.out.println("PREPARING TO RETURN AUTH PARAMETERS");
        }
        return new UsernamePasswordAuthenticationToken(details, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
