package com.magalera.bilardclub.repository;

import com.magalera.bilardclub.domain.BilardSoccer;
import com.magalera.bilardclub.domain.Table;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BilardSoccerRepositoryTestSuite {
    @Autowired
    private BilardSoccerRepository bilardSoccerRepository;

    @Test
    public void testBilardSoccerRepositorySave() {
/*
        // Given
        BilardSoccer bilardSoccer = BilardSoccer.builder().number(4).isAvailable(true).build();

        // When
        BilardSoccer actual = bilardSoccerRepository.save(bilardSoccer);

        // Then
        Long id = actual.getId();
        Optional<BilardSoccer> byId = bilardSoccerRepository.findById(id);
        Assert.assertTrue(byId.isPresent());

        // CleanUp
        bilardSoccerRepository.deleteById(id);
    }

    @Test
    public void testBilardSoccerRepositoryfindByNumber() {

        // Given
        BilardSoccer bilardSoccer = BilardSoccer.builder().number(6).isAvailable(true).build();

        // When
        BilardSoccer saved = bilardSoccerRepository.save(bilardSoccer);
        BilardSoccer actual = bilardSoccerRepository.findBilardSoccerByNumber(saved.getNumber());

        // Then
        Assert.assertEquals(Optional.of(6), Optional.of(actual.getNumber()));

        // CleanUp
        bilardSoccerRepository.deleteById(saved.getId());*/
    }

}