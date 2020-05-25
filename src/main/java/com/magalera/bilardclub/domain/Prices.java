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

    @Column(name = "TABLE_PRICE")
    private Double tablePrice;

    @Column(name = "BILARD_SOCCER_PRICE")
    private Double bilardSoccerPrice;

    @Column(name = "TOURNAMENT_PRICE")
    private Double tournamentPrice;

    @OneToOne(mappedBy = "prices")
    private BilardClub bilardClub;

}
