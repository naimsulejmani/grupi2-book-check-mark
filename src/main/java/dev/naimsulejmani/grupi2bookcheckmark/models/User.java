package dev.naimsulejmani.grupi2bookcheckmark.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String surname;

    @Column(nullable = false, length = 50, unique = true)
    private String username;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(length = 500)
    private String imageUrl;

    @Column(length = 500)
    private String interests;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Column(nullable = false, length = 200)
    private String address;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false, length = 50)
    private String country;

    @Column(nullable = false, length = 10)
    private String postalCode;

    @Column(nullable = false, length = 1)
    private char gender;
}








