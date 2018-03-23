package ru.itis.repository;
import ru.itis.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<Users,Long> {
    List<Users> findByEmail(String email);
}
