package com.magalera.bilardclub.controller;

import com.magalera.bilardclub.mapper.BilardClubMapper;
import com.magalera.bilardclub.service.BilardClubDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/bilardClub")
public class BilardClubController {
    @Autowired
    private BilardClubDbService service;
    @Autowired
    private BilardClubMapper mapper;
}
