package com.magalera.bilardclub.service;

import com.magalera.bilardclub.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationDbService {
    @Autowired
    private ReservationRepository repository;
}
