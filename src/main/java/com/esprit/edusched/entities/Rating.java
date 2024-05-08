package com.esprit.edusched.entities;

import com.esprit.edusched.entities.Offre;
import com.esprit.edusched.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ratings")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rating implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int rating;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    public Rating(User user, Offre offre, int rating) {
        this.user = user;
        this.offre = offre;
        this.rating = rating;
        this.timestamp = new Date();
    }

    // getters and setters

    // constructors

    // equals, hashCode, and toString methods
}
