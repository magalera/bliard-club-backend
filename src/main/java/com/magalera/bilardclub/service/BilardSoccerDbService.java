package com.magalera.bilardclub.service;

import com.magalera.bilardclub.repository.BilardSoccerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BilardSoccerDbService {
    @Autowired
    private BilardSoccerRepository repository;
}
