package dev.naimsulejmani.grupi2bookcheckmark.infrastructure;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

public class NotEqualValidator implements ConstraintValidator<NotEquals, Object> {

    private String value;

    @Override
    public void initialize(NotEquals constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        if (object == null) {
            return true; // Allow null values, handle with @NotNull if needed
        }
        return !object.equals(value);
    }
}










