
package com.esprit.edusched.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@Entity
@Table(name = "reservationc")
public class ReservationC implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idR")
    private Long idR;
    @Temporal(TemporalType.DATE)
    private LocalDate startd;
    private LocalTime startHour;
    private LocalTime finalHour;
    @Temporal(TemporalType.DATE)

    private LocalDate finald;

    private String state;
    @ManyToOne
    @JoinColumn(name = "idC")
    private Class clas;


}