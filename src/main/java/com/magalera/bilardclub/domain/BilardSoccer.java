package com.magalera.bilardclub.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "BILARDS_SOCCER")
public class BilardSoccer {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "BILARD_SOCCER_ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "BILARD_SOCCER_NUMBER")
    private Integer number;

    @NotNull
    @Column(name = "AVILABLE")
    private Boolean isAvailable;

    @ManyToOne
    @JoinColumn (name = "BILARD_CLUB_ID")
    private BilardClub bilardClub;

    @OneToOne(mappedBy = "bilardSoccer")
    private Reservation reservation;
}
