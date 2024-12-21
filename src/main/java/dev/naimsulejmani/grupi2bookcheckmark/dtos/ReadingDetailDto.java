package dev.naimsulejmani.grupi2bookcheckmark.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadingDetailDto {

    @PositiveOrZero(message = "Id should be positive or zero")
    private long id;

    @Positive(message = "Reading id should be positive")
    private long readingId;

    @PositiveOrZero(message = "Current reading page should be positive or zero")
    private int currentReadingPage; //
    @NotNull(message = "Date should not be null")
    @PastOrPresent(message = "Date should be in the past or present")
    private LocalDate date;
    @Size(max = 4000, message = "Comment should be at most 4000 characters")
    private String comment;
    @Size(max = 100, message = "Location should be at most 100 characters")
    private String location;
}