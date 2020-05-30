package com.magalera.bilardclub.mapper;

import com.magalera.bilardclub.domain.User;
import com.magalera.bilardclub.domain.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .type(userDto.getType())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword()).build();
    }

    public UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .type(user.getType())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword()).build();
    }
}
