package com.magalera.bilardclub.service;

import com.magalera.bilardclub.repository.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PricesDbService {
    @Autowired
    private PricesRepository repository;
}
