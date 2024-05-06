package com.esprit.edusched.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name = "coachs")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Coach  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_coach;

    // La relation one-to-many avec l'entité Offre
    @JsonIgnore
    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL)
    private List<Offre> offres;

    @Override
    public String toString() {
        return "Coach{" +
                "id_coach=" + id_coach +
                '}';
    }
}
