package dev.naimsulejmani.grupi2bookcheckmark.mappers;

import dev.naimsulejmani.grupi2bookcheckmark.dtos.UserDto;
import dev.naimsulejmani.grupi2bookcheckmark.dtos.UserListDto;
import dev.naimsulejmani.grupi2bookcheckmark.models.User;

public interface UserMapper extends BasicMapper<UserDto, User> {
    //UserListDto toDtoList(User entity);
    UserListDto toUserListDto(User user);
}
