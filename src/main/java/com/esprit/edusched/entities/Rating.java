package com.esprit.edusched.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int value;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_User",nullable = true)
    private User user;
}
