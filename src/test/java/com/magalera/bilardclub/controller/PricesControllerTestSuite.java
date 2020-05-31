package com.magalera.bilardclub.controller;

import com.google.gson.Gson;
import com.magalera.bilardclub.domain.BilardSoccer;
import com.magalera.bilardclub.domain.BilardSoccerDto;
import com.magalera.bilardclub.domain.Prices;
import com.magalera.bilardclub.domain.PricesDto;
import com.magalera.bilardclub.mapper.BilardSoccerMapper;
import com.magalera.bilardclub.mapper.PricesMapper;
import com.magalera.bilardclub.repository.BilardSoccerRepository;
import com.magalera.bilardclub.repository.PricesRepository;
import com.magalera.bilardclub.service.BilardSoccerDbService;
import com.magalera.bilardclub.service.PricesDbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Optional.of;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PricesController.class)
public class PricesControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PricesRepository repository;
    @MockBean
    private PricesDbService service;
    @MockBean
    private PricesMapper mapper;

    @Test
    public void testAdd() throws Exception {
        // Given
        Prices prices = Prices.builder().tablePrice(8.0).bilardSoccerPrice(16.0).tournamentPrice(150.0).build();
        PricesDto pricesDto = PricesDto.builder().tablePrice(8.0).bilardSoccerPrice(16.0).tournamentPrice(150.0).build();

        when(repository.save(prices)).thenReturn(prices);
        when(mapper.mapToPricesDto(prices)).thenReturn(pricesDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(pricesDto);

        // When & Then
        mockMvc.perform(post("/v1/prices")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void testShow() throws Exception {
        // Given
        Prices prices = Prices.builder().id(4L).tablePrice(8.0).bilardSoccerPrice(16.0).tournamentPrice(150.0).build();
        PricesDto pricesDto = PricesDto.builder().id(4L).tablePrice(8.0).bilardSoccerPrice(16.0).tournamentPrice(150.0).build();

        when(repository.findById(prices.getId())).thenReturn(of(prices));
        when(mapper.mapToPricesDto(prices)).thenReturn(pricesDto);

        // When & Then
        mockMvc.perform(get("/v1/prices/" + prices.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(prices.getId().intValue())))
                .andExpect(jsonPath("$.tablePrice", is(prices.getTablePrice())))
                .andExpect(jsonPath("$.bilardSoccerPrice", is(prices.getBilardSoccerPrice())))
                .andExpect(jsonPath("$.tournamentPrice", is(prices.getTournamentPrice())));
    }

    @Test
    public void testUpdate() throws Exception {
        // Given
        Prices prices = Prices.builder().id(4L).tablePrice(7.0).bilardSoccerPrice(16.0).tournamentPrice(145.0).build();
        PricesDto pricesDto = PricesDto.builder().id(4L).tablePrice(7.0).bilardSoccerPrice(16.0).tournamentPrice(145.0).build();

        when(repository.save(prices)).thenReturn(prices);
        when(mapper.mapToPricesDto(prices)).thenReturn(pricesDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(pricesDto);

        // When & Then
        mockMvc.perform(put("/v1/prices")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        // Given
        Prices prices = Prices.builder().id(4L).tablePrice(7.0).bilardSoccerPrice(16.0).tournamentPrice(145.0).build();

        when(repository.findById(prices.getId())).thenReturn(of(prices));

        // When & Then
        mockMvc.perform(delete("/v1/prices/" + prices.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}