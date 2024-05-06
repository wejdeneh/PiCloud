package com.esprit.edusched.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "offres")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Offre implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_offre")
    private int id_offre;
    private String description;
    private Date dateOffre;
    //private boolean affiche;
    private String affiche;
    @Setter
    @JsonProperty("etat")
    @Enumerated(EnumType.STRING)

    private OffreEtat etat;



    @ManyToOne
    @JoinColumn(name = "id_coach")
    private Coach coach;
    @JsonIgnore

    @OneToMany(mappedBy = "offre", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Reservation> reservations;

    @JsonIgnore

    @OneToMany(mappedBy = "offre", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Rating> ratings;
    @JsonIgnore
    @OneToMany(mappedBy = "offre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;
    @JsonIgnore
    @OneToMany(mappedBy = "offre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<React> reacts;





   /* public int getIdOffre() {
        return id_offre;
    }*/

    @Override
    public String toString() {
        return "Offre{" +
                "id_offre=" + id_offre +
                ", description='" + description + '\'' +
                ", dateOffre=" + dateOffre +
                ", affiche='" + affiche + '\'' +
                ", etat='" + etat + '\'' +
                '}';
    }
   public int getIdOffre() {
       return this.id_offre;
   }


    public void setIdOffre(int offreId) {
    }

}
