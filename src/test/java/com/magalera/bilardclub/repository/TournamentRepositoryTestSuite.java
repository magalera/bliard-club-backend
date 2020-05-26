package com.magalera.bilardclub.repository;

import com.magalera.bilardclub.domain.BilardClub;
import com.magalera.bilardclub.domain.City;
import com.magalera.bilardclub.domain.Table;
import com.magalera.bilardclub.domain.Tournament;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TournamentRepositoryTestSuite {
    @Autowired
    private TournamentRepository tournamentRepository;
    @Autowired
    private CityRepository cityRepository;

    @Test
    public void testTournamentRepositorySave() {
        // Given
        City ckCity = City.builder().name("Kielce").build();
        cityRepository.save(ckCity);
        BilardClub bilardClub = BilardClub.builder().name("KCK ck").city(ckCity).build();
        Tournament tournament = Tournament.builder().bilardClub(bilardClub).build();

        // When
        Tournament saved = tournamentRepository.save(tournament);

        // Then
        Long id = saved.getId();
        Optional<Tournament> actualTournament = tournamentRepository.findById(id);
        Assert.assertTrue(actualTournament.isPresent());

        // CleanUp
        //tournamentRepository.deleteById(id);
    }
}