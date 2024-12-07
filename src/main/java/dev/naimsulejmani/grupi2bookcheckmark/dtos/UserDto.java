package dev.naimsulejmani.grupi2bookcheckmark.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private long id;

    private String name;

    private String surname;

    private String username;

    private String email;

    private String imageUrl;

    private String interests;

    private LocalDate birthdate;

    private String address;

    private String city;

    private String country;

    private String postalCode;

    private char gender;

    public String getFullName() {
        return name + " " + surname;
    }
}
