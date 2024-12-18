package dev.naimsulejmani.grupi2bookcheckmark.infrastructure;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotEqualValidator.class)
@Documented
public @interface NotEquals {

    String message() default "You should not be equal to {value}!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value(); // The minimum age

}