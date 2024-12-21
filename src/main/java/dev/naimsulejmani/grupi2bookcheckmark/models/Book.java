package dev.naimsulejmani.grupi2bookcheckmark.models;

import dev.naimsulejmani.grupi2bookcheckmark.enums.BookCategory;
import dev.naimsulejmani.grupi2bookcheckmark.enums.BookPageFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 13, unique = true)
    private String isbn;

    /*

    CREATE TABLE books (
        title varchar(100) NOT NULL
    )

    <input type='text' name='titulli'/>
     */

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 100)
    private String publisher;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private BookCategory category;

    @Column(nullable = false, length = 4000)
    private String description;

    @Column(nullable = false, length = 100)
    private String coverUrl;

    private int totalPages;

    @Column(length = 5)
    @Enumerated(EnumType.STRING)
    private BookPageFormat pageFormat;

    @Column(nullable = false, precision = 10)
    private double price;

    @OneToMany(mappedBy = "book")
    private List<Reading> readings;

    @OneToMany(mappedBy = "book")
    private List<Review> reviews; // List<Review>

    @ManyToMany()
    @JoinTable(
            name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"book_id", "author_id"})
    )
    private List<Author> authors;
}









