package com.esprit.edusched.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Vote implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long voteId ;
    private int note ;
    @ManyToOne
    @JsonIgnore
    private Team team;
    @ManyToOne
    @JsonIgnore
    private Competition competition;
    /*@ManyToOne
    private User user ;*/

}
