package com.magalera.bilardclub.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class BilardClubDto {
    private Long id;
    private String name;
    private List<TableDto> tables;
    private List<BilardSoccerDto> bilardSoccers;
    private TournamentDto tournament;
    private CityDto city;
    private PricesDto prices;
}
