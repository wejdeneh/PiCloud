package com.esprit.edusched.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "classes")
public class Class  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idC;
    private int num;
    @ManyToOne(cascade = CascadeType.ALL)
    Bloc bloc;

}
