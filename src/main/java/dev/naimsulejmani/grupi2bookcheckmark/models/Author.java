package dev.naimsulejmani.grupi2bookcheckmark.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "authors")
//@Table(name = "authors", schema = "public")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String surname;
    @Column(length = 25)
    private String middleName; // middle_name
    @Column(length = 4000)
    private String bio;
    @Column(length = 100)
    //  /images/authors/author_1.jpg
    private String imageUrl="/images/authors/author_1.jpg"; //image_url

    @Column(length = 100, unique = true)
    private String email;
}
