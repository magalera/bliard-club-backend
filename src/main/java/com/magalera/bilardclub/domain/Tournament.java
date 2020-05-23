package com.magalera.bilardclub.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "TOURNAMENTS")
public class Tournament {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "TOURNAMENT_ID", unique = true)
    private Long id;
    
    @Column(name = "TOURNAMENT_TABLES")
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
}
