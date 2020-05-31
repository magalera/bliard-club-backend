package com.magalera.bilardclub.controller;

import com.google.gson.Gson;
import com.magalera.bilardclub.domain.Table;
import com.magalera.bilardclub.domain.TableDto;
import com.magalera.bilardclub.mapper.TableMapper;
import com.magalera.bilardclub.repository.TableRepository;
import com.magalera.bilardclub.service.TableDbService;
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
@WebMvcTest(TableController.class)
public class TableControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TableRepository repository;
    @MockBean
    private TableDbService service;
    @MockBean
    private TableMapper mapper;

    @Test
    public void testAdd() throws Exception {
        // Given
        Table table = Table.builder().number(5).build();
        TableDto tableDto = TableDto.builder().number(5).build();

        when(repository.save(table)).thenReturn(table);
        when(mapper.mapToTableDto(table)).thenReturn(tableDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(tableDto);

        // When & Then
        mockMvc.perform(post("/v1/table")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void testGet() throws Exception {
        // Given
        Table table = Table.builder().id(3L).number(5).build();
        TableDto tableDto = TableDto.builder().id(3L).number(5).build();

        when(repository.findById(table.getId())).thenReturn(of(table));
        when(mapper.mapToTableDto(table)).thenReturn(tableDto);

        // When & Then
        mockMvc.perform(get("/v1/table/" + table.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(table.getId().intValue())))
                .andExpect(jsonPath("$.number", is(table.getNumber())));
    }

    @Test
    public void testUpdate() throws Exception {
        // Given
        Table table = Table.builder().id(2L).number(5).build();
        TableDto tableDto = TableDto.builder().id(2L).number(5).build();

        when(repository.save(table)).thenReturn(table);
        when(mapper.mapToTableDto(table)).thenReturn(tableDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(tableDto);

        // When & Then
        mockMvc.perform(put("/v1/table")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        // Given
        Table table = Table.builder().id(2L).number(5).build();

        when(repository.findById(table.getId())).thenReturn(of(table));

        // When & Then
        mockMvc.perform(delete("/v1/table/" + table.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}