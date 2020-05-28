package com.magalera.bilardclub.controller;

import com.magalera.bilardclub.mapper.TournamentMapper;
import com.magalera.bilardclub.service.TournamentDbservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tournament")
public class TournamentController {
    @Autowired
    private TournamentDbservice service;
    @Autowired
    private TournamentMapper mapper;
}
