package com.magalera.bilardclub.service;

import com.magalera.bilardclub.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableDbService {
    @Autowired
    private TableRepository repository;
}
