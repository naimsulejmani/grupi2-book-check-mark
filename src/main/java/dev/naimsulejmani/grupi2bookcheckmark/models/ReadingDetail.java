package dev.naimsulejmani.grupi2bookcheckmark.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "reading_details")
public class ReadingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "reading_id")
    private Reading reading;

    @Column(nullable = false)
    private int currentReadingPage; //
    private LocalDate date;
    private String comment;
    private String location;

}
