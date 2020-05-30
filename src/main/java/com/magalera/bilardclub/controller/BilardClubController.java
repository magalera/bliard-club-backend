package com.magalera.bilardclub.controller;

import com.magalera.bilardclub.domain.BilardClub;
import com.magalera.bilardclub.domain.BilardClubDto;
import com.magalera.bilardclub.mapper.BilardClubMapper;
import com.magalera.bilardclub.repository.BilardClubRepository;
import com.magalera.bilardclub.service.BilardClubDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/bilardClub")
public class BilardClubController {
    @Autowired
    private BilardClubDbService service;
    @Autowired
    private BilardClubMapper mapper;
    @Autowired
    private BilardClubRepository repository;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public BilardClubDto add(@RequestBody BilardClubDto bilardClubDto) {
        BilardClub bilardClub = repository.save(mapper.mapToBilardClub(bilardClubDto));
        return mapper.mapToBilardClubDto(bilardClub);
    }

    @GetMapping("/{id}")
    public BilardClubDto get(@PathVariable Long id) {
        return mapper.mapToBilardClubDto(repository.findById(id).get());
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public BilardClubDto update(@RequestBody BilardClubDto bilardClubDto) {
        BilardClub bilardClub = repository.save(mapper.mapToBilardClub(bilardClubDto));
        return mapper.mapToBilardClubDto(bilardClub);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
