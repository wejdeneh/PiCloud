package com.esprit.edusched.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Column(name = "idR")
    private Long idR;
    @Temporal(TemporalType.DATE)
    private Date startd;
    @Temporal(TemporalType.DATE)
    private Date finald;
    private String state;
    @ManyToOne
    @JoinColumn(name = "idC")
    @JsonIgnoreProperties({"reservationCS"})
    private Class clas;


}
