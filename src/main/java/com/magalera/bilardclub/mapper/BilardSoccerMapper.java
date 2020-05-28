package com.magalera.bilardclub.mapper;

import com.magalera.bilardclub.domain.BilardSoccer;
import com.magalera.bilardclub.domain.BilardSoccerDto;
import org.springframework.stereotype.Component;

@Component
public class BilardSoccerMapper {

    public BilardSoccer mapToBilardSoccer(BilardSoccerDto bilardSoccerDto) {
        return BilardSoccer.builder()
                .id(bilardSoccerDto.getId())
                .number(bilardSoccerDto.getNumber())
                .isAvailable(bilardSoccerDto.getIsAvailable()).build();
    }

    public BilardSoccerDto mapToBilardSoccerDto(BilardSoccer bilardSoccer) {
        return BilardSoccerDto.builder()
                .id(bilardSoccer.getId())
                .number(bilardSoccer.getNumber())
                .isAvailable(bilardSoccer.getIsAvailable()).build();
    }
}
