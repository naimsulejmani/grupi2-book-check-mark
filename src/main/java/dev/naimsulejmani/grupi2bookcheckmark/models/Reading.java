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
public class Reading {
    private long id;
    private long bookId;
    private long userId;
    private int currentPage;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean finished;
}
