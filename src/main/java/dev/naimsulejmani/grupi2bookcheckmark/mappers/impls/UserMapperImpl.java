package dev.naimsulejmani.grupi2bookcheckmark.mappers.impls;

import dev.naimsulejmani.grupi2bookcheckmark.dtos.UserDto;
import dev.naimsulejmani.grupi2bookcheckmark.dtos.UserListDto;
import dev.naimsulejmani.grupi2bookcheckmark.dtos.UserRequestRegistrationDto;
import dev.naimsulejmani.grupi2bookcheckmark.mappers.UserMapper;
import dev.naimsulejmani.grupi2bookcheckmark.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setBirthdate(user.getBirthdate());
        userDto.setCountry(user.getCountry());
        return userDto;
    }

    @Override
    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setBirthdate(userDto.getBirthdate());
        user.setCountry(userDto.getCountry());
        return user;
    }

    @Override
    public User userRequestRegistrationDtoToUser(UserRequestRegistrationDto userRequestRegistrationDto) {
        User user = new User();
        user.setName(userRequestRegistrationDto.getName());
        user.setSurname(userRequestRegistrationDto.getSurname());
        user.setUsername(userRequestRegistrationDto.getUsername());
        user.setEmail(userRequestRegistrationDto.getEmail());
        user.setBirthdate(userRequestRegistrationDto.getBirthdate());
        user.setCountry(userRequestRegistrationDto.getCountry());
        return user;
    }

    @Override
    public UserListDto toUserListDto(User user) {
        UserListDto uld = new UserListDto();
        uld.setId(user.getId());
        uld.setName(user.getName());
        uld.setSurname(user.getSurname());
        uld.setUsername(user.getUsername());
        uld.setEmail(user.getEmail());
        return uld;
    }
}
