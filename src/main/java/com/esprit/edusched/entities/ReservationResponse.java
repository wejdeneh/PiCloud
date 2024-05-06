package com.esprit.edusched.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReservationResponse {
    private Long id;
    private int offreId;
    private Long userId;
    private LocalDateTime dateReservation;
    private String status;
}
