package dev.naimsulejmani.grupi2bookcheckmark.models;

import dev.naimsulejmani.grupi2bookcheckmark.enums.BookCategory;
import dev.naimsulejmani.grupi2bookcheckmark.enums.BookPageFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private BookCategory category;
    private String description;
    private String coverUrl;
    private int totalPages;
    private BookPageFormat pageFormat;
    private double price;
}
