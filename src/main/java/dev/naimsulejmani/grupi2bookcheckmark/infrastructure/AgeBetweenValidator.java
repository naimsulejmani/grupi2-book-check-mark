package dev.naimsulejmani.grupi2bookcheckmark.infrastructure;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

public class AgeBetweenValidator implements ConstraintValidator<AgeBetween, LocalDate> {

    private int minAge;
    private int maxAge;

    @Override
    public void initialize(AgeBetween constraintAnnotation) {

        this.minAge = constraintAnnotation.min();
        this.maxAge = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(LocalDate birthdate, ConstraintValidatorContext context) {
        if (birthdate == null) {
            return true; // Allow null values, handle with @NotNull if needed
        }
        return Period.between(birthdate, LocalDate.now()).getYears() >= minAge
                && Period.between(birthdate, LocalDate.now()).getYears() <= maxAge;
    }
}










