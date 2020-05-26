package com.magalera.bilardclub.repository;

import com.magalera.bilardclub.domain.Table;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TableRepositoryTestSuite {

    @Autowired
    private TableRepository tableRepository;

    @Test
    public void testTableRepositorySave() {
        // Given
        Table table = Table.builder().number(2).build();

        // When
        Table saved = tableRepository.save(table);

        // Then
        Long id = saved.getId();
        Optional<Table> actualTable = tableRepository.findById(id);
        Assert.assertTrue(actualTable.isPresent());

        // CleanUp
        tableRepository.deleteById(id);
    }
}