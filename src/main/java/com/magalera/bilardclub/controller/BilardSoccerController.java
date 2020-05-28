package com.magalera.bilardclub.controller;

import com.magalera.bilardclub.mapper.BilardSoccerMapper;
import com.magalera.bilardclub.service.BilardSoccerDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/bilardSoccer")
public class BilardSoccerController {
    @Autowired
    private BilardSoccerDbService service;
    @Autowired
    private BilardSoccerMapper mapper;
}
