package com.magalera.bilardclub.controller;

import com.magalera.bilardclub.domain.Prices;
import com.magalera.bilardclub.domain.PricesDto;
import com.magalera.bilardclub.mapper.PricesMapper;
import com.magalera.bilardclub.repository.PricesRepository;
import com.magalera.bilardclub.service.PricesDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/prices")
public class PricesController {
    @Autowired
    private PricesDbService service;
    @Autowired
    private PricesMapper mapper;
    @Autowired
    private PricesRepository repository;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public PricesDto add(@RequestBody PricesDto pricesDto) {
        Prices prices = repository.save(mapper.mapToPrices(pricesDto));
        return mapper.mapToPricesDto(prices);
    }

    @GetMapping("/{id}")
    public PricesDto show(@PathVariable Long id) {
        return mapper.mapToPricesDto(repository.findById(id).get());
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public PricesDto update(@RequestBody PricesDto pricesDto) {
        Prices prices = repository.save(mapper.mapToPrices(pricesDto));
        return mapper.mapToPricesDto(prices);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

