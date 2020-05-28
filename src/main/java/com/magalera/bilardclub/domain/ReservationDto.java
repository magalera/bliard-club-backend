package com.magalera.bilardclub.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
public class ReservationDto {
    private Long id;
    private ReservationType type;
    private Timestamp startDate;
    private Timestamp endDate;
}
