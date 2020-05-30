package com.magalera.bilardclub.service;

import com.magalera.bilardclub.domain.User;
import com.magalera.bilardclub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDbService {
    @Autowired
    private UserRepository repository;

    public User logIn(String email, String password){
        Optional<User> user = repository.findByEmail(email);
        if (user.isPresent()){
            User loggingUser = user.get();
            if (loggingUser.getEmail().equals(email) && loggingUser.getPassword().equals(password)){
                return loggingUser;
            }
            return new User();
        }
        return user.orElse(new User());
    }
}
