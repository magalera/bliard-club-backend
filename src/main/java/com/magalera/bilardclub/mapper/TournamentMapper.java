package com.magalera.bilardclub.mapper;

import com.magalera.bilardclub.domain.Tournament;
import com.magalera.bilardclub.domain.TournamentDto;
import org.springframework.stereotype.Component;

@Component
public class TournamentMapper {

    public Tournament mapToTournament(TournamentDto tournamentDto) {
        return Tournament.builder()
                .id(tournamentDto.getId()).build();
    }

    public TournamentDto mapToTournamentDto(Tournament tournament) {
        return TournamentDto.builder()
                .id(tournament.getId()).build();
    }
}