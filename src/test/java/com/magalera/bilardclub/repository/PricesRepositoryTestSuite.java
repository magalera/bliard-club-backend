package com.magalera.bilardclub.repository;

import com.magalera.bilardclub.domain.Prices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PricesRepositoryTestSuite {
    @Autowired
    private PricesRepository pricesRepository;

    @Test
    public void testPricesRepositorySave() {
        // Given
        Prices prices = Prices.builder().tablePrice(6.0).bilardSoccerPrice(11.0).tournamentPrice(145.0).build();

        // When
        Prices saved = pricesRepository.save(prices);

        // Then
        Long id = saved.getId();
        Optional<Prices> actualPrices = pricesRepository.findById(id);
        assertTrue(actualPrices.isPresent());

        // CleanUp
        pricesRepository.deleteById(id);
    }
}