package com.magalera.bilardclub.mapper;

import com.magalera.bilardclub.domain.Table;
import com.magalera.bilardclub.domain.TableDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<Table> mapToTables(List<TableDto> tablesDto){
        List<Table>tables = new ArrayList<>();
        for (int i = 0; i < tablesDto.size(); i++) {
            tables.add(Table.builder().id(tablesDto.get(i).getId()).number(tablesDto.get(i).getNumber()).build());
        }
        return tables;
    }
    public List<TableDto> mapToTablesDto(List<Table> tables){
        List<TableDto>tablesDto = new ArrayList<>();
        for (int i = 0; i < tables.size(); i++) {
            tablesDto.add(TableDto.builder().id(tables.get(i).getId()).number(tables.get(i).getNumber()).build());
        }
        return tablesDto;
    }

}
