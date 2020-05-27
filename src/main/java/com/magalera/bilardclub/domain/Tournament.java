package com.magalera.bilardclub.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "TOURNAMENTS")
public class Tournament {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "TOURNAMENT_ID", unique = true)
    private Long id;

    @OneToMany(
            targetEntity = Table.class,
            mappedBy = "tournament",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Table> tables;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BILARD_CLUB_ID")
    private BilardClub bilardClub;

    @OneToOne(mappedBy = "tournament")
    private  Reservation reservation;

}
