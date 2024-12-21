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
    @Column(nullable = false)
    private LocalDate date;
    @Column(length = 4000)
    private String comment;
    @Column(length = 100)
    private String location;

}
