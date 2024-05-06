package com.esprit.edusched.entities;

<<<<<<< HEAD
public class Role {
    private enumRole role;

=======

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private enumRole role;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
>>>>>>> origin/main
}
