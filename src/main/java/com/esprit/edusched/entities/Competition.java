package com.esprit.edusched.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Competition implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long competitionId ;
    private String nom ;
    private LocalDateTime dateDebut ;
    private String qrcode;
    private Categorie categorie;

    @ManyToMany
    private List<Team> teams;


}
