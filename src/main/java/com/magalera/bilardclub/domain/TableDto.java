package com.magalera.bilardclub.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class TableDto {
    private Long id;
    private Integer number;
}
