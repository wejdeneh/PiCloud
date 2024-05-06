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
<<<<<<< HEAD
<<<<<<< HEAD
=======
    private String qrcode;
    private Categorie categorie;
>>>>>>> origin/main
=======
    private String qrcode;
    private Categorie categorie;
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda

    @ManyToMany
    private List<Team> teams;


}
