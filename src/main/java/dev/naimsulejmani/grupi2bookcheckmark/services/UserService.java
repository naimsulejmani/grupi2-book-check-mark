package dev.naimsulejmani.grupi2bookcheckmark.services;

import dev.naimsulejmani.grupi2bookcheckmark.dtos.UserDto;
import dev.naimsulejmani.grupi2bookcheckmark.dtos.UserListDto;

import java.util.List;

public interface UserService {

    UserDto findById(Long id);

    UserDto login(String username, String password);

    List<UserListDto> getUserListing();
    //User login(String username, String password);
}

/*
    Nese mappimi ndodhe ne service, servisi kthen Dto dhe jo modelin e databazes(entity)
    nese mappimi ndodhe ne controller, controlleri kthen Dto dhe servici kthen modelin e databazes(entity)


 */