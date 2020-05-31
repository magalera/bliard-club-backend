package com.magalera.bilardclub.controller;

import com.google.gson.Gson;
import com.magalera.bilardclub.domain.*;
import com.magalera.bilardclub.mapper.BilardClubMapper;
import com.magalera.bilardclub.repository.BilardClubRepository;
import com.magalera.bilardclub.service.BilardClubDbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static java.util.Optional.of;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BilardClubController.class)
public class BilardClubControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BilardClubRepository repository;
    @MockBean
    private BilardClubDbService service;
    @MockBean
    private BilardClubMapper mapper;

    @Test
    public void add() throws Exception {
        // Given
        City city = City.builder().id(1L).name("Kielce").build();
        CityDto cityDto = CityDto.builder().id(1L).name("Kielce").build();
        BilardClub bilardClub = BilardClub.builder().name("Bilard KCK").city(city).prices(new Prices()).build();
        BilardClubDto bilardClubDto = BilardClubDto.builder().name("Bilard KCK").city(cityDto).prices(new PricesDto()).build();

        when(repository.save(bilardClub)).thenReturn(bilardClub);
        when(mapper.mapToBilardClubDto(bilardClub)).thenReturn(bilardClubDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(bilardClubDto);

        // When & Then
        mockMvc.perform(post("/v1/bilardClub")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void testGet() throws Exception {
        // Given
        City city = City.builder().id(1L).name("Kielce").build();
        CityDto cityDto = CityDto.builder().id(1L).name("Kielce").build();
        Prices prices = Prices.builder().id(1L).tablePrice(6.0).bilardSoccerPrice(12.0).tournamentPrice(135.0).build();
        PricesDto pricesDto = PricesDto.builder().id(1L).tablePrice(6.0).bilardSoccerPrice(12.0).tournamentPrice(135.0).build();
        BilardClub bilardClub = BilardClub.builder().id(12L).name("Bilard KCK").city(city).prices(prices).build();
        BilardClubDto bilardClubDto = BilardClubDto.builder().id(12L).name("Bilard KCK").city(cityDto).prices(pricesDto).build();

        when(repository.findById(bilardClub.getId())).thenReturn(of(bilardClub));
        when(mapper.mapToBilardClubDto(bilardClub)).thenReturn(bilardClubDto);

        // When & Then
        mockMvc.perform(get("/v1/bilardClub/" + bilardClub.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(bilardClub.getId().intValue())))
                .andExpect(jsonPath("$.name", is(bilardClub.getName())))
                .andExpect(jsonPath("$.city.id", is(bilardClub.getCity().getId().intValue())))
                .andExpect(jsonPath("$.city.name", is(bilardClub.getCity().getName())))
                .andExpect(jsonPath("$.prices.id", is(bilardClub.getPrices().getId().intValue())))
                .andExpect(jsonPath("$.prices.tablePrice", is(bilardClub.getPrices().getTablePrice())))
                .andExpect(jsonPath("$.prices.bilardSoccerPrice", is(bilardClub.getPrices().getBilardSoccerPrice())))
                .andExpect(jsonPath("$.prices.tournamentPrice", is(bilardClub.getPrices().getTournamentPrice())));
    }

    @Test
    public void testUpdate() throws Exception {
        // Given
        City city = City.builder().id(1L).name("Kielce").build();
        CityDto cityDto = CityDto.builder().id(1L).name("Kielce").build();
        BilardClub bilardClub = BilardClub.builder().name("Bilard KCK Kielce").city(city).prices(new Prices()).build();
        BilardClubDto bilardClubDto = BilardClubDto.builder().name("Bilard KCK Kielce").city(cityDto).prices(new PricesDto()).build();

        when(repository.save(bilardClub)).thenReturn(bilardClub);
        when(mapper.mapToBilardClubDto(bilardClub)).thenReturn(bilardClubDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(bilardClubDto);

        // When & Then
        mockMvc.perform(put("/v1/bilardClub")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        // Given
        City city = City.builder().id(1L).name("Kielce").build();
        BilardClub bilardClub = BilardClub.builder().id(1L).name("Bilard KCK Kielce").city(city).prices(new Prices()).build();

        when(repository.findById(bilardClub.getId())).thenReturn(Optional.of(bilardClub));

        // When & Then
        mockMvc.perform(delete("/v1/bilardClub/" + bilardClub.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}