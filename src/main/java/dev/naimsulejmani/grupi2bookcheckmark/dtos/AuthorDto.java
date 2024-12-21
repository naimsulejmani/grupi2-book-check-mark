package dev.naimsulejmani.grupi2bookcheckmark.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {
    @PositiveOrZero(message = "Id should be a positive number")
    private long id;

    @NotNull(message = "Name should not be null")
    @NotBlank(message = "Name should not be blank")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Surname should not be null")
    @NotBlank(message = "Surname should not be blank")
    @Size(min = 2, max = 50, message = "Surname should be between 2 and 50 characters")
    private String surname;

    @Size(max = 25, message = "Nickname should be at most 25 characters")
    private String nickname; // middle_name

    @Size(max = 4000, message = "Bio should be at most 4000 characters")
    private String bio;

    @Size(max = 2000, message = "Image URL should be at most 2000 characters")
    private String imageUrl;

    @NotNull(message = "Email should not be null")
    @Size(max = 100, message = "Email should be at most 100 characters")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Birthdate should not be null")
    @Past(message = "Birthdate should be in the past")
    private LocalDate birthdate;


    private LocalDateTime createdAt = LocalDateTime.now();

    private String createdBy;

    private LocalDateTime modifiedAt;
    private String modifiedBy;
}
