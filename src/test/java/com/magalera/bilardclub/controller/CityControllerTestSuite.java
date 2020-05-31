package com.magalera.bilardclub.controller;

import com.magalera.bilardclub.domain.City;
import com.magalera.bilardclub.domain.CityDto;
import com.magalera.bilardclub.mapper.CityMapper;
import com.magalera.bilardclub.repository.CityRepository;

import com.magalera.bilardclub.service.CityDbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CityController.class)
public class CityControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CityRepository repository;
    @MockBean
    private CityMapper mapper;
    @MockBean
    private CityDbService service;

    @Test
    public void testGet() throws Exception {
        // Given
        City city = City.builder().id(5L).name("Warsaw").build();
        CityDto cityDto = CityDto.builder().id(5L).name("Warsaw").build();

        when(repository.findById(city.getId())).thenReturn(Optional.of(city));
        when(mapper.mapToCityDto(city)).thenReturn(cityDto);

        // When & Then
        mockMvc.perform(get("/v1/city/" + city.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(city.getId().intValue())))
                .andExpect(jsonPath("$.name", is(city.getName())));
    }
}