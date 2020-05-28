package com.magalera.bilardclub.service;

import com.magalera.bilardclub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDbService {
    @Autowired
    private UserRepository repository;
}
