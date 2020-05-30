package com.magalera.bilardclub.controller;

import com.magalera.bilardclub.domain.CityDto;
import com.magalera.bilardclub.mapper.CityMapper;
import com.magalera.bilardclub.repository.CityRepository;
import com.magalera.bilardclub.service.CityDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/city")
public class CityController {
    @Autowired
    private CityDbService service;
    @Autowired
    private CityMapper mapper;
    @Autowired
    private CityRepository repository;

    @GetMapping("/{id}")
    public CityDto get(@PathVariable Long id){
    return mapper.mapToCityDto(repository.findById(id).get());
    }
}
