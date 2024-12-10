package dev.naimsulejmani.grupi2bookcheckmark.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserListDto {
    private long id;
    private String name;
    private String surname;
    private String username;
    private String email;
}
