package com.esprit.edusched.dto;

import com.esprit.edusched.entities.Categorie;
import lombok.Builder;

@Builder
public record saveReservationDTO(String nom, Categorie categorie, String date_debut, String date_fin, Integer terrain) {
}
