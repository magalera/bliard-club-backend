package com.magalera.bilardclub.controller;

import com.magalera.bilardclub.domain.User;
import com.magalera.bilardclub.domain.UserDto;
import com.magalera.bilardclub.mapper.UserMapper;
import com.magalera.bilardclub.repository.UserRepository;
import com.magalera.bilardclub.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserDbService service;
    @Autowired
    private UserMapper mapper;
    @Autowired
    private UserRepository repository;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public UserDto registration(@RequestBody UserDto userDto) {
        User user = repository.save(mapper.mapToUser(userDto));
        return mapper.mapToUserDto(user);
    }

    @PostMapping("/login")
    public UserDto logIn(@RequestBody UserDto user){
        return mapper.mapToUserDto(service.logIn(user.getEmail(), user.getPassword()));
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public UserDto update(@RequestBody UserDto userDto) {
        User user = repository.save(mapper.mapToUser(userDto));
        return mapper.mapToUserDto(user);
    }
}
