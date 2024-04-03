package com.esprit.edusched.entities;

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
    private List<ReservationT> reservationTS;


}
