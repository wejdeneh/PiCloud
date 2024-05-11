package com.abir.pi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.security.PrivateKey;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    private String name;
    private String email;
    private String password;
    private int mobile;
    //private Role role;

    /*@OneToMany(mappedBy = "user")
    private List<ReservationT> reservationTS;
    @ManyToOne
    //@JoinColumn(name="id_user",nullable = true)
    private ReservationT reservationT;*/

    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_ReservationT",nullable = true)
    private ReservationT reservationT;*/

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<ReservationT> reservationTS;
}
