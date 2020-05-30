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
@Entity(name = "USERS")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "USER_ID", unique = true)
    private Long id;

    @NotNull
    private UserType type;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    @OneToOne(mappedBy = "user")
    private Reservation reservation;
}
