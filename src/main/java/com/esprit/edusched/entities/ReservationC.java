package com.esprit.edusched.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "reservationc")
public class ReservationC implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idR;
    @Temporal(TemporalType.DATE)
    private Date startd;
    @Temporal(TemporalType.DATE)
    private Date finald;
    private String state;
}
