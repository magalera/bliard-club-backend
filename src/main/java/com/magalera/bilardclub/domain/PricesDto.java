package com.magalera.bilardclub.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PricesDto {
    private Long id;
    private Double tablePrice;
    private Double bilardSoccerPrice;
    private Double tournamentPrice;
}
