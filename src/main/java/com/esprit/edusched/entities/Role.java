package com.esprit.edusched.entities;

<<<<<<< HEAD
<<<<<<< HEAD
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
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private enumRole role;

<<<<<<< HEAD
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
=======
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
}
