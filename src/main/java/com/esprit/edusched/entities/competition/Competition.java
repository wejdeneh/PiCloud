package com.esprit.edusched.entities.competition;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Competition implements Serializable  {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long competitionId ;
        private String nom ;
        private LocalDateTime dateDebut ;





}
