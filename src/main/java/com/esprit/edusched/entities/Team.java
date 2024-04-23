package com.esprit.edusched.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Team implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTeam ;
    private String nom;

    @OneToMany(mappedBy = "team")
    private List<Vote> votes;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "teams")
    @JsonIgnore
    private List<Competition> competitions ;

}
