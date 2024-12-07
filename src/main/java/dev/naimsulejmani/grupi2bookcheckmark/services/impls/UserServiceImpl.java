package dev.naimsulejmani.grupi2bookcheckmark.services.impls;

import dev.naimsulejmani.grupi2bookcheckmark.dtos.UserDto;
import dev.naimsulejmani.grupi2bookcheckmark.mappers.UserMapper;
import dev.naimsulejmani.grupi2bookcheckmark.models.User;
import dev.naimsulejmani.grupi2bookcheckmark.repositories.UserRepository;
import dev.naimsulejmani.grupi2bookcheckmark.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserDto login(String username, String password) {
        Optional<User> optionalUser = repository.findByUsername(username);

        if (optionalUser.isEmpty()) {
            System.out.println("User not found");
            return null;
        }

        User user = optionalUser.get();

        if (!user.getPassword().equals(password)) {
            System.out.println("Password is incorrect");
            return null;
        }

//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setSurname(user.getSurname());
//        userDto.setUsername(user.getUsername());
//        userDto.setEmail(user.getEmail());
//        userDto.setImageUrl(user.getImageUrl());
//        userDto.setInterests(user.getInterests());
//        userDto.setBirthdate(user.getBirthdate());
//        userDto.setAddress(user.getAddress());
//        userDto.setCity(user.getCity());
//        userDto.setCountry(user.getCountry());
//        userDto.setPostalCode(user.getPostalCode());
//        userDto.setGender(user.getGender());
        // return userDto;


        return mapper.toDto(user);
    }
}













