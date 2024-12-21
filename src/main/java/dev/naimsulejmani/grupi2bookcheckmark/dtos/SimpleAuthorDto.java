package dev.naimsulejmani.grupi2bookcheckmark.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleAuthorDto {
    private long id;
    private String fullName;
    private String biography;
    private LocalDate birthdate;
}
