package com.magalera.bilardclub.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "RESERVATIONS")
public class Reservation {
    @Id
    @GeneratedValue
    @Column(name = "RESERVATION_ID", unique = true)
    private Long id;

    private ReservationType type;

    private LocalDate startDate;

    private LocalDate endDate;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "TABLE_ID")
    private Table table;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "BILARD_SOCCER_ID")
    private BilardSoccer bilardSoccer;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "TOURNAMENT_ID")
    private Tournament tournament;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "USER_ID")
    private User user;

}
