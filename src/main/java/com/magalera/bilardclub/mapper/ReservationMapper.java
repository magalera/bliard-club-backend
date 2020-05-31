package com.magalera.bilardclub.mapper;

import com.magalera.bilardclub.domain.Reservation;
import com.magalera.bilardclub.domain.ReservationDto;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    public Reservation mapToReservation(ReservationDto reservationDto) {
        return Reservation.builder()
                .id(reservationDto.getId())
                .type(reservationDto.getType())
                .startDate(reservationDto.getStartDate())
                .endDate(reservationDto.getEndDate())
                .user(reservationDto.getUser()).build();
    }

    public ReservationDto mapToReservationDto(Reservation reservation) {
        return ReservationDto.builder()
                .id(reservation.getId())
                .type(reservation.getType())
                .startDate(reservation.getStartDate())
                .endDate(reservation.getEndDate())
                .user(reservation.getUser()).build();
    }
}
