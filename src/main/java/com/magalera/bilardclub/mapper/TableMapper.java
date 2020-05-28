package com.magalera.bilardclub.mapper;

import com.magalera.bilardclub.domain.Table;
import com.magalera.bilardclub.domain.TableDto;
import org.springframework.stereotype.Component;

@Component
public class TableMapper {

    public Table mapToTable(TableDto tableDto) {
        return Table.builder()
                .id(tableDto.getId())
                .number(tableDto.getNumber()).build();
    }

    public TableDto mapToTableDto(Table table) {
        return TableDto.builder()
                .id(table.getId())
                .number(table.getNumber()).build();
    }
}
