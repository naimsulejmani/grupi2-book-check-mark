package dev.naimsulejmani.grupi2bookcheckmark.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private long id;
    private long userId;
    private long bookId;
    private String comment;
    private Rating rating;
    private LocalDateTime reviewDate;
}
