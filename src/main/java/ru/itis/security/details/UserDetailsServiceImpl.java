//rupackage ru.itis.security.details;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import ru.itis.models.Users;
//import ru.itis.repository.UserRepository;
//
//public class UserDetailsServiceImpl implements UserDetailsService {
//    private UserRepository userRepository;
//    public UserDetailsServiceImpl(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Users user = userRepository.findByEmail(email);
//        return new UserDetailsImpl(user);
//    }
//        return null;
//    }
//}
//user