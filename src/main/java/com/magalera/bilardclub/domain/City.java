package com.magalera.bilardclub.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "CITIES")
public class City {

    @Id
    @GeneratedValue
    @Column(name = "CITY_ID", unique = true)
    private Long id;

    @Column(name = "CITY_BILARD_CLUBS")
    @OneToMany(
            targetEntity = BilardClub.class,
            mappedBy = "city",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<BilardClub> clubs;
}
