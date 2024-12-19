package dev.naimsulejmani.grupi2bookcheckmark.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "authors")
//@Table(name = "authors", schema = "HR")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PositiveOrZero
    private long id;


    @Column(nullable = false, length = 50)
    @NotBlank
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
    private String name;
    @Column(nullable = false, length = 50)
    @NotNull
    @NotBlank
    @Size(min = 2, max = 50, message = "Surname should be between 2 and 50 characters")
    private String surname;
    @Column(length = 25)
    @Size(max = 25, message = "Nickname should be less than 25 characters")
    private String nickname; // middle_name
    @Column(length = 4000)
    @Size(max = 4000, message = "Bio should be less than 4000 characters")
    private String bio;
    @Column(length = 2000)
    //  /images/authors/author_1.jpg
    private String imageUrl;

    @Column(length = 100, unique = true)
    @Email(message = "Email should be valid")
    private String email;
    // alter table authors add column birthdate timestamp
    @Column(nullable = false)
    @Past(message = "Birthdate should be in the past")
//    @AtLeast18YearsOld(message = "Author should be at least 18 years old")
    private LocalDate birthdate;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false, updatable = false, length = 50)
    private String createdBy;

    private LocalDateTime modifiedAt;
    private String modifiedBy;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;
}








