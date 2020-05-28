package com.magalera.bilardclub.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BilardSoccerDto {
    private Long id;
    private Integer number;
    private Boolean isAvailable;
}
