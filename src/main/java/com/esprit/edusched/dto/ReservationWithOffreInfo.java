package com.esprit.edusched.dto;

import com.esprit.edusched.entities.Offre;
import com.esprit.edusched.entities.Reservation;
import com.esprit.edusched.entities.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationWithOffreInfo {
    private Long id;
    private ReservationStatus status;
    private String offreDescription;
    private Date dateOffre;
    private String affiche;

    public ReservationWithOffreInfo(Reservation reservation, Offre offre, String affiche) {
        this.id = reservation.getId();
        this.status = reservation.getStatus();
        this.offreDescription = offre.getDescription();
        this.dateOffre = offre.getDateOffre();
       this.affiche =  offre.getAffiche();
    }
}