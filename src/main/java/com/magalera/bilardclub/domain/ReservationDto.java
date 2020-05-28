package com.magalera.bilardclub.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@Getter
public class ReservationDto {
    private Long id;
    private ReservationType type;
    private Timestamp startDate;
    private Timestamp endDate;
}
