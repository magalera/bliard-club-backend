package com.magalera.bilardclub.controller;

import com.magalera.bilardclub.mapper.UserMapper;
import com.magalera.bilardclub.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserDbService service;
    @Autowired
    private UserMapper mapper;
}
