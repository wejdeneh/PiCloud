package com.esprit.edusched.entities.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;



    @Builder
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public class User implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String email;
        private String password;
        @Lob
        @Column(length = 10000)
        private byte[] image;
        private String file_name;}

