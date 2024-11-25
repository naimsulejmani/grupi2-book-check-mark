package dev.naimsulejmani.grupi2bookcheckmark.services;

import dev.naimsulejmani.grupi2bookcheckmark.models.Author;
import dev.naimsulejmani.grupi2bookcheckmark.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
        // SELECT * FROM authors;
    }

    public Author findById(long id) {
//      var author = authorRepository.findById(id);
//      if(author.isEmpty()) {
//          return null;
//      }
//      return author.get();
        return authorRepository.findById(id).orElse(null);
        // SELECT * FROM authors WHERE id = ?;
    }

    public Author save(Author author) {
        return authorRepository.save(author);
        // INSERT INTO authors (name, surname, middle_name, bio, image_url, email) VALUES (?, ?, ?, ?, ?, ?);
        // or
        // UPDATE authors SET name = ?, surname = ?, middle_name = ?, bio = ?, image_url = ?, email = ? WHERE id = ?;
    }

    public void deleteById(long id) {
        authorRepository.deleteById(id);
        // DELETE FROM authors WHERE id = ?;
    }


}








