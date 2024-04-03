package com.esprit.edusched.entities;

import jakarta.persistence.*;
import lombok.*;

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

    @OneToMany(mappedBy = "user")
    private List<ReservationT> reservationTS;
    /*@ManyToOne
    @JoinColumn(name="id_user",nullable = true)
    private ReservationT reservationT;*/
}
