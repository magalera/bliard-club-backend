package com.magalera.bilardclub.repository;

import com.magalera.bilardclub.domain.Table;
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
public class TableRepositoryTestSuite {

    @Autowired
    private TableRepository tableRepository;

    @Test
    public void testTableRepositorySave() {
/*
        // Given
        Table table = Table.builder().number(8).build();

        // When
        tableRepository.save(table);

        // Then
        Long id = table.getId();
        Optional<Table> byId = tableRepository.findById(id);
        Assert.assertTrue(byId.isPresent());

        // CleanUp
       tableRepository.deleteById(id);
    }

    @Test
    public void testTableRepositoryfindByNumber() {

        // Given
        Table table = Table.builder().number(2).build();

        // When
        Table saved = tableRepository.save(table);
        Table byNumber = tableRepository.findByNumber(saved.getNumber());

        // Then
        Assert.assertEquals(Optional.of(2), Optional.of(byNumber.getNumber()));

        // CleanUp
        tableRepository.deleteById(saved.getId());*/
    }
}