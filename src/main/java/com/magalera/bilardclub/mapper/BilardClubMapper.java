package com.magalera.bilardclub.mapper;

import com.magalera.bilardclub.domain.BilardClub;
import com.magalera.bilardclub.domain.BilardClubDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BilardClubMapper {
    @Autowired
    private TableMapper tableMapper;
    @Autowired
    private BilardSoccerMapper bilardSoccerMapper;
    @Autowired
    private TournamentMapper tournamentMapper;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private PricesMapper pricesMapper;

    public BilardClub mapToBilardClub(BilardClubDto bilardClubDto) {
        return BilardClub.builder()
                .id(bilardClubDto.getId())
                .name(bilardClubDto.getName())
                .tables(tableMapper.mapToTables(bilardClubDto.getTables()))
                .bilardSoccers(bilardSoccerMapper.mapToBilardsSoccer(bilardClubDto.getBilardSoccers()))
                .tournament(tournamentMapper.mapToTournament(bilardClubDto.getTournament()))
                .city(cityMapper.mapToCity(bilardClubDto.getCity()))
                .prices(pricesMapper.mapToPrices(bilardClubDto.getPrices())).build();
    }

    public BilardClubDto mapToBilardClubDto(BilardClub bilardClub) {
        return BilardClubDto.builder()
                .id(bilardClub.getId())
                .name(bilardClub.getName())
                .tables(tableMapper.mapToTablesDto(bilardClub.getTables()))
                .bilardSoccers(bilardSoccerMapper.mapToBilardsSoccerDto(bilardClub.getBilardSoccers()))
                .tournament(tournamentMapper.mapToTournamentDto(bilardClub.getTournament()))
                .city(cityMapper.mapToCityDto(bilardClub.getCity()))
                .prices(pricesMapper.mapToPricesDto(bilardClub.getPrices())).build();
    }
}
