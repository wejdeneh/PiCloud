package com.esprit.edusched.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// React.java
@Entity
@Table(name = "reacts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class React {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;

    @Enumerated(EnumType.STRING)
    private ReactType reactType;

    private LocalDateTime timestamp;

    public void setOffreId(int offreId) {
        this.offre.setId_offre(offreId);
    }

    public void setUserId(int userId) {
    }

    // Getters and setters
}

