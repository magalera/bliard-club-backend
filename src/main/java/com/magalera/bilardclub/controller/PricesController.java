package com.magalera.bilardclub.controller;

import com.magalera.bilardclub.mapper.PricesMapper;
import com.magalera.bilardclub.service.PricesDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/prices")
public class PricesController {
    @Autowired
    private PricesDbService service;
    @Autowired
    private PricesMapper mapper;
}
