package com.esprit.edusched.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "user_action_history")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserActionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "action")
    private String action;

    @Column(name = "timestamp")
    private Date timestamp;

    // Constructeurs, getters, setters
}

