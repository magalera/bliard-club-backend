package com.magalera.bilardclub.repository;

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

    @Test
    public void testTournamentRepositorySave() {
        /*// Given
        Tournament tournament = Tournament.builder().build();

        // When
        Tournament saved = tournamentRepository.save(tournament);
        Long id = saved.getId();
        Optional<Tournament> byId = tournamentRepository.findById(id);

        // Then
        Assert.assertTrue(byId.isPresent());

        // CleanUp
        //tournamentRepository.deleteById(id);*/
    }
}