package dev.naimsulejmani.grupi2bookcheckmark.dtos;

import dev.naimsulejmani.grupi2bookcheckmark.infrastructure.AgeBetween;
import dev.naimsulejmani.grupi2bookcheckmark.infrastructure.MinAge;
import dev.naimsulejmani.grupi2bookcheckmark.infrastructure.NotEquals;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestRegistrationDto {

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    private String surname;

    private String username;

    @Email(message = "Email is not valid")
    private String email;

    @Past(message = "Birthdate must be in the past")
    //@AtLeast18YearsOld(message = "You must be at least 18 years old")
//    @MinAge(value = 18, message = "You must be at least 18 years old")
    @AgeBetween(min=18, max=64, message = "You must be between 18 and 64 years old")
    private LocalDate birthdate;

    //@Not(value="Serbia", message = "You must not be from Serbia")
    //@NotEqual(value = "Serbia", message = "You must not be from Serbia")
    @NotEquals(value = "Serbia", message = "You must not be from Serbia")
    private String country;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "Password must contain at least one uppercase letter, one lowercase letter and one number")
    private String password;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "Password must contain at least one uppercase letter, one lowercase letter and one number")
    //@SameAs(field="password", message = "Passwords must match")
    private String confirmPassword;

    @AssertTrue(message = "You must accept the terms and conditions")
    private boolean acceptTerms;
}
