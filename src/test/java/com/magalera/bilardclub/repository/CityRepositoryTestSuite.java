package com.magalera.bilardclub.repository;

import com.magalera.bilardclub.domain.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityRepositoryTestSuite {
    @Autowired
    private CityRepository cityRepository;

    @Test
    public void testCityRepositorySave(){
        // Given
        City city = City.builder().name("Warsaw").build();

        // When
        City saved = cityRepository.save(city);

        // Then
        Long id = saved.getId();
        Optional<City> actualCity = cityRepository.findById(id);
        assertTrue(actualCity.isPresent());

        //CleanUp
        cityRepository.deleteById(id);
    }

}