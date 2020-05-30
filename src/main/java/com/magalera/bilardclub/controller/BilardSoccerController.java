package com.magalera.bilardclub.controller;

import com.magalera.bilardclub.domain.BilardSoccer;
import com.magalera.bilardclub.domain.BilardSoccerDto;
import com.magalera.bilardclub.mapper.BilardSoccerMapper;
import com.magalera.bilardclub.repository.BilardSoccerRepository;
import com.magalera.bilardclub.service.BilardSoccerDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/bilardSoccer")
public class BilardSoccerController {
    @Autowired
    private BilardSoccerDbService service;
    @Autowired
    private BilardSoccerMapper mapper;
    @Autowired
    private BilardSoccerRepository repository;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public BilardSoccerDto add(@RequestBody BilardSoccerDto bilardSoccerDto) {
        BilardSoccer bilardSoccer = repository.save(mapper.mapToBilardSoccer(bilardSoccerDto));
        return mapper.mapToBilardSoccerDto(bilardSoccer);
    }

    @GetMapping("/{id}")
    public BilardSoccerDto get(@PathVariable Long id) {
        return mapper.mapToBilardSoccerDto(repository.findById(id).get());
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public BilardSoccerDto update(@RequestBody BilardSoccerDto bilardSoccerDto) {
        BilardSoccer bilardSoccer = repository.save(mapper.mapToBilardSoccer(bilardSoccerDto));
        return mapper.mapToBilardSoccerDto(bilardSoccer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
