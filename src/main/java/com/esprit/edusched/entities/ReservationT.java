package com.esprit.edusched.entities;

import com.esprit.edusched.enums.Etat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "reservationT")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationT implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResT;
    private LocalDateTime date_debut;
    private LocalDateTime date_fin;
    @Enumerated(EnumType.STRING)
    private Etat etat;
    private int nbre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_terrain", nullable = true)
    private Terrain terrain;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_User", nullable = true)
    private User user;

    @OneToMany
    List<Team> teams;

    @ManyToOne
    @JsonIgnore
    Competition competition;

}
