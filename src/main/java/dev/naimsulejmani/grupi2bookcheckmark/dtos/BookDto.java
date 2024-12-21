package dev.naimsulejmani.grupi2bookcheckmark.dtos;

import dev.naimsulejmani.grupi2bookcheckmark.enums.BookCategory;
import dev.naimsulejmani.grupi2bookcheckmark.enums.BookPageFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    @PositiveOrZero
    private long id;

    @NotNull(message = "ISBN should not be null")
    @NotBlank(message = "ISBN should not be blank")
    @Size(min = 13, max = 13, message = "ISBN should be 13 characters")
    private String isbn;

    @NotNull(message = "Title should not be null")
    @NotBlank(message = "Title should not be blank")
    @Size(max = 100, message = "Title should be at most 100 characters")
    private String title;


    @NotNull(message = "Publisher should not be null")
    @NotBlank(message = "Publisher should not be blank")
    @Size(max = 100, message = "Publisher should be at most 100 characters")
    private String publisher;


    @Positive(message = "Year should be positive")
    @Min(value = 1900, message = "Year should be at least 1900")
    private int year;

    @NotNull(message = "Category should not be null")
    private BookCategory category;

    @Size(max = 4000, message = "Description should be at most 4000 characters")
    private String description;

    @Size(max = 100, message = "Cover URL should be at most 100 characters")
    private String coverUrl;

    @Positive(message = "Total pages should be positive")
    @Min(value = 1, message = "Total pages should be at least 1")
    private int totalPages;

    @NotNull(message = "Page format should not be null")
    private BookPageFormat pageFormat;

    @PositiveOrZero(message = "Price should be a positive number")
    private double price;

    @Positive(message = "AuthorID should be positive")
    private long authorId;

}
