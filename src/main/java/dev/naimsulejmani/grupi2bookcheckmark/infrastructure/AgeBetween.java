package dev.naimsulejmani.grupi2bookcheckmark.infrastructure;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeBetweenValidator.class)
@Documented
public @interface AgeBetween {

    String message() default "Age should be between {min} and {max}!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int min() default 0; // The minimum age
    int max() default 100; // The minimum age

}









