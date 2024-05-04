package com.esprit.edusched.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="terrain")
public class Terrain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTerrain;
    private String name;
    private String description;
    @OneToMany(mappedBy = "terrain")
    @JsonIgnore
    private List<ReservationT> reservationTS;
    private double latitude;
    private double longtitude;


}
