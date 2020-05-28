package com.magalera.bilardclub.service;

import com.magalera.bilardclub.repository.BilardClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BilardClubDbService {
    @Autowired
    private BilardClubRepository repository;
}
