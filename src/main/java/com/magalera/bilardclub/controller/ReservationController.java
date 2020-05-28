package com.magalera.bilardclub.controller;

import com.magalera.bilardclub.mapper.ReservationMapper;
import com.magalera.bilardclub.service.ReservationDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/reservation")
public class ReservationController {
    @Autowired
    private ReservationDbService service;
    @Autowired
    private ReservationMapper mapper;
}
