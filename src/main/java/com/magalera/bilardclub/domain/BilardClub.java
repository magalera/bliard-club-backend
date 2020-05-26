package com.magalera.bilardclub.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity(name = "BILARD_CLUBS")
public class BilardClub {
    @Id
    @GeneratedValue
    @Column(name = "BILARD_CLUB_ID", unique = true)
    private Long id;

    @Column(name = "BILARD_CLUB_NAME")
    private String name;

    @Column(name = "BILARD_CLUB_TABLES")
    @OneToMany(
            targetEntity = Table.class,
            mappedBy = "bilardClub",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Table> tables;

    @Column(name = "BILARD_CLUB_BILARDS_SOCCER")
    @OneToMany(
            targetEntity = BilardSoccer.class,
            mappedBy = "bilardClub",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<BilardSoccer> bilardSoccers;

    @OneToOne(mappedBy = "bilardClub")
    private Tournament tournament;

    @ManyToOne
    @JoinColumn(name = "CITY_ID")
    private City city;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "PRICES_ID")
    private Prices prices;
}
