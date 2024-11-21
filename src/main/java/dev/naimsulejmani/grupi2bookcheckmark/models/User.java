package dev.naimsulejmani.grupi2bookcheckmark.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private String imageUrl;
    private String interests;
    private LocalDate birthdate;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private char gender;
}
