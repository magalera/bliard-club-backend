package com.magalera.bilardclub.controller;

import com.magalera.bilardclub.domain.Tournament;
import com.magalera.bilardclub.domain.TournamentDto;
import com.magalera.bilardclub.mapper.TournamentMapper;
import com.magalera.bilardclub.repository.TournamentRepository;
import com.magalera.bilardclub.service.TournamentDbservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/tournament")
public class TournamentController {
    @Autowired
    private TournamentDbservice service;
    @Autowired
    private TournamentMapper mapper;
    @Autowired
    private TournamentRepository repository;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public TournamentDto add(TournamentDto tournamentDto) {
        Tournament tournament = repository.save(mapper.mapToTournament(tournamentDto));
        return mapper.mapToTournamentDto(tournament);
    }

    @GetMapping("/{id}")
    public TournamentDto get(@PathVariable Long id) {
        return mapper.mapToTournamentDto(repository.findById(id).get());
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public TournamentDto update(TournamentDto tournamentDto) {
        Tournament tournament = repository.save(mapper.mapToTournament(tournamentDto));
        return mapper.mapToTournamentDto(tournament);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
