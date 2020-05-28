package com.magalera.bilardclub.service;

import com.magalera.bilardclub.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityDbService {
    @Autowired
    private CityRepository repository;
}
