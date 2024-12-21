package dev.naimsulejmani.grupi2bookcheckmark.dtos;

import dev.naimsulejmani.grupi2bookcheckmark.enums.Rating;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class ReviewDto {
    @PositiveOrZero(message = "Id should be positive or zero")
    private long id;

    @Positive(message = "User id should be positive")
    private long userId;

    @Positive(message = "Book id should be positive")
    private long bookId;

    @Size(max = 4000, message = "Comment should be at most 4000 characters")
    private String comment;

    @NotNull(message = "Rating should not be null")
    private Rating rating;

    @NotNull(message = "Review date should not be null")
    @PastOrPresent(message = "Review date should be in the past or present")
    private LocalDateTime reviewDate;
}
