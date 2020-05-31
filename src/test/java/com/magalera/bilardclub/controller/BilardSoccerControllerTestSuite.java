package com.magalera.bilardclub.controller;

import com.google.gson.Gson;
import com.magalera.bilardclub.domain.BilardSoccer;
import com.magalera.bilardclub.domain.BilardSoccerDto;
import com.magalera.bilardclub.mapper.BilardSoccerMapper;
import com.magalera.bilardclub.repository.BilardSoccerRepository;
import com.magalera.bilardclub.service.BilardSoccerDbService;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BilardSoccerController.class)
public class BilardSoccerControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BilardSoccerRepository repository;
    @MockBean
    private BilardSoccerDbService service;
    @MockBean
    private BilardSoccerMapper mapper;

    @Test
    public void testAdd() throws Exception {
        // Given
        BilardSoccer bilardSoccer = BilardSoccer.builder().number(2).isAvailable(true).build();
        BilardSoccerDto bilardSoccerDto = BilardSoccerDto.builder().number(2).isAvailable(true).build();

        when(repository.save(bilardSoccer)).thenReturn(bilardSoccer);
        when(mapper.mapToBilardSoccerDto(bilardSoccer)).thenReturn(bilardSoccerDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(bilardSoccerDto);

        // When & Then
        mockMvc.perform(post("/v1/bilardSoccer")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void testGet() throws Exception {
        // Given
        BilardSoccer bilardSoccer = BilardSoccer.builder().id(1L).number(0).isAvailable(false).build();
        BilardSoccerDto bilardSoccerDto = BilardSoccerDto.builder().id(1L).number(0).isAvailable(false).build();

        when(repository.findById(bilardSoccer.getId())).thenReturn(of(bilardSoccer));
        when(mapper.mapToBilardSoccerDto(bilardSoccer)).thenReturn(bilardSoccerDto);

        // When & Then
        mockMvc.perform(get("/v1/bilardSoccer/" + bilardSoccer.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(bilardSoccer.getId().intValue())))
                .andExpect(jsonPath("$.number", is(bilardSoccer.getNumber())))
                .andExpect(jsonPath("$.isAvailable", is(bilardSoccer.getIsAvailable())));
    }

    @Test
    public void testUpdate() throws Exception {
        // Given
        BilardSoccer bilardSoccer = BilardSoccer.builder().id(1L).number(0).isAvailable(false).build();
        BilardSoccerDto bilardSoccerDto = BilardSoccerDto.builder().id(1L).number(0).isAvailable(false).build();

        when(repository.save(bilardSoccer)).thenReturn(bilardSoccer);
        when(mapper.mapToBilardSoccerDto(bilardSoccer)).thenReturn(bilardSoccerDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(bilardSoccerDto);

        // When & Then
        mockMvc.perform(put("/v1/bilardSoccer")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        // Given
        BilardSoccer bilardSoccer = BilardSoccer.builder().id(1L).number(1).isAvailable(true).build();

        when(repository.findById(bilardSoccer.getId())).thenReturn(of(bilardSoccer));

        // When & Then
        mockMvc.perform(delete("/v1/bilardSoccer/" + bilardSoccer.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}