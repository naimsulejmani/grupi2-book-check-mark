package dev.naimsulejmani.grupi2bookcheckmark.repositories;

import dev.naimsulejmani.grupi2bookcheckmark.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
