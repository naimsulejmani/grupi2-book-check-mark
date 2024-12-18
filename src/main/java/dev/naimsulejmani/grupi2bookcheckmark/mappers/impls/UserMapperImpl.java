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
        userDto.setImageUrl(user.getImageUrl());
        userDto.setInterests(user.getInterests());
        userDto.setBirthdate(user.getBirthdate());
        userDto.setAddress(user.getAddress());
        userDto.setCity(user.getCity());
        userDto.setCountry(user.getCountry());
        userDto.setPostalCode(user.getPostalCode());
        userDto.setGender(user.getGender());
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
        user.setImageUrl(userDto.getImageUrl());
        user.setInterests(userDto.getInterests());
        user.setBirthdate(userDto.getBirthdate());
        user.setAddress(userDto.getAddress());
        user.setCity(userDto.getCity());
        user.setCountry(userDto.getCountry());
        user.setPostalCode(userDto.getPostalCode());
        return user;
    }

    @Override
    public User userRequestRegistrationDtoToUser(UserRequestRegistrationDto userRequestRegistrationDto) {
        User user = new User();
        user.setName(userRequestRegistrationDto.getName());
        user.setSurname(userRequestRegistrationDto.getSurname());
        user.setUsername(userRequestRegistrationDto.getUsername());
        user.setEmail(userRequestRegistrationDto.getEmail());
        user.setImageUrl(userRequestRegistrationDto.getImageUrl());
        user.setInterests(userRequestRegistrationDto.getInterests());
        user.setBirthdate(userRequestRegistrationDto.getBirthdate());
        user.setAddress(userRequestRegistrationDto.getAddress());
        user.setCity(userRequestRegistrationDto.getCity());
        user.setCountry(userRequestRegistrationDto.getCountry());
        user.setPostalCode(userRequestRegistrationDto.getPostalCode());
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
