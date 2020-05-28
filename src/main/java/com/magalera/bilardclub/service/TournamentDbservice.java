package com.magalera.bilardclub.service;

import com.magalera.bilardclub.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TournamentDbservice {
    @Autowired
    private TournamentRepository repository;
}
