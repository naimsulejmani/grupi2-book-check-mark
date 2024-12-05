package dev.naimsulejmani.grupi2bookcheckmark.repositories;

import dev.naimsulejmani.grupi2bookcheckmark.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByEmail(String email); // SELECT * FROM authors WHERE email = ?;
    Long countAllByEmailContaining(String email);// SELECT COUNT(*) FROM authors WHERE email LIKE %?%;
    List<Author> findAllByNameContainingOrSurnameContainingOrderByBirthdateDesc(String name, String surname);
    // SELECT * FROM authors WHERE name LIKE %?% OR surname LIKE %?%;
}