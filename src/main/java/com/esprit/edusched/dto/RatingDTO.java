package com.esprit.edusched.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;

@Data

public class RatingDTO {
    private int id;
    private int idOffre;
    private Long idUser;
    private int rating;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;



    public RatingDTO(int id, int idOffre, Long idUser, int rating) {
        this.id = id;
        this.idOffre = idOffre;
        this.idUser = idUser;
        this.rating = rating;
    }

    // getters and setters

    // equals, hashCode, and toString methods
}