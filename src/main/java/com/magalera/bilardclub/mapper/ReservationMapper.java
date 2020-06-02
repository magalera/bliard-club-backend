package com.magalera.bilardclub.mapper;

import com.magalera.bilardclub.domain.Reservation;
import com.magalera.bilardclub.domain.ReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class ReservationMapper {
    @Autowired
    private UserMapper userMapper;

    public Reservation mapToReservation(ReservationDto reservationDto) {
        return Reservation.builder()
                .id(reservationDto.getId())
                .type(reservationDto.getType())
                .startDate(new Timestamp(reservationDto.getStartDate()))
                .endDate(new Timestamp(reservationDto.getEndDate()))
                .user(userMapper.mapToUser(reservationDto.getUser())).build();
    }

    public ReservationDto mapToReservationDto(Reservation reservation) {
        return ReservationDto.builder()
                .id(reservation.getId())
                .type(reservation.getType())
                .startDate(reservation.getStartDate().getTime())
                .endDate(reservation.getEndDate().getTime())
                .user(userMapper.mapToUserDto(reservation.getUser())).build();
    }
}
