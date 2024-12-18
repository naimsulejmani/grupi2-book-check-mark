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

    private LocalDate birthdate;


    private String country;


    public String getFullName() {
        return name + " " + surname;
    }
}
