package com.magalera.bilardclub.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "TABLES")
public class Table {

    @Id
    @GeneratedValue
    @Column(name = "TABLE_ID", unique = true)
    private Long id;

    @NotNull
    private Integer number;

    @ManyToOne
    @JoinColumn (name = "BILARD_CLUB_ID")
    private BilardClub bilardClub;

    @ManyToOne
    @JoinColumn (name = "TOURNAMENT_ID")
    private Tournament tournament;

    @OneToOne(mappedBy = "table")
    private Reservation reservation;

}
