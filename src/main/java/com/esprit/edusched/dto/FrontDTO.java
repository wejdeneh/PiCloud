package com.esprit.edusched.dto;

import com.esprit.edusched.entities.OffreEtat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class FrontDTO {

    private int id_offre;
    private String description;
    private Date dateOffre;
    private String affiche;
    private OffreEtat etat;


    public FrontDTO(int id_offre, String description, Date dateOffre, String affiche, OffreEtat etat) {
        this.id_offre = id_offre;
        this.description = description;
        this.dateOffre = dateOffre;
        this.affiche = affiche;
        this.etat = etat;
    }

}
