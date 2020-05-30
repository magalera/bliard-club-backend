package com.magalera.bilardclub.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "CITIES")
public class City {

    @Id
    @GeneratedValue
    @Column(name = "CITY_ID", unique = true)
    private Long id;

    private String name;

   /* @OneToMany(
            targetEntity = BilardClub.class,
            mappedBy = "city",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<BilardClub> clubs;*/
}
