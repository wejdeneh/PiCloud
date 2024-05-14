package com.esprit.edusched.entities;

import com.esprit.edusched.entities.Material;
import com.esprit.edusched.entities.User;
import com.esprit.edusched.enums.Etat;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "reservationM")
public class ReservationM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResM;
    private Date date_debut;
    private Date date_fin;
    @Enumerated(EnumType.STRING)
    private Etat etat;

    @ManyToOne
    @JoinColumn(name="id_material",nullable = true)
    @JsonIgnore
    private Material material;

    @ManyToOne
    @JoinColumn(name="id_user",nullable = true)
    @JsonIgnore
    private User user;


    /*@ManyToOne
    @JoinColumn(name = "id_user",nullable = true)
    private User user;*/

}
