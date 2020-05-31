package com.magalera.bilardclub.mapper;

import com.magalera.bilardclub.domain.BilardSoccer;
import com.magalera.bilardclub.domain.BilardSoccerDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<BilardSoccer> mapToBilardsSoccer(List<BilardSoccerDto> bilardsSoccerDto) {
        List<BilardSoccer> bilardsSoccer = new ArrayList<>();
        for (int i = 0; i < bilardsSoccerDto.size(); i++) {
            bilardsSoccer.add(BilardSoccer.builder().id(bilardsSoccerDto.get(i).getId())
                    .number(bilardsSoccerDto.get(i).getNumber()).isAvailable(bilardsSoccerDto.get(i).getIsAvailable()).build());
        }
        return bilardsSoccer;
    }

    public List<BilardSoccerDto> mapToBilardsSoccerDto(List<BilardSoccer> bilardsSoccer) {
        List<BilardSoccerDto> bilardsSoccerDto = new ArrayList<>();
        for (int i = 0; i < bilardsSoccer.size(); i++) {
            bilardsSoccerDto.add(BilardSoccerDto.builder().id(bilardsSoccer.get(i).getId())
                    .number(bilardsSoccer.get(i).getNumber()).isAvailable(bilardsSoccer.get(i).getIsAvailable()).build());
        }
        return bilardsSoccerDto;
    }
}
