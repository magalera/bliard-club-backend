package com.magalera.bilardclub.controller;

import com.magalera.bilardclub.domain.Table;
import com.magalera.bilardclub.domain.TableDto;
import com.magalera.bilardclub.mapper.TableMapper;
import com.magalera.bilardclub.repository.TableRepository;
import com.magalera.bilardclub.service.TableDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/table")
public class TableController {
    @Autowired
    private TableDbService service;
    @Autowired
    private TableMapper mapper;
    @Autowired
    private TableRepository repository;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public TableDto add(TableDto tableDto) {
        Table table = repository.save(mapper.mapToTable(tableDto));
        return mapper.mapToTableDto(table);
    }

    @GetMapping("/{id}")
    public TableDto get(@PathVariable Long id) {
        return mapper.mapToTableDto(repository.findById(id).get());
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public TableDto update(TableDto tableDto) {
        Table table = repository.save(mapper.mapToTable(tableDto));
        return mapper.mapToTableDto(table);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
