package com.magalera.bilardclub.mapper;

import com.magalera.bilardclub.domain.City;
import com.magalera.bilardclub.domain.CityDto;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {

    public City mapToCity(CityDto cityDto) {
        return City.builder()
                .id(cityDto.getId())
                .name(cityDto.getName()).build();
    }

    public CityDto mapToCityDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName()).build();
    }
}
