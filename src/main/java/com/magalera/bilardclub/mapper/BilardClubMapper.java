package com.magalera.bilardclub.mapper;

import com.magalera.bilardclub.domain.BilardClub;
import com.magalera.bilardclub.domain.BilardClubDto;
import org.springframework.stereotype.Component;

@Component
public class BilardClubMapper {

    public BilardClub mapToBilardClub(BilardClubDto bilardClubDto) {
        return BilardClub.builder()
                .id(bilardClubDto.getId())
                .name(bilardClubDto.getName())
                .tables(bilardClubDto.getTables())
                .bilardSoccers(bilardClubDto.getBilardSoccers())
                .tournament(bilardClubDto.getTournament())
                .city(bilardClubDto.getCity())
                .prices(bilardClubDto.getPrices()).build();
    }

    public BilardClubDto mapToBilardClubDto(BilardClub bilardClub) {
        return BilardClubDto.builder()
                .id(bilardClub.getId())
                .name(bilardClub.getName())
                .tables(bilardClub.getTables())
                .bilardSoccers(bilardClub.getBilardSoccers())
                .tournament(bilardClub.getTournament())
                .city(bilardClub.getCity())
                .prices(bilardClub.getPrices()).build();
    }
}
