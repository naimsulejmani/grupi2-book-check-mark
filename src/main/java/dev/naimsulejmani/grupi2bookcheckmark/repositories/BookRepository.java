package dev.naimsulejmani.grupi2bookcheckmark.repositories;


import dev.naimsulejmani.grupi2bookcheckmark.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByIsbn(String isbn); //SELECT * FROM books WHERE isbn = ?;
    List<Book> findAllByCategory(String category); //SELECT * FROM books WHERE category = ?;
    List<Book> findAllByTitleContaining(String title); //SELECT * FROM books WHERE title LIKE ?;
    List<Book> findAllByYearBetween(int from, int to); //SELECT * FROM books WHERE year BETWEEN ? AND ?;

    List<Book> findAllByTitleOrDescriptionOrderByPriceDesc(String title, String description);
    //SELECT * FROM books WHERE title = ? OR description = ? ORDER BY price DESC;
}
