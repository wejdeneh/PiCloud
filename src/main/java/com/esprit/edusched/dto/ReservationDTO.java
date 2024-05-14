package com.esprit.edusched.dto;

import com.esprit.edusched.entities.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationDTO {
    private Long id;
    private int idOffre;
    private Long idUtilisateur;
    private LocalDateTime reservationDate;
    private ReservationStatus status;


}
