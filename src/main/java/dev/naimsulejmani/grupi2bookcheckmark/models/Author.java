package dev.naimsulejmani.grupi2bookcheckmark.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private long id;
    private String name;
    private String surname;
    private String middleName;
    private String bio;
    private String imageUrl;
}
