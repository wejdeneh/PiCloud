package com.esprit.edusched.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser ;
    private String nom ;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Vote>votes ;
}
