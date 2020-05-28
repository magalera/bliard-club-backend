package com.magalera.bilardclub.mapper;

import com.magalera.bilardclub.domain.Prices;
import com.magalera.bilardclub.domain.PricesDto;
import org.springframework.stereotype.Component;

@Component
public class PricesMapper {

    public Prices mapToPrices(PricesDto pricesDto) {
        return Prices.builder()
                .id(pricesDto.getId())
                .tablePrice(pricesDto.getTablePrice())
                .bilardSoccerPrice(pricesDto.getBilardSoccerPrice())
                .tournamentPrice(pricesDto.getTournamentPrice()).build();
    }

    public PricesDto mapToPricesDto(Prices prices) {
        return PricesDto.builder()
                .id(prices.getId())
                .tablePrice(prices.getTablePrice())
                .bilardSoccerPrice(prices.getBilardSoccerPrice())
                .tournamentPrice(prices.getTournamentPrice()).build();
    }
}
