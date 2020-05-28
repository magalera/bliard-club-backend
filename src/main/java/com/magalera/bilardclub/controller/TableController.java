package com.magalera.bilardclub.controller;

import com.magalera.bilardclub.mapper.TableMapper;
import com.magalera.bilardclub.service.TableDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/table")
public class TableController {
    @Autowired
    private TableDbService service;
    @Autowired
    private TableMapper mapper;
}
