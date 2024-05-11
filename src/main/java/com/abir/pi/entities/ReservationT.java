package com.abir.pi.entities;

import com.abir.pi.enums.Etat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.core.annotation.Order;

import java.util.Date;
import java.util.List;

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
    private int nbre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_terrain",nullable = true)
    private Terrain terrain;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_User",nullable = true)
    private User user;

}