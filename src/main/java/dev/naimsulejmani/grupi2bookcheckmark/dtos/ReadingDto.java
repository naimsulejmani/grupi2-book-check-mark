package dev.naimsulejmani.grupi2bookcheckmark.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReadingDto {

    @PositiveOrZero(message = "Id should be positive")
    private long id;

    @Positive(message = "Book id should be positive")
    private long bookId;


    @Positive(message = "User id should be positive")
    private long userId;

    @PositiveOrZero(message = "Current page should be positive")
    private int currentPage;

    @NotNull(message = "Start date should not be null")
    private LocalDate startDate;

    private LocalDate endDate;

    private boolean finished;

    private List<ReadingDetailDto> readingDetails;
}
