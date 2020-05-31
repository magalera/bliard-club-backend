package com.magalera.bilardclub.controller;

import com.magalera.bilardclub.domain.Reservation;
import com.magalera.bilardclub.domain.ReservationDto;
import com.magalera.bilardclub.mapper.ReservationMapper;
import com.magalera.bilardclub.repository.ReservationRepository;
import com.magalera.bilardclub.service.ReservationDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/reservation")
public class ReservationController {
    @Autowired
    private ReservationDbService service;
    @Autowired
    private ReservationMapper mapper;
    @Autowired
    private ReservationRepository repository;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ReservationDto create(@RequestBody ReservationDto reservationDto){
        Reservation reservation = repository.save(mapper.mapToReservation(reservationDto));
        return mapper.mapToReservationDto(reservation);
    }

    @GetMapping("/{id}")
    public ReservationDto show(@PathVariable Long id){
        return mapper.mapToReservationDto(repository.findById(id).get());
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public ReservationDto update(@RequestBody ReservationDto reservationDto){
        Reservation reservation = repository.save(mapper.mapToReservation(reservationDto));
        return mapper.mapToReservationDto(reservation);
    }

    @DeleteMapping("/{id}")
    public void cancel(@PathVariable Long id){
        repository.deleteById(id);
    }
}
