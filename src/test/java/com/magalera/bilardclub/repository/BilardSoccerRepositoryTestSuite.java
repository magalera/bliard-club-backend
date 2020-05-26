package com.magalera.bilardclub.repository;

import com.magalera.bilardclub.domain.BilardSoccer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;


@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class BilardSoccerRepositoryTestSuite {
    @Autowired
    private BilardSoccerRepository bilardSoccerRepository;

    @Test
    public void testBilardSoccerRepositorySave() {
        // Given
        BilardSoccer bilardSoccer = BilardSoccer.builder().number(3).isAvailable(true).build();

        // When
        BilardSoccer saved = bilardSoccerRepository.save(bilardSoccer);

        // Then
        Long id = saved.getId();
        Optional<BilardSoccer> actualBS = bilardSoccerRepository.findById(id);
        Assert.assertTrue(actualBS.isPresent());

        // CleanUp
        bilardSoccerRepository.deleteById(id);
    }
}