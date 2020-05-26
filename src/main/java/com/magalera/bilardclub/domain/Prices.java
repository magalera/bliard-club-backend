package com.magalera.bilardclub.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "PRICES")
public class Prices {
    @Id
    @GeneratedValue
    @Column(name = "PRICES_ID", unique = true)
    private Long id;

    private Double tablePrice;

    private Double bilardSoccerPrice;

    private Double tournamentPrice;

    @OneToOne(mappedBy = "prices")
    private BilardClub bilardClub;

}
