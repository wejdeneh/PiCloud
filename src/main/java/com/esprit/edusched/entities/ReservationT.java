package com.esprit.edusched.entities;

import com.esprit.edusched.enums.Etat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "reservationT")
public class ReservationT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResT;
    private Date date_debut;
    private Date date_fin;
    @Enumerated(EnumType.STRING)
    private Etat etat;

    @ManyToOne
    @JoinColumn(name="id_terrain",nullable = true)
    private Terrain terrain;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;


    /*@ManyToOne
    @JoinColumn(name = "id_user",nullable = true)
    private User user;*/

}
