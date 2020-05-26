package com.magalera.bilardclub.repository;

import com.magalera.bilardclub.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;

@Transactional
@Commit
@RunWith(SpringRunner.class)
@SpringBootTest
public class BilardClubRepositoryTestSuite {
    @Autowired
    private BilardClubRepository bilardClubRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private TournamentRepository tournamentRepository;
    @Autowired
    private TableRepository tableRepository;
    @Autowired
    private PricesRepository pricesRepository;

    @Test
    public void testBilardClubRepositorySave() {
        // Given
        Table table1 = Table.builder().number(1).build();
        Table table2 = Table.builder().number(2).build();
        List<Table>tables = new ArrayList<>();
        tables.add(table1);
        tables.add(table2);
        tableRepository.saveAll(tables);

        City ckCity = City.builder().name("Kielce").build();
        cityRepository.save(ckCity);
        Tournament tournament = Tournament.builder().build();
        tournamentRepository.save(tournament);
        Prices prices = Prices.builder().tablePrice(8.0).bilardSoccerPrice(16.0).tournamentPrice(150.0).build();
        pricesRepository.save(prices);
        BilardClub bilardClub = BilardClub.builder().name("Bilard KCK").city(ckCity).tables(tables).tournament(tournament).prices(prices).build();
        bilardClub.getTables().add(table1);
        bilardClub.getTables().add(table2);
        table1.setBilardClub(bilardClub);
        table2.setBilardClub(bilardClub);

        // When
        BilardClub saved = bilardClubRepository.save(bilardClub);

        // Then
        Long id = saved.getId();
        Optional<BilardClub> actualClub = bilardClubRepository.findById(id);
        assertTrue(actualClub.isPresent());

        // CleanUp
    }
}