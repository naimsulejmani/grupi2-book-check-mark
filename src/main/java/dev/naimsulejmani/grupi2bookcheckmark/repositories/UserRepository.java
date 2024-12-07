package dev.naimsulejmani.grupi2bookcheckmark.repositories;

import dev.naimsulejmani.grupi2bookcheckmark.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    //User findByUsername(String username);

    Optional<User> findByEmail(String email);
    //User findByEmail(String email);

}
