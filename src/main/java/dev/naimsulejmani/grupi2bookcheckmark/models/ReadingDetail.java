package dev.naimsulejmani.grupi2bookcheckmark.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReadingDetail {
    private long id;
    private long readingId;
    private long bookId;
    private long userId;
    private int pageNumber;
    private LocalDate date;
    private String comment;
    private String location;

}
